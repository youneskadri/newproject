package com.example.pidev.Service;

import com.example.pidev.Models.ResponseProposition;
import com.example.pidev.entities.Produit;
import com.example.pidev.entities.Proposition;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IServiceProposition {
    Proposition addProposition(Proposition proposition);
    List<ResponseProposition> getAllProposition();
    Proposition getpropositionById(long id);
    void deleteproposition(long id);
    Proposition updateProposition(Proposition proposition);

    Proposition AjouterProposition( long idEvement);
}
