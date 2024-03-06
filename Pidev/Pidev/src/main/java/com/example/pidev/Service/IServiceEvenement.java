package com.example.pidev.Service;

import com.example.pidev.entities.Evenement;
import com.example.pidev.entities.Produit;

import java.util.List;

public interface IServiceEvenement {
    Evenement addEvent(Evenement evenement);

    List<Evenement> getAllEvent();
     int nombreResevation(Long id) ;

}
