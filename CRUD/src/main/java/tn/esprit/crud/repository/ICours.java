package tn.esprit.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.crud.entity.Cours;

@Repository

public interface ICours extends JpaRepository<Cours,Long> {

        Cours findByTitre(String titre);
    void deleteByTitre(String titre);

}
