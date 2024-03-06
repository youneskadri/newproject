package com.example.pidev.repository;

import com.example.pidev.entities.Produit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProduitRepository extends CrudRepository<Produit,Long> {
    @Query (value = "select p from Produit p where p.evenement.idEvenement = ?1")
    List<Produit> findProduitsByEvenement_IdEvement(Long id);
}
