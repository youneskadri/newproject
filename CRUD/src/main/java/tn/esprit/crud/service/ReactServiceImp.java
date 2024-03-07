package tn.esprit.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.crud.entity.React;
import tn.esprit.crud.repository.IReact;

@Service
public class ReactServiceImp implements  ReactService {
    @Autowired
    private IReact iReact;
@Autowired
    ActualiteService actualiteService;
    @Override
    public React AddReact(React react) {
        return iReact.save(react);
    }

    @Override
    public void add( long idActualite , String username,Boolean Statut){
        React  react = iReact.findReactByActualite_IdActualiteAndUsername(idActualite,username);
        if (react == null){
            React react1 =new React(actualiteService.findById(idActualite), username , Statut );
            iReact.save(react1);
        } else if ( react.isReaction_Type()== Statut ) {
             iReact.deleteById(react.getId());
        }else {
            react.setReaction_Type(Statut);
             iReact.save(react);
        }
    }

    @Override
    public React findById(Long id) {
        return iReact.findById(id).orElse(null);
    }


    @Override
    public void deleteCommentaireById(Long id) {
        iReact.deleteById(id);
    }
}

