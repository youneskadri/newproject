package com.example.gestionforum.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Candidature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCandidature;
    private String nom;
    private String prenom;
    private String email;
    @Enumerated(value = EnumType.STRING)
    private Status status;

    private String cvFileName;
    private String cvFileType;
    private String downloadURI;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] cvData;

    @JsonIgnore
    @ManyToOne
    Offre offre;
}
