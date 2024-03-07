package tn.esprit.crud.service;

import tn.esprit.crud.entity.React;

public interface ReactService {
    React AddReact(React react);

    void add(long idActualite, String username, Boolean Statut);

    React findById(Long id);

    void deleteCommentaireById(Long id);
}
