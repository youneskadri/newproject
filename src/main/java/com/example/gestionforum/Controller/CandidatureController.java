package com.example.gestionforum.Controller;

import com.example.gestionforum.Entity.Candidature;
import com.example.gestionforum.Service.IServiceCandidature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class CandidatureController {

    @Autowired
    IServiceCandidature serviceCandidature;

    @PutMapping("/upload-cv/{idCandidature}")
    public ResponseEntity<String> fileUploading(@RequestParam("cv") MultipartFile cv, @PathVariable Long idCandidature) throws Exception {
        serviceCandidature.saveCv(cv, idCandidature);
        return ResponseEntity.ok("cv uploaded !");
    }

    @PostMapping("/add-candidature")
    public ResponseEntity<Long> addCandidature(@RequestBody Candidature candidature) {
         Candidature savedCandidature = serviceCandidature.saveCandidature(candidature);
         return ResponseEntity.ok(savedCandidature.getIdCandidature());
    }

    @GetMapping("/candidatures")
    public List<Candidature> getAllCandidatures() {
        return serviceCandidature.getAllCandidatures();
    }

    @GetMapping("/download/{candidateId}")
    public ResponseEntity<byte[]> downloadCv(@PathVariable Long candidateId) {
        Candidature candidature = serviceCandidature.getCandidature(candidateId);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + candidature.getCvFileName())
                .contentType(MediaType.parseMediaType(candidature.getCvFileType()))
                .body(candidature.getCvData());
    }
}
