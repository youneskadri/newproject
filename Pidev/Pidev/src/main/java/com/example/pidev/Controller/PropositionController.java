package com.example.pidev.Controller;

import com.example.pidev.Models.ResponseProposition;
import com.example.pidev.Service.IServiceProduit;
import com.example.pidev.Service.IServiceProposition;
import com.example.pidev.entities.Produit;
import com.example.pidev.entities.Proposition;
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
@RequestMapping("/Proposition")
public class PropositionController {
    IServiceProposition serviceProposition;
    @PostMapping("add")
    public Proposition addProposition(@Validated @RequestBody Proposition proposition){
        return serviceProposition.addProposition(proposition);

    }

    @GetMapping("getAll")
    public List<ResponseProposition> getAllProposition(){
        return serviceProposition.getAllProposition();
    }

    @DeleteMapping("delete/{id}")
    public void deleteproposition(@PathVariable("id") long id){
        serviceProposition.deleteproposition(id);
    }
    @PutMapping("update")
    public Proposition updateProposition(@RequestBody Proposition proposition){
        return serviceProposition.updateProposition(proposition);
    }
   // @PostMapping("assignEvent/{propositionId}/{idEvement}")
    //public Proposition assignEventToProposition(@PathVariable("id") long id, @PathVariable("idEvement") long idEvement) {
      //  return serviceProposition.affecterEvenementAProposition(id, idEvement);
    //}
}
