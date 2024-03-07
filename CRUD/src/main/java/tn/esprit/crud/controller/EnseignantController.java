package tn.esprit.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.crud.entity.Enseignant;
import tn.esprit.crud.service.EnseignantService;

import java.util.List;

@RestController
@RequestMapping("/api/enseignants")
public class EnseignantController {

    @Autowired
    private EnseignantService enseignantService;

    @PostMapping("/addEnseignant")
    public Enseignant addEnseignant(@RequestBody Enseignant enseignant) {
        return enseignantService.addEnseignant(enseignant);
    }

    @PutMapping("/updateEnseignant/{idEnseignant}")
    public Enseignant updateEnseignant(@RequestBody Enseignant enseignant, @PathVariable Long idEnseignant) {
        return enseignantService.updateEnseignant(enseignant, idEnseignant);
    }

    @GetMapping("/findById/{idEnseignant}")
    public Enseignant findById(@PathVariable Long idEnseignant) {
        return enseignantService.findById(idEnseignant);
    }

    @GetMapping("/retrieveAllEnseignants")
    public List<Enseignant> retrieveAllEnseignants() {
        return enseignantService.retrieveAllEnseignants();
    }

    @DeleteMapping("/DeleteEnseignantById/{idEnseignant}")
    public String DeleteEnseignantById(@PathVariable Long idEnseignant) {
        enseignantService.DeleteEnseignantById(idEnseignant);
        return "Enseignant deleted successfully";
    }
}
