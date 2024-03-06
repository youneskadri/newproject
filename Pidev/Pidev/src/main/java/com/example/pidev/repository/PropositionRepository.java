package com.example.pidev.repository;

import com.example.pidev.entities.Proposition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PropositionRepository extends CrudRepository<Proposition,Long> {
}
