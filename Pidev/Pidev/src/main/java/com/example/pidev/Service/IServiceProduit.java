package com.example.pidev.Service;

import com.example.pidev.entities.Produit;

import java.util.List;

public interface IServiceProduit {

    Produit addproduit(Produit produit, long id);

    List<Produit> getAllproduit();
    Produit getproduitById(long id);
    void deleteproduit(long id);
    Produit updateProduit(Produit produit);


    List<Produit> getAllproduitByEvenementId(Long id);
}
