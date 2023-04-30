package com.mydieu.tindin.controllers;

import com.mydieu.tindin.payload.JobDto;
import com.mydieu.tindin.payload.RecruiterDto;
import com.mydieu.tindin.payload.RecruiterRegistration;
import com.mydieu.tindin.services.RecruiterService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("{recruiterId}/jobs")
    public List<JobDto> getJobsByRecruiterId(
            @PathVariable Integer recruiterId,
            @RequestParam Optional<Integer> pageNumber,
            @RequestParam Optional<Integer> pageSize
    ) {
        return recruiterService.findJobsByRecruiterId(recruiterId, pageNumber, pageSize);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public RecruiterDto createRecruiter(@RequestBody RecruiterRegistration recruiterRegistration) {
        return recruiterService.createRecruiter(recruiterRegistration);
    }

    @PutMapping("{recruiterId}")
    public void updateRecruiter(@PathVariable Integer recruiterId, @RequestBody RecruiterDto recruiterDto) {
        recruiterService.updateRecruiter(recruiterId, recruiterDto);
    }
}
