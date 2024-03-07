package com.example.gestionforum.Controller;

import com.example.gestionforum.Entity.Offre;
import com.example.gestionforum.Repository.OffreRepository;
import com.example.gestionforum.Service.ServiceOffreImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class OffreController {
    @Autowired
    ServiceOffreImpl serviceOffre;
    @Autowired
    OffreRepository offreRepository;

    @GetMapping("/AllOffre")
    public List<Offre> getallOffre(){
        return serviceOffre.getallOffre();
    }

    @PostMapping("/Addoffre")
    public Offre addoffre(@RequestBody Offre offre){
        return serviceOffre.addOffre(offre);
    }

    @DeleteMapping("/delete/{idOffre}")
    public void deleteOffre(@PathVariable Long idOffre){
        serviceOffre.deleteOffre(idOffre);
    }

    @GetMapping("/offre/{id}")
    public ResponseEntity<Offre> getOffreById(@PathVariable Long id) {
        Offre offre = offreRepository.findById(id).get();
        return ResponseEntity.ok(offre);
    }

    @PutMapping("/updateOffre/{idOffre}")
    public Offre updateOffre(@PathVariable Long idOffre,@RequestBody Offre offre){
        return serviceOffre.updateOffre(idOffre,offre);
    }
}
