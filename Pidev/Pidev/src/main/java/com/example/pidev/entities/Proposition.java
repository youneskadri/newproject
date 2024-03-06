package com.example.pidev.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Proposition implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long id;

     int NombreParticipants ;
    @OneToOne
    @JoinColumn(name = "evenement_id")
    Evenement evenement;

    @OneToMany(mappedBy = "proposition", cascade = CascadeType.ALL)
    List<OffreFournisseur> offres;
}
