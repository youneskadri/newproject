package com.example.gestionforum.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
    private String name;
    private String lastname;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Offre> offres;
}
