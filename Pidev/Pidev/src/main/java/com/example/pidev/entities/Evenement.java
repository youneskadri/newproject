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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Evenement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idEvenement;
     String nom;

    @JsonManagedReference
    @OneToMany(mappedBy = "evenement", cascade = CascadeType.ALL)

    List<Produit> produits;

    @OneToMany(mappedBy = "evenement", cascade = CascadeType.ALL)

    List<Reservation> reservations;
}
