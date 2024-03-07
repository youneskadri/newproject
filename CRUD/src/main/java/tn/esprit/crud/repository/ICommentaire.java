package tn.esprit.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.crud.entity.Commentaire;

import java.util.List;

@Repository
public interface ICommentaire extends JpaRepository<Commentaire,Long> {
    List<Commentaire> findCommentaireByActualite_IdActualite(long id) ;
}
