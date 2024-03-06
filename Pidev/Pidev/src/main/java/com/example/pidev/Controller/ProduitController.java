package com.example.pidev.Controller;

import com.example.pidev.Service.IServiceProduit;
import com.example.pidev.entities.Produit;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/Produit")
public class ProduitController {
    @Autowired
    IServiceProduit serviceProduit;
    @PostMapping("add/{idevent}")
    public Produit addproduit(@Validated @RequestBody Produit produit , @PathVariable("idevent") long id){
        return serviceProduit.addproduit(produit, id);

    }

    @GetMapping("getAll")
    public List<Produit> getAllproduit(){
        return serviceProduit.getAllproduit();
    }

    @DeleteMapping("delete/{id}")
    public void deleteproduit(@PathVariable("id") long id){
        serviceProduit.deleteproduit(id);
    }
    @PutMapping("update")
    public Produit updateProduit(@RequestBody Produit produit){
        return serviceProduit.updateProduit(produit);
    }

    @GetMapping ("Evenement/{id}")
    public List<Produit> getProduitsParEvenementId (@PathVariable("id") long id){
     return   serviceProduit.getAllproduitByEvenementId(id);
    }
}
