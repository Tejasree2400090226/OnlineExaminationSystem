package com.klu.submission.controller;

import com.klu.submission.entity.Submission;
import com.klu.submission.repository.SubmissionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submissions")
public class SubmissionController {

    private final SubmissionRepository submissionRepository;

    public SubmissionController(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    @PostMapping
    public Submission createSubmission(@RequestBody Submission submission) {
        return submissionRepository.save(submission);
    }

    @GetMapping
    public List<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Submission getSubmissionById(@PathVariable Long id) {
        return submissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Submission not found"));
    }

    @DeleteMapping("/{id}")
    public String deleteSubmission(@PathVariable Long id) {
        submissionRepository.deleteById(id);
        return "Submission deleted successfully";
    }
}