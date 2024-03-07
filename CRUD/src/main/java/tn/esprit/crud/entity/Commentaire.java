package tn.esprit.crud.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id ;
    private String username ;
    private String contenu ;
    private LocalDateTime date ;
    private Boolean Modifiee;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "actualite_id")
    Actualite actualite;
}
