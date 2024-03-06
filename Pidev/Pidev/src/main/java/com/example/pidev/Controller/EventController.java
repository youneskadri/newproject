package com.example.pidev.Controller;

import com.example.pidev.Service.ServiceEvenement;
import com.example.pidev.entities.Evenement;
import com.example.pidev.entities.Produit;
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
@RequestMapping("/Event")
public class EventController {
    @Autowired
    ServiceEvenement serviceEvenement;

    @PostMapping("add")
    public Evenement addEvent(@Validated @RequestBody Evenement evenement){
        return serviceEvenement.addEvent(evenement);

    }
    @GetMapping("getAll")
    public List<Evenement> getAllEvent(){
        return serviceEvenement.getAllEvent();
    }

    @GetMapping("NombreResevation/{id}")
    public int getAllEvent(@PathVariable("id") long id){
        return serviceEvenement.nombreResevation(id);
    }

}
