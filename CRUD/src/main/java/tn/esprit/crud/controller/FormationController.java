package tn.esprit.crud.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.crud.entity.Formation;
import tn.esprit.crud.service.FormationService;

import java.util.List;



@CrossOrigin(origins = "*")

@RestController
@AllArgsConstructor
public class FormationController {

    @Autowired
    private FormationService formationService;



    @PostMapping("/addFormation/")
    public Formation addFormation(@RequestBody Formation formation) {
        return formationService.addFormation(formation);
    }

    @PutMapping("/updateFormation/{idFormation}")
    public Formation updateFormation(@RequestBody Formation formation, @PathVariable Long idFormation) {
        return formationService.updateFormation(formation, idFormation);
    }

    @GetMapping("/findById/{idFormation}")
    public Formation findById(@PathVariable Long idFormation) {
        return formationService.findById(idFormation);
    }

    @GetMapping("/retrieveAllFormations")
    public List<Formation> retrieveAllFormations() {
        return formationService.retrieveAllFormations();
    }

    @DeleteMapping("/DeleteFormationById/{idFormation}")
    public String DeleteFormationById(@PathVariable Long idFormation) {
        formationService.deleteFormationById(idFormation);
        return "Formation deleted successfully";
    }
}
