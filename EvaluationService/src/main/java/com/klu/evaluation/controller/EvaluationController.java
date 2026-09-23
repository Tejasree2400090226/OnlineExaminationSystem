package com.klu.evaluation.controller;

import com.klu.evaluation.entity.Evaluation;
import com.klu.evaluation.repository.EvaluationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluations")
public class EvaluationController {

    private final EvaluationRepository evaluationRepository;

    public EvaluationController(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    @PostMapping
    public Evaluation createEvaluation(@RequestBody Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    @GetMapping
    public List<Evaluation> getAllEvaluations() {
        return evaluationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Evaluation getEvaluationById(@PathVariable Long id) {
        return evaluationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluation not found"));
    }

    @DeleteMapping("/{id}")
    public String deleteEvaluation(@PathVariable Long id) {
        evaluationRepository.deleteById(id);
        return "Evaluation deleted successfully";
    }
}