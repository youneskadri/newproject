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

public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idEnseignant ;
    private String nomEnseignant ;
    private String email ;
    private String localisation ;
    @Enumerated(EnumType.STRING)
    Disponibilite disponibilite ;

   /* @OneToMany(mappedBy = "enseignant")
    @JsonIgnore
    private List<Formation>formations;
*/

}
