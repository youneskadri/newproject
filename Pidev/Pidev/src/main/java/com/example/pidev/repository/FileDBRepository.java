package com.example.pidev.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pidev.entities.FileDB;



@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}
