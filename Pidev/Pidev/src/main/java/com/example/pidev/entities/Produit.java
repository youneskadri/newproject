package com.example.pidev.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    Long id;
     String nom;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "evenement_id")
    Evenement evenement;

    @JsonBackReference
    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
    List<LigneOffre> lignesOffre;

}
