package com.example.pidev.Service;

import java.util.List;

import com.example.pidev.entities.Evaluation;

public interface EvaluationService {
    List<Evaluation> getAllEvaluations();

    Evaluation getEvaluationById(long id);

    Evaluation createEvaluation(Evaluation evaluation);

    Evaluation updateEvaluation(long id, Evaluation evaluation);

    void deleteEvaluation(long id);

    List<Evaluation> getAllEvaluationsByIdBesoinIdLivrable(Long besoinId, Long livrableId);


   void acceptEvaluation(long evaluationId);
    void refuserEvaluation(long evaluationId);

    //rating
    Evaluation updateRating(Long id, int newRating);
}