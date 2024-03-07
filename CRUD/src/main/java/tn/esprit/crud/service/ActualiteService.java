package tn.esprit.crud.service;

import tn.esprit.crud.entity.Actualite;
import tn.esprit.crud.entity.Cours;

import java.util.List;

public interface ActualiteService {

    public Actualite addActualite(Actualite actualite);

    public Actualite updateActualite(Actualite actualite , Long idActualite);

    public Actualite findById( Long idActualite);

    public List<Actualite> retrieveAllActualite();

    public void deleteActualiteById( Long idActualite);

    Actualite Best();
}
