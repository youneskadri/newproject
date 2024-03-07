package com.example.gestionforum.Service;

import com.example.gestionforum.Entity.Offre;

import java.util.List;

public interface IServiceOffre {
    List<Offre> getallOffre();
    public Offre addOffre(Offre offre);
    public void deleteOffre(Long idOffre);

    public Offre updateOffre(Long idOffre, Offre offre);
}
