package com.example.pidev.Service;

import com.example.pidev.Models.ModelAddOffre;
import com.example.pidev.Models.UpdateStatut;
import com.example.pidev.entities.OffreFournisseur;

import java.util.List;

public interface IServiceOffreFournisseur {
    OffreFournisseur addOffre(List<ModelAddOffre> list, long id);
    List<OffreFournisseur> getAllOffre();
    OffreFournisseur getOffreById(long idOffre);
    void deleteoffre(long idOffre);
    OffreFournisseur updateOffre(OffreFournisseur offreFournisseur);


    OffreFournisseur updateStatut(UpdateStatut updateStatut);
}
