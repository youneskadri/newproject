package tn.esprit.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.crud.entity.Formation;
import tn.esprit.crud.entity.React;

public interface IReact extends JpaRepository<React,Long> {

    React findReactByActualite_IdActualiteAndUsername(long id ,String username);


}
