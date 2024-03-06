package com.example.pidev.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OffreFournisseur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    Long idOffre;
    @Enumerated(EnumType.STRING)
     StatutOffre statut;

    String NomFornisseur ;

    @OneToMany(mappedBy = "offreFournisseur", cascade = CascadeType.ALL)
    List<LigneOffre> offres;


    
    @ManyToOne
    @JoinColumn(name = "proposition_id")
     Proposition proposition;


}
