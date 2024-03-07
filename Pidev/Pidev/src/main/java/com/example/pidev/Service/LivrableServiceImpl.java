package com.example.pidev.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.pidev.entities.Besoin;
import com.example.pidev.entities.Evaluation;
import com.example.pidev.entities.Livrable;
import com.example.pidev.repository.BesoinRepository;
import com.example.pidev.repository.EvaluationRepository;
import com.example.pidev.repository.LivrableRepository;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LivrableServiceImpl implements ILivrableService {

    @Autowired
    private LivrableRepository livrableRepository;
    @Autowired
    private EvaluationService evaluationService;
    @Autowired
    private EvaluationRepository evaluationRepository;
    @Autowired
    private BesoinRepository besoinsRepository;
    @Override
    public List<Livrable> getAllLivrabales() {
        return livrableRepository.findAll();
    }

    @Override
    public Livrable getLivrableById(long id) {
        return livrableRepository.findById(id).orElse(null);
    }

   @Override
    public Livrable saveLivrable(Livrable livrable) {
        return livrableRepository.save(livrable);
    }

 /*
    public Livrable saveLivrablee(Livrable livrable) {
        try {
            Livrable savedLivrable = livrableRepository.save(livrable);

            Evaluation evaluation = new Evaluation();
            evaluation.setLivrable(savedLivrable);
            evaluation.setDate(new Date());
            evaluation.setEtat("en attente");
            evaluationRepository.save(evaluation);

            return savedLivrable;
        } catch (Exception e) {
            // Log or handle the exception
            e.printStackTrace();
            throw new YourCustomException("Error while saving Livrable and Evaluation", e);
        }
    }

*/


    @Override
    public void deleteLivrable(long id) {
        livrableRepository.deleteById(id);
    }


    @Override
    public void uploadFirstDocument(String stepName, MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }

        // Create a new SuiviStage entity
        Livrable livrable = new Livrable();

        // Define the path where you want to save the file
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String filePath = "/users/mac/Documents/" + fileName;


        // Set the appropriate step document path based on the stepName
       /* switch (stepName) {
            case "step1":
                livrable.setStep1DocumentPath(filePath);
                break;
            case "step2":
                livrable.setStep2DocumentPath(filePath);
                break;
            case "step3":
                livrable.setStep3DocumentPath(filePath);
                break;
            case "step4":
                livrable.setStep4DocumentPath(filePath);
                break;
            default:
                throw new IllegalArgumentException("Invalid step name: " + stepName);
        }*/

        // Save the new SuiviStage entity
        livrableRepository.save(livrable);

        // Save the file to the specified path
        // file.transferTo(new File(filePath));
    }

    @Override
    public Livrable addLivrableWithEvaluation(Long besoinId) {
        Besoin besoin = besoinsRepository.findById(besoinId)
                .orElseThrow(() -> new NoSuchElementException("Besoins not found"));

        Livrable livrable = new Livrable();

       // Evaluation evaluation = new Evaluation();
        //evaluation.setLivrable(livrable);


       // livrable.getEvaluations().add(evaluation);
       // evaluationRepository.save(evaluation);

        Livrable savedLivrable = livrableRepository.save(livrable);

        Evaluation evaluation = new Evaluation();
        evaluation.setLivrable(savedLivrable);
        evaluation.setBesoin(besoin);
        evaluation.setDate(new Date());
        evaluation.setEtat("en attente");
        evaluationRepository.save(evaluation);



        return livrableRepository.save(livrable);
    }

    @Override
    public Livrable saveLivrableAndAddIDLivrableAndIdBesoinInEnovation(Livrable livrable, Long besoinId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveLivrableAndAddIDLivrableAndIdBesoinInEnovation'");
    }
}
