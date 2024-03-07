package com.example.gestionforum.Service;

import com.example.gestionforum.Entity.Candidature;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IServiceCandidature {
    List<Candidature> getAllCandidatures();
    Candidature getCandidature(Long idCandidature);
    Candidature saveCandidature(Candidature candidature);
    Candidature saveCv(MultipartFile cv, Long idCandidature) throws Exception;

}
