package com.klu.exam.controller;

import com.klu.exam.entity.Exam;
import com.klu.exam.repository.ExamRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
public class ExamController {

    private final ExamRepository examRepository;

    public ExamController(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @PostMapping
    public Exam createExam(@RequestBody Exam exam) {
        return examRepository.save(exam);
    }

    @GetMapping
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    @GetMapping("/{id}")
    public Exam getExamById(@PathVariable Long id) {
        return examRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exam not found"));
    }

    @DeleteMapping("/{id}")
    public String deleteExam(@PathVariable Long id) {
        examRepository.deleteById(id);
        return "Exam deleted successfully";
    }
}