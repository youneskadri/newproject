package com.example.pidev.repository;

import com.example.pidev.entities.OffreFournisseur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface OffreFournisseurRepository extends CrudRepository<OffreFournisseur,Long> {
    List<OffreFournisseur> findOffreFournisseurByStatut(String r);
}
