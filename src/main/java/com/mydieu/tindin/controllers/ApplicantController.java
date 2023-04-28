package com.mydieu.tindin.controllers;

import com.mydieu.tindin.payload.ApplicantDto;
import com.mydieu.tindin.payload.JobDto;
import com.mydieu.tindin.services.ApplicantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/applicants")
public class ApplicantController {
    private final ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping("")
    public List<ApplicantDto> getApplicants(
            @RequestParam Optional<String> name,
            @RequestParam Optional<String> email,
            @RequestParam Optional<String> phone,
            @RequestParam Optional<String> location,
            @RequestParam Optional<String> skills,
            @RequestParam Optional<String> experience,
            @RequestParam Optional<String> education
    ) {
        return applicantService.findApplicants(name, email, phone, location, skills, experience, education);
    }

    @GetMapping("{applicantId}")
    public ApplicantDto getApplicant(@PathVariable Integer applicantId) {
        return applicantService.findApplicantById(applicantId);
    }

    @GetMapping("{applicantId}/jobs")
    public List<JobDto> getJobs(@PathVariable Integer applicantId) {
        return applicantService.findJobsByApplicantId(applicantId);
    }

    @PostMapping("")
    public ResponseEntity<?> createApplicant(@RequestBody ApplicantDto applicantDto) {
        applicantService.createApplicant(applicantDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{applicantId}")
    public void updateApplicant(@PathVariable Integer applicantId, @RequestBody ApplicantDto applicantDto) {
        applicantService.updateApplicant(applicantId, applicantDto);
    }

}
