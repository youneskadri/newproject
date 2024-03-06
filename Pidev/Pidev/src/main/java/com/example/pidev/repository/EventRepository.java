package com.example.pidev.repository;

import com.example.pidev.entities.Evenement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Evenement,Long> {

}
