package com.example.pidev.Service;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.pidev.entities.Besoin;
import com.example.pidev.entities.Evaluation;
import com.example.pidev.entities.FileDB;
import com.example.pidev.entities.Livrable;
import com.example.pidev.repository.BesoinRepository;
import com.example.pidev.repository.EvaluationRepository;
import com.example.pidev.repository.FileDBRepository;
import com.example.pidev.repository.LivrableRepository;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class FileStorageService {

    @Autowired
    private FileDBRepository fileDBRepository;
    @Autowired
    private LivrableRepository livrableRepository;
    @Autowired
    private EvaluationService evaluationService;
    @Autowired
    private EvaluationRepository evaluationRepository;
    @Autowired
    private BesoinRepository besoinsRepository;

  



    public FileDB store(MultipartFile file ,Long besoinId) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());

        //  Livrable livrable = fileDBRepository.findById();
        Livrable livrable = new Livrable();

        //  livrable.setNameFile(fileName);
        //livrable.setIdLivrable(8);
        livrable.setNom("Kattoussi");
        livrable.setEmail("nesrine.gatousi@gmail.com");
        livrable.setPrenom("Nesrine");
        livrable.setAdresse("boumhal");
        livrable.setVille("Tunis");
        FileDB.setLivrable(livrable);
        livrableRepository.save(livrable);


//Besoin
        Besoin besoin = besoinsRepository.findById(besoinId)
                .orElseThrow(() -> new NoSuchElementException("Besoins not found"));

//Evaluation
        Evaluation evaluation = new Evaluation();
        evaluation.setLivrable(livrable);
        evaluation.setBesoin(besoin);
        evaluation.setDate(new Date());
        evaluation.setEtat("en attente");
        evaluationRepository.save(evaluation);






        return fileDBRepository.save(FileDB);
    }
    public FileDB getFile(String id) {
        return fileDBRepository.findById(id).get();
    }

    public Stream<FileDB> getAllFiles() {
        return fileDBRepository.findAll().stream();
    }


    @Transactional
    public void updateLivrableNote(String fileId, int newNote) {
        FileDB fileDB = fileDBRepository.findById(fileId)
                .orElseThrow(() -> new EntityNotFoundException("File not found with id: " + fileId));

        Livrable livrable = fileDB.getLivrable();
        if (livrable != null) {
            livrable.setNote(newNote);

            /*   List<Evaluation> livrableEvaluations = livrable.getEvaluations();
         if (livrableEvaluations != null && !livrableEvaluations.isEmpty()) {

                Integer maxNote = livrableRepository.findMaxNote();
                System.out.println("Max Note: " + (maxNote != null ? maxNote : "N/A"));

                for (Evaluation evaluation : livrableEvaluations) {
                    Livrable evaluationLivrable = evaluation.getLivrable();

                    System.out.println("Before Update - Evaluation: " + evaluation.getIdEvaluation() +
                            ", Livrable Note: " + (evaluationLivrable != null ? evaluationLivrable.getNote() : "N/A") +
                            ", Max Note: " + maxNote +
                            ", Etat: " + evaluation.getEtat());

                    if (evaluationLivrable != null && evaluationLivrable.getNote() == maxNote) {
                        evaluation.setEtat("ACCEPTED");
                    } else {
                        evaluation.setEtat("REFUSED");
                    }

                    System.out.println("After Update - Evaluation: " + evaluation.getIdEvaluation() +
                            ", Livrable Note: " + (evaluationLivrable != null ? evaluationLivrable.getNote() : "N/A") +
                            ", Max Note: " + maxNote +
                            ", Etat: " + evaluation.getEtat());
                }

                // Save the Livrable entity after updating all evaluations
                livrableRepository.save(livrable);*/

            Integer maxNote = livrableRepository.findMaxNote();
            System.out.println("Max Note: " + (maxNote != null ? maxNote : "N/A"));
            List<Evaluation> livrableEvaluations = livrable.getEvaluations();
            for (Evaluation evaluation : livrableEvaluations) {
           if (livrable != null && livrable.getNote() == maxNote) {
                evaluation.setEtat("ACCEPTED");
            } else {
                evaluation.setEtat("REFUSED");
            }
                Livrable evaluationLivrable = evaluation.getLivrable();

                System.out.println("Before Update - Evaluation: " + evaluation.getIdEvaluation() +
                        ", Livrable Note: " + (evaluationLivrable != null ? evaluationLivrable.getNote() : "N/A") +
                        ", Max Note: " + livrable.getNote() +
                        ", Etat: " + evaluation.getEtat());

             

                System.out.println("After Update - Evaluation: " + evaluation.getIdEvaluation() +
                        ", Livrable Note: " + (evaluationLivrable != null ? evaluationLivrable.getNote() : "N/A") +
                        ", Max Note: " + livrable.getNote() +
                        ", Etat: " + evaluation.getEtat());
            }

            // Save the Livrable entity after updating all evaluations
            livrableRepository.save(livrable);

            // Optionally, flush and clear the entity manager
           // entityManager.flush();
           // entityManager.clear();
        }
    }   }