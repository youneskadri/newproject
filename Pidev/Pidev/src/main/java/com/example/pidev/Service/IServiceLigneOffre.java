package com.example.pidev.Service;

import com.example.pidev.entities.LigneOffre;
import com.example.pidev.entities.Produit;

import java.util.List;

public interface IServiceLigneOffre {
    LigneOffre addLigneOffre(LigneOffre ligneOffre,long id);
    List<LigneOffre> getAllLigneOffre();
    LigneOffre getLigneOffreById(long id);
    void deleteLigneOffre(long id);
    LigneOffre updateLigneOffre(LigneOffre ligneOffre);

}
