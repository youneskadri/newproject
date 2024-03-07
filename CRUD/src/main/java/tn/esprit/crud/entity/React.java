package tn.esprit.crud.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class React {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String username ;
    //true:LIKE & false:Dislike
    private boolean Reaction_Type;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "actualite_id")
    Actualite actualite;

    public React(Actualite actualite, String username, Boolean statut) {
        this.actualite=actualite;
        this.username=username;
        this.Reaction_Type=statut ;
    }
}
