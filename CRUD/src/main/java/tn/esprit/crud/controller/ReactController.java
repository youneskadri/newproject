package tn.esprit.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.crud.Model.ModelActulite;
import tn.esprit.crud.entity.Actualite;
import tn.esprit.crud.entity.React;
import tn.esprit.crud.service.ReactService;
@CrossOrigin(origins = "*")
@RestController
public class ReactController {

    @Autowired
    ReactService reactService ;
    @PostMapping("/add/{idAct}")
    public void addAc(@RequestBody Boolean Status, @PathVariable("idAct") long id) {
        reactService.add(id, "", Status);
    }
}
