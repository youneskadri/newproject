package tn.esprit.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.crud.Cloudinary.CloudinaryService;
import tn.esprit.crud.Model.ModelActulite;
import tn.esprit.crud.Model.ModelUrl;
import tn.esprit.crud.entity.Actualite;
import tn.esprit.crud.service.ActualiteService;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/actualites")
public class ActualiteController {

    @Autowired
    private ActualiteService actualiteService;
    @Autowired
    private CloudinaryService cloudinaryService;

    @GetMapping("/all")
    public List<Actualite> retrieveAllActualite() {
        return actualiteService.retrieveAllActualite();
    }

    @GetMapping("/{id}")
    public Actualite findById(@PathVariable Long id) {
        return actualiteService.findById(id);
    }

    @PostMapping("/add")
    public Actualite addActualite(@RequestBody ModelActulite modelActulite) {
        Actualite actualite =new Actualite();
        actualite.setActuality(modelActulite.getActuality());
        actualite.setImageUrl(modelActulite.getUrl());
        return actualiteService.addActualite(actualite);
    }

    @PostMapping("/update/{id}")
    public Actualite updateActualite(@RequestBody Actualite actualite, @PathVariable Long id) {
        return actualiteService.updateActualite(actualite, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteActualiteById(@PathVariable Long id) {
        actualiteService.deleteActualiteById(id);
    }

    @PostMapping("/upload")
    public ModelUrl upload(@RequestBody MultipartFile file){

            ModelUrl m = new ModelUrl();
                    m.setUrl(cloudinaryService.uploadFile(file, "folder_1"));
            return m;

    }

    @GetMapping("/best")
    public Actualite Best(){
        return actualiteService.Best();
    }

}
