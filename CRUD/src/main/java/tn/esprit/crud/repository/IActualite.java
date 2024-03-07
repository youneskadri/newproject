package tn.esprit.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.crud.entity.Actualite;

import java.util.List;

@Repository

public interface IActualite extends JpaRepository<Actualite,Long> {

    Actualite findTopByReactsIsTrue();
}
