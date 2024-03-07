package com.example.gestionforum.Service;

import com.example.gestionforum.Entity.Candidature;
import com.example.gestionforum.Repository.CandidatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@Service
public class ServiceCandidature implements IServiceCandidature {
    @Autowired
    CandidatureRepository candidatureRepository;

    @Override
    public List<Candidature> getAllCandidatures() {
        return candidatureRepository.findAll();
    }

    @Override
    public Candidature getCandidature(Long idCandidature) {
        return candidatureRepository.findById(idCandidature).get();
    }


    @Override
    public Candidature saveCandidature(Candidature candidature) {
        return candidatureRepository.save(candidature);
    }

    @Override
    public Candidature saveCv(MultipartFile cv, Long idCandidature) throws Exception {
        String fileName = StringUtils.cleanPath(cv.getOriginalFilename());
        try {

            if(fileName.contains("..")) {
                throw new Exception("Filename contains invalid path sequence " + fileName);
            }
            if (cv.getBytes().length > (1024 * 1024)) {
                throw new Exception("File size exceeds maximum limit");
            }

            String downloadURI = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/download/")
                    .path(idCandidature.toString())
                    .toUriString();

            Candidature candidature = candidatureRepository.findById(idCandidature).get();
            candidature.setCvFileName(fileName);
            candidature.setCvFileType(cv.getContentType());
            candidature.setCvData(cv.getBytes());
            candidature.setDownloadURI(downloadURI);
            return candidatureRepository.save(candidature);
        } catch (MaxUploadSizeExceededException e) {
            throw new MaxUploadSizeExceededException(cv.getSize());
        } catch (Exception e) {
            throw new Exception("Could not save File: " + e);
        }
    }
}
