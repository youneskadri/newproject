package com.example.pidev.Service;

import com.example.pidev.entities.Evenement;
import com.example.pidev.entities.Produit;
import com.example.pidev.repository.EventRepository;
import com.example.pidev.repository.ProduitRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceProduit implements IServiceProduit{
    ProduitRepository produitRepository;
    EventRepository eventRepository ;
    @Override
    public Produit addproduit(Produit produit, long id) {
        Evenement evenement = eventRepository.findById(id).orElse(null);
        produit.setEvenement( evenement );
        return produitRepository.save(produit);
    }
    @Override
    public List<Produit> getAllproduit() {
        return (List<Produit>) produitRepository.findAll();
    }
    @Override
    public Produit getproduitById(long id) {
        return produitRepository.findById(id).get();
    }
    @Override
    public void deleteproduit(long id) {
        produitRepository.deleteById(id);
    }
    @Override
    public Produit updateProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public List<Produit> getAllproduitByEvenementId(Long id) {
       return produitRepository.findProduitsByEvenement_IdEvement(id);

    }

}
