package com.example.pidev.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.pidev.entities.Livrable;

import java.io.IOException;
import java.util.List;

public interface ILivrableService {
    List<Livrable> getAllLivrabales();
    Livrable getLivrableById(long id);
    Livrable saveLivrable(Livrable livrable);
    void deleteLivrable(long id);
    void uploadFirstDocument(String stepName, MultipartFile file) throws IOException;

   Livrable addLivrableWithEvaluation(Long besoinId);

    Livrable saveLivrableAndAddIDLivrableAndIdBesoinInEnovation(Livrable livrable,Long besoinId);


}
