package com.example.pidev.repository;

import com.example.pidev.entities.LigneOffre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LigneOffreRepository extends CrudRepository<LigneOffre,Long> {
}
