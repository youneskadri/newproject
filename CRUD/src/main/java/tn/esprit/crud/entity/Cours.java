package tn.esprit.crud.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCour ;
    private String titre ;
    private String description ;
    private int duration ;



    @ManyToOne
    private Formation formation;
}
