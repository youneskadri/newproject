package com.example.pidev.Controller;

import com.example.pidev.Models.ModelAddOffre;
import com.example.pidev.Models.UpdateStatut;
import com.example.pidev.Service.IServiceOffreFournisseur;
import com.example.pidev.entities.OffreFournisseur;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://localhost:4200")
@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/OffreFournisseur")
public class OffreFournisseurController {
    IServiceOffreFournisseur serviceOffreFournisseur;
    @PostMapping("add/{idProp}")
    public OffreFournisseur addOffre(@Validated @RequestBody List<ModelAddOffre> list , @PathVariable("idProp") long id ){
        return serviceOffreFournisseur.addOffre(list,id);

    }
    @GetMapping("get/{id}")
    public OffreFournisseur getOffre(@PathVariable("id") long id){
        return serviceOffreFournisseur.getOffreById(id);
    }
    @GetMapping("getAll")
    public List<OffreFournisseur> getAllOffre(){
        return serviceOffreFournisseur.getAllOffre();
    }

    @DeleteMapping("delete/{id}")
    public void deleteoffre(@PathVariable("id") long idOffre){
        serviceOffreFournisseur.deleteoffre(idOffre);
    }
    @PutMapping("update/statut")
    public OffreFournisseur updateOffre(@RequestBody OffreFournisseur offreFournisseur){
        return serviceOffreFournisseur.updateOffre(offreFournisseur);
    }

    @PostMapping("update")
    public OffreFournisseur updateStatut(@RequestBody UpdateStatut updateStatut){
        return serviceOffreFournisseur.updateStatut(updateStatut);
    }

}
