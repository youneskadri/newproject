package com.example.pidev.Service;

import java.util.List;

import com.example.pidev.entities.Besoin;

public interface IBesoinService {
    Besoin addBesoin(Besoin besoin);
    List<Besoin> getAllBesoins();
    Besoin getBesoinById(long idBesoin);
    void deleteBesoin(long idBesoin);
    Besoin updateBesoin(Besoin besoin);
    Besoin updateRating(Long id, int newRating);

}