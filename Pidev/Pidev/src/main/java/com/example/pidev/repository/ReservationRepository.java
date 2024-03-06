package com.example.pidev.repository;

import com.example.pidev.entities.Produit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Produit,Long> {
    @Query(value = "select count (r) from  Reservation r where r.evenement.idEvenement = ?1 ")
    int countAllByEvenement(Long id);
}
