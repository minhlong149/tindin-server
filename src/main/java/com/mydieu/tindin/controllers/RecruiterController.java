package com.mydieu.tindin.controllers;

import com.mydieu.tindin.payload.JobDto;
import com.mydieu.tindin.payload.RecruiterDto;
import com.mydieu.tindin.services.RecruiterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/recruiters")
public class RecruiterController {
    public final RecruiterService recruiterService;

    public RecruiterController(RecruiterService recruiterService) {
        this.recruiterService = recruiterService;
    }

    @GetMapping("{recruiterId}")
    public RecruiterDto getRecruiterById(@PathVariable Integer recruiterId) {
        return recruiterService.findRecruiterById(recruiterId);
    }

    // get list of jobs posted by recruiter
    @GetMapping("{recruiterId}/jobs")
    public List<JobDto> getJobsByRecruiterId(@PathVariable Integer recruiterId) {
        return recruiterService.findJobsByRecruiterId(recruiterId);
    }

    @PostMapping("")
    public ResponseEntity<?> createRecruiter(@RequestBody RecruiterDto recruiterDto) {
        recruiterService.createRecruiter(recruiterDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{recruiterId}")
    public void updateRecruiter(@PathVariable Integer recruiterId, @RequestBody RecruiterDto recruiterDto) {
        recruiterService.updateRecruiter(recruiterId, recruiterDto);
    }
}
