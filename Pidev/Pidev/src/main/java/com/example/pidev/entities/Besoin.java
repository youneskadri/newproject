package com.example.pidev.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Besoin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long besoinId;

    String title;

    @Lob
    String description;

   // @JsonFormat(pattern = "dd-MM-yyyy")
    Date date;
    // Using java.sql.Date
    private int starRating;

    // OR Using java.time.LocalDate (for Java 8 and later)
    // LocalDate date;

   @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    byte[] image;/*
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
          @JoinTable(name = "besoin_images",
          joinColumns ={
                  @JoinColumn(name = "besoin_id")
          },
          inverseJoinColumns = {
                  @JoinColumn(name= "image_id")
          }
          )

    Set<ImageModel> besoinImages = new HashSet<>();*/


    @OneToMany(mappedBy = "besoin")
    @JsonManagedReference(value = "besoin-evaluations")
    private List<Evaluation> evaluations;


}