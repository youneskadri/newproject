package tn.esprit.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.crud.entity.Enseignant;
import tn.esprit.crud.entity.Formation;
import tn.esprit.crud.repository.IEnseignant;

import java.util.List;

@Service

public class EnseignantImp implements EnseignantService {

    @Autowired
    IEnseignant iEnseignant;
    @Override
    public Enseignant addEnseignant(Enseignant enseignant) {
        return iEnseignant.save(enseignant);
    }

    @Override
    public Enseignant updateEnseignant(Enseignant enseignant, Long idEnseignant) {
        enseignant.setIdEnseignant(idEnseignant);
        return iEnseignant.save(enseignant);
    }

    @Override
    public Enseignant findById(Long idEnseignant)
        {
            return iEnseignant.findById(idEnseignant).orElse(null);
    }

    @Override
    public List<Enseignant> retrieveAllEnseignants() {
        List<Enseignant>enseignantList = iEnseignant.findAll();
        return enseignantList;
    }

    @Override
    public void DeleteEnseignantById(Long idEnseignant) {
        iEnseignant.deleteById(idEnseignant);
    }


}
