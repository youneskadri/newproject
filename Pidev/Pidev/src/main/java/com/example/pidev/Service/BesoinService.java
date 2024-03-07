package com.example.pidev.Service;



import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.example.pidev.entities.Besoin;
import com.example.pidev.repository.BesoinRepository;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BesoinService  implements IBesoinService{
    BesoinRepository besoinRepository;


    @Override
    public Besoin addBesoin(Besoin besoin) {
        return besoinRepository.save(besoin);
    }

    @Override
    public List<Besoin> getAllBesoins() {
        return (List<Besoin>) besoinRepository.findAll();
    }


    @Override
    public Besoin getBesoinById(long idBesoin) {
        return besoinRepository.findById(idBesoin).get();
    }

    @Override
    public void deleteBesoin(long idBesoin) {
        besoinRepository.deleteById(idBesoin);

    }



    @Override
    public Besoin updateBesoin(Besoin besoin) {
        return besoinRepository.save(besoin);
    }


    public Besoin updateRating(Long id, int newRating) {
        Optional<Besoin> optionalBesoin = besoinRepository.findById(id);

        if (optionalBesoin.isPresent()) {
            Besoin besoin = optionalBesoin.get();
            besoin.setStarRating(newRating);
            return besoinRepository.save(besoin);
        }

        return null;
    }


}