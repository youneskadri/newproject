package com.example.pidev.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LigneOffre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    Long id;
    int prixUnitaire;

    int quantite;
    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "offre_fournisseur_id")
    private OffreFournisseur offreFournisseur;



    public LigneOffre(int prixUnitaire, int quantite) {
        this.prixUnitaire = prixUnitaire;
        this.quantite = quantite;


    }
}
