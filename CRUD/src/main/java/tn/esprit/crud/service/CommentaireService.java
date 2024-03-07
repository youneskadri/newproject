package tn.esprit.crud.service;

import tn.esprit.crud.controller.ActualiteController;
import tn.esprit.crud.entity.Actualite;
import tn.esprit.crud.entity.Commentaire;

import java.util.List;

public interface CommentaireService {
  List<Actualite> AddCommentaire(Commentaire commentaire , long id);


    Commentaire updateCommentaire(Commentaire commentaire, long idCommentaire);

    Commentaire findById(Long idCommentaire);

    List<Commentaire> retrieveAllCommentaireByActualiteId(long idCommentaire);

    void deleteCommentaireById(Long idCommentaire);
}
