package tn.esprit.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.crud.entity.Formation;
import tn.esprit.crud.repository.IFormation;

import java.util.List;

@Service

public class FormationImp implements FormationService {



    @Autowired
    IFormation iFormation;
    @Override
    public Formation addFormation(Formation formation) {
        return iFormation.save(formation);
    }

    @Override
    public Formation updateFormation(Formation formation, Long idFormation) {
        formation.setIdFormation(idFormation);
        return iFormation.save(formation);
    }

    @Override
    public Formation findById(Long idFormation) {
        return iFormation.findById(idFormation).orElse(null);
    }

    @Override
    public List<Formation> retrieveAllFormations() {
        List<Formation>formationList = iFormation.findAll();
        return formationList;
    }

    @Override
    public void deleteFormationById(Long idFormation) {
        iFormation.deleteById(idFormation);

    }
}
