package tn.esprit.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.crud.entity.Enseignant;

@Repository

public interface IEnseignant extends JpaRepository<Enseignant,Long> {
}
