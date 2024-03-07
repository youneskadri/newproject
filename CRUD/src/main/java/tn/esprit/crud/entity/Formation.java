package tn.esprit.crud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idFormation ;
    private String nomFormation ;
    private String description;


/*
    @OneToMany (mappedBy = "formation")
    @JsonIgnore
    private List<Cours>cours ;

    @ManyToOne
    private Enseignant enseignant ; */
}
