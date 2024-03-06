package com.example.pidev.Service;

import com.example.pidev.entities.Evenement;
import com.example.pidev.entities.LigneOffre;
import com.example.pidev.entities.OffreFournisseur;
import com.example.pidev.entities.Produit;
import com.example.pidev.repository.LigneOffreRepository;
import com.example.pidev.repository.OffreFournisseurRepository;
import com.example.pidev.repository.ProduitRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceLigneOffre implements IServiceLigneOffre{
    @Autowired
    LigneOffreRepository ligneOffreRepository;
    @Autowired
    OffreFournisseurRepository offreFournisseurRepository ;
    @Override
    public LigneOffre addLigneOffre(LigneOffre ligneOffre,long id) {
         OffreFournisseur offreFournisseur = offreFournisseurRepository.findById(id).orElse(null);
        ligneOffre.setOffreFournisseur( offreFournisseur );
        return ligneOffreRepository.save(ligneOffre);
    }
    @Override
    public List<LigneOffre> getAllLigneOffre() {
        return (List<LigneOffre>) ligneOffreRepository.findAll();
    }
    @Override
    public LigneOffre getLigneOffreById(long id) {
        return ligneOffreRepository.findById(id).get();
    }
    
    @Override
    public void deleteLigneOffre(long id) {
        ligneOffreRepository.deleteById(id);
    }
    @Override
    public LigneOffre updateLigneOffre(LigneOffre ligneOffre) {
        return ligneOffreRepository.save(ligneOffre);
    }

}
