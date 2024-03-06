package com.example.pidev.Service;

import com.example.pidev.Models.ResponseProposition;
import com.example.pidev.entities.Evenement;
import com.example.pidev.entities.Proposition;
import com.example.pidev.repository.EventRepository;
import com.example.pidev.repository.PropositionRepository;
import com.example.pidev.repository.ReservationRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceProposition implements IServiceProposition{
    @Autowired
    PropositionRepository propositionRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    EventRepository eventRepository;
    @Override
    public Proposition addProposition(Proposition proposition) {
        return propositionRepository.save(proposition);
    }
    @Override
    public List<ResponseProposition> getAllProposition() {
        List<ResponseProposition> propositionList =new ArrayList<>();

        for (Proposition p:
                (List<Proposition>) propositionRepository.findAll()) {
            ResponseProposition RP =new ResponseProposition();
            RP.setId(p.getId());
            RP.setIdEvent(p.getEvenement().getIdEvenement());
            RP.setNombreReservation(reservationRepository.countAllByEvenement(p.getEvenement().getIdEvenement()));
            RP.setNom(p.getEvenement().getNom());
            propositionList.add(RP);
        }
        return  propositionList;
    }
    @Override
    public Proposition getpropositionById(long id) {
        return propositionRepository.findById(id).get();
    }
    @Override
    public void deleteproposition(long id) {
        propositionRepository.deleteById(id);
    }
    @Override
    public Proposition updateProposition(Proposition proposition) {
        return propositionRepository.save(proposition);
    }
   @Override
    public Proposition AjouterProposition( long idEvement) {
        Evenement evenement = eventRepository.findById(idEvement).orElse(null);
        Proposition proposition=new Proposition();

        if ( evenement != null) {
            proposition.setEvenement(evenement);
            proposition.setNombreParticipants(0);
            return propositionRepository.save(proposition);
        } else {
            log.error(" l'événement spécifié n'a pas été trouvé.");
            return null;
        }
    }

}
