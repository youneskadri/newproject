package com.example.pidev.Service;

import com.example.pidev.Models.ModelAddOffre;
import com.example.pidev.Models.UpdateStatut;
import com.example.pidev.entities.*;
import com.example.pidev.repository.LigneOffreRepository;
import com.example.pidev.repository.OffreFournisseurRepository;
import com.example.pidev.repository.ProduitRepository;
import com.example.pidev.repository.PropositionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
public class ServiceOffreFournisseur implements IServiceOffreFournisseur{
    @Autowired
    PropositionRepository propositionRepository ;
    @Autowired
    OffreFournisseurRepository offreFournisseurRepository;
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    LigneOffreRepository ligneOffreRepository;
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public OffreFournisseur addOffre(List<ModelAddOffre> list, long id) {
        Proposition proposition = propositionRepository.findById(id).orElse(null);
        OffreFournisseur offreFournisseur =new OffreFournisseur();
        offreFournisseur.setStatut(StatutOffre.En_Attente);
        offreFournisseur.setNomFornisseur(list.get(0).getNameFournisseur());
        offreFournisseur.setProposition(proposition);
        OffreFournisseur F = offreFournisseurRepository.save(offreFournisseur);
        for (ModelAddOffre m:
             list) {
            Produit produit = produitRepository.findById(m.getProduitId()).get()
                    ;


            LigneOffre o = new LigneOffre(m.getPrix(), m.getQuantite());
            o.setProduit(produit); // Set the Produit
            o.setOffreFournisseur(F);
            ligneOffreRepository.save(o);
        }
        return F;
    }
    @Override
    public List<OffreFournisseur> getAllOffre() {
        return entityManager.createNativeQuery("SELECT * FROM Offre_Fournisseur  WHERE statut = 'En_Attente'", OffreFournisseur.class)
                .getResultList();
    }
    @Override
    public OffreFournisseur getOffreById(long id) {
        return offreFournisseurRepository.findById(id).get();
    }
    @Override
    public void deleteoffre(long idOffre) {
        offreFournisseurRepository.deleteById(idOffre);
    }
    @Override
    public OffreFournisseur updateOffre(OffreFournisseur offreFournisseur) {
        return offreFournisseurRepository.save(offreFournisseur);
    }

    @Override
    public OffreFournisseur updateStatut(UpdateStatut updateStatut) {
        OffreFournisseur offreFournisseur = offreFournisseurRepository.findById(updateStatut.getId()).orElse(null);
        if(updateStatut.getStatut() == "Accepte") {
            offreFournisseur.setStatut(StatutOffre.Accepte);
        } else if (updateStatut.getStatut() == "Facturee") {
            offreFournisseur.setStatut(StatutOffre.facturee);
        }else {
            offreFournisseur.setStatut(StatutOffre.Refusee);
        }
        return offreFournisseurRepository.save(offreFournisseur);
    }

}
