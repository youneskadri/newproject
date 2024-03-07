package tn.esprit.crud.service;

import tn.esprit.crud.entity.Cours;
import tn.esprit.crud.repository.ICours;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.crud.repository.ICours;

@Service
public class CoursServiceImp implements CoursService {

    @Autowired
    ICours iCours;

    @Override
    public Cours addCours(Cours cours) {
        return iCours.save(cours);
    }

    @Override
    public Cours updateCours(Cours cours, String titre) {
        Cours coursToUpdate = iCours.findByTitre(titre);
        if (coursToUpdate != null) {
            coursToUpdate.setDescription(cours.getDescription());
            coursToUpdate.setDuration(cours.getDuration());
            coursToUpdate.setFormation(cours.getFormation());
            return iCours.save(coursToUpdate);
        }
        return null;
    }

    @Override
    public Cours findByTitre(String titre) {
        return iCours.findByTitre(titre);
    }

    @Override
    public List<Cours> retrieveAllCourses() {
        return iCours.findAll();
    }

    @Override
    public void deleteCoursByTitre(String titre) {
        Cours coursToDelete = iCours.findByTitre(titre);
        if (coursToDelete != null) {
            iCours.delete(coursToDelete);
        }
    }

}