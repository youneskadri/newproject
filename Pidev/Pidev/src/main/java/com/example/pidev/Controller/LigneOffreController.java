package com.example.pidev.Controller;

import com.example.pidev.Service.IServiceLigneOffre;
import com.example.pidev.Service.IServiceOffreFournisseur;
import com.example.pidev.entities.LigneOffre;
import com.example.pidev.entities.OffreFournisseur;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://localhost:4200")
@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/LigneOffre")
public class LigneOffreController {
   @Autowired
    IServiceLigneOffre serviceLigneOffre;
    @PostMapping("add/{idOffre}")
    public LigneOffre addLigneOffre(@Validated @RequestBody LigneOffre ligneOffre , @PathVariable("idOffre") long id){
        return serviceLigneOffre.addLigneOffre(ligneOffre,id);

    }

    @GetMapping("getAll")
    public List<LigneOffre> getAllLigneOffre(){
        return serviceLigneOffre.getAllLigneOffre();
    }

    @DeleteMapping("delete/{id}")
    public void deleteLigneOffre(@PathVariable("id") long idOffre){
        serviceLigneOffre.deleteLigneOffre(idOffre);
    }
    @PutMapping("update")
    public LigneOffre updateLigneOffre(@RequestBody LigneOffre ligneOffre){
        return serviceLigneOffre.updateLigneOffre(ligneOffre);
    }
}
