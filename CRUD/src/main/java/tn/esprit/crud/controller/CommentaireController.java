package tn.esprit.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.crud.entity.Actualite;
import tn.esprit.crud.entity.Commentaire;
import tn.esprit.crud.service.ActualiteService;
import tn.esprit.crud.service.CommentaireService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Commentaires")
public class CommentaireController {
    @Autowired
    private CommentaireService commentaireService;

    @GetMapping("/all/{idActualite}")
    public List<Commentaire>retrieveAllCommentaireByActualiteId(@PathVariable("idActualite") long id) {
        return commentaireService.retrieveAllCommentaireByActualiteId(id);
    }

    @GetMapping("/{id}")
    public Commentaire findById(@PathVariable Long id) {
        return commentaireService.findById(id);
    }

    @PostMapping("/add/{idAct}")
    public List<Actualite> addCommentaire(@RequestBody Commentaire commentaire, @PathVariable("idAct") long id) {
        return commentaireService.AddCommentaire(commentaire ,  id);
    }

    @PutMapping("/update/{id}")
    public Commentaire updateCommentaire(@RequestBody Commentaire commentaire, @PathVariable("id") Long id) {
        return commentaireService.updateCommentaire(commentaire, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCommentaireById(@PathVariable Long id) {
        commentaireService.deleteCommentaireById(id);
    }


}
