package com.example.pidev.Controller;




import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.pidev.Service.IBesoinService;
import com.example.pidev.entities.Besoin;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/besoins")
public class BesoinController {
    IBesoinService besoinService;
    //{}
    //[]
    @PostMapping("add")
    public Besoin addingBesoin(@RequestBody Besoin besoin){

        return besoinService.addBesoin(besoin);
    }

 
    // Order 2
    @GetMapping("getAll")
    public List<Besoin> gettingAllBesoin(){
        return besoinService.getAllBesoins();
    }

    // Order 3
    @GetMapping("get")
    public Besoin gettingBesoin(@RequestParam("idBesoin") long idBesoin){
        return besoinService.getBesoinById(idBesoin);
    }

    // Order 4
    @DeleteMapping("delete/{idBesoin}")
    public void deletingBesoin(@PathVariable("idBesoin") long idBloc){
        besoinService.deleteBesoin(idBloc);
    }

    // Order 5
    @PutMapping("update")
    public Besoin updatingBesoin(@RequestBody Besoin bloc){
        return besoinService.updateBesoin(bloc);
    }



    //rating
    @PutMapping("/rating/{id}")
    public ResponseEntity<Besoin> updateRating(@PathVariable Long id, @RequestBody Besoin updatedBesoin) {
        Besoin besoin = besoinService.updateRating(id, updatedBesoin.getStarRating());

        if (besoin != null) {
            return new ResponseEntity<>(besoin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
