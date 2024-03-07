package com.example.pidev.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.pidev.entities.Livrable;
@Repository
public interface LivrableRepository extends JpaRepository<Livrable, Long> {
    @Query("SELECT MAX(l.note) FROM Livrable l")
    Integer findMaxNote();
}