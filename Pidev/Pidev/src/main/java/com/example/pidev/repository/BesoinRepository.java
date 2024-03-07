package com.example.pidev.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pidev.entities.Besoin;


@Repository
public interface BesoinRepository extends CrudRepository<Besoin,Long> {
}
