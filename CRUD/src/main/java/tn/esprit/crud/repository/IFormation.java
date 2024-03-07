package tn.esprit.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.crud.entity.Formation;

@Repository

public interface IFormation extends JpaRepository<Formation,Long> {
}
