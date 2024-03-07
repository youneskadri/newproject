package tn.esprit.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.crud.entity.Cours;
import tn.esprit.crud.service.CoursService;

@RestController
@RequestMapping("/cours")
public class CoursController {

    @Autowired
    CoursService coursService;

    @PostMapping("/add")
    public Cours addCours(@RequestBody Cours cours) {
        return coursService.addCours(cours);
    }

    @PutMapping("/update/{titre}")
    public Cours updateCours(@PathVariable("titre") String titre, @RequestBody Cours cours) {
        return coursService.updateCours(cours, titre);
    }

    @GetMapping("/find/{titre}")
    public Cours findByTitre(@PathVariable("titre") String titre) {
        return coursService.findByTitre(titre);
    }

    @GetMapping("/retrieve-all")
    public List<Cours> retrieveAllCourses() {
        return coursService.retrieveAllCourses();
    }

    @DeleteMapping("/delete/{titre}")
    public void deleteCoursByTitre(@PathVariable("titre") String titre) {
        coursService.deleteCoursByTitre(titre);
    }
}