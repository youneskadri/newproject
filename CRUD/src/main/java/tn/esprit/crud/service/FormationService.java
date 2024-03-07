package tn.esprit.crud.service;

import tn.esprit.crud.entity.Formation;

import java.util.List;

public interface FormationService {
    public Formation addFormation(Formation formation );
    public Formation updateFormation(Formation formation , Long idFormation);

    public Formation findById(Long idFormation);

    public List<Formation>retrieveAllFormations();

    public void deleteFormationById(Long idFormation);
}
