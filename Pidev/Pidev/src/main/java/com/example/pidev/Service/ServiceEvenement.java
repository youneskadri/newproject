package com.example.pidev.Service;

import com.example.pidev.entities.Evenement;
import com.example.pidev.repository.EventRepository;
import com.example.pidev.repository.ReservationRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceEvenement implements IServiceEvenement {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    ReservationRepository reservationRepository ;
    @Autowired
ServiceProposition serviceProposition ;
    @Override
    public Evenement addEvent(Evenement evenement) {
       Evenement event =eventRepository.save(evenement);
        serviceProposition.AjouterProposition(event.getIdEvenement());
       return event;
    }
    @Override
    public List<Evenement> getAllEvent() {
        return (List<Evenement>) eventRepository.findAll();
    }
    @Override
    public int nombreResevation(Long id) {
        return reservationRepository.countAllByEvenement(id) ;
    }
}
