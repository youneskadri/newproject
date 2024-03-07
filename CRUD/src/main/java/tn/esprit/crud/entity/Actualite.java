package tn.esprit.crud.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Actualite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idActualite ;
    private String actuality ;
    private LocalDateTime datePub;
    private String imageUrl ;

    @JsonManagedReference
    @OneToMany(mappedBy = "actualite", cascade = CascadeType.ALL)

    List<Commentaire> commentaire;
    @JsonManagedReference
    @OneToMany(mappedBy = "actualite", cascade = CascadeType.ALL)

    List<React> reacts;


}
