package com.example.pidev.Models;

import com.example.pidev.entities.StatutOffre;

public class UpdateStatut {
    Long Id ;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    String statut ;

}
