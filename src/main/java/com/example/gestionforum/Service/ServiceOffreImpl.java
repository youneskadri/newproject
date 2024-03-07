package com.example.gestionforum.Service;

import com.example.gestionforum.Entity.Offre;
import com.example.gestionforum.Repository.OffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOffreImpl implements IServiceOffre{

    @Autowired
    OffreRepository offreRepository;
    @Override
    public List<Offre> getallOffre(){
        return offreRepository.findAll();

    }

    @Override
    public Offre addOffre(Offre offre) {
        return offreRepository.save(offre);
    }

    @Override
    public  void deleteOffre(Long idOffre) {

        Offre offre = offreRepository.findById(idOffre).get();
        offreRepository.delete(offre);

    }

    @Override
    public Offre updateOffre(Long idOffre, Offre offre) {
        Offre of = offreRepository.findById(idOffre).get();
        of.setNom(offre.getNom());
        of.setDescription(offre.getDescription());
        of.setTypeOffre(offre.getTypeOffre());
        of.setDuree(offre.getDuree());
        return offreRepository.save(of);

    }
}
