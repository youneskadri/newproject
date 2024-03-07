package com.example.gestionforum.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOffre;
    private String nom;
    private String description;
    @Enumerated(value = EnumType.STRING)
    private TypeOffre typeOffre;
    private String duree;

    @ManyToMany(mappedBy="offres", cascade = CascadeType.ALL)
    private Set<User> users;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="offre")
    private Set<Candidature> Candidatures;
}
