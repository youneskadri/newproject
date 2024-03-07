package tn.esprit.crud.service;

import tn.esprit.crud.entity.Cours;
import tn.esprit.crud.entity.Enseignant;

import java.util.List;

public interface CoursService {
    public Cours addCours (Cours cours);

    public Cours updateCours(Cours cours , String titre);

    public Cours findByTitre( String titre);

    public List<Cours> retrieveAllCourses();

    public void deleteCoursByTitre( String titre);
}
