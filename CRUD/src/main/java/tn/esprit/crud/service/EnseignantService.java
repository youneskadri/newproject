package tn.esprit.crud.service;

import tn.esprit.crud.entity.Enseignant;
import tn.esprit.crud.entity.Formation;

import java.util.List;

public interface EnseignantService {
    public Enseignant addEnseignant (Enseignant enseignant);

    public Enseignant updateEnseignant(Enseignant enseignant , Long idEnseignant);

    public Enseignant findById(Long idEnseignant);

    public List<Enseignant> retrieveAllEnseignants();

    public void DeleteEnseignantById(Long idEnseignant);
}
