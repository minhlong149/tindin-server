package com.mydieu.tindin.controllers;

import com.mydieu.tindin.payload.ApplicantDto;
import com.mydieu.tindin.payload.JobDto;
import com.mydieu.tindin.payload.JobSmallDto;
import com.mydieu.tindin.services.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("")
    public List<JobSmallDto> getJobs(
            @RequestBody Optional<Integer> applicantId,
            @RequestParam Optional<String> jobTitle,
            @RequestParam Optional<String> jobType,
            @RequestParam Optional<String> jobLocation,
            @RequestParam Optional<String> organizationName,
            @RequestParam Optional<String> organizationIndustry,
            @RequestParam Optional<String> skills,
            @RequestParam Optional<String> experienceLevel,
            @RequestParam Optional<Integer> minimumSalary
    ) {
        return jobService.findJobs(applicantId, jobTitle, jobType, jobLocation, organizationName, organizationIndustry, skills, experienceLevel, minimumSalary);
    }

    @GetMapping("{jobId}")
    public JobDto getJob(@PathVariable Integer jobId) {
        return jobService.findJobById(jobId);
    }

    @GetMapping("{jobId}/applicants")
    public List<ApplicantDto> getApplicants(@PathVariable Integer jobId) {
        return jobService.findApplicantsByJobId(jobId);
    }

    @GetMapping("{jobId}/recommended")
    public List<ApplicantDto> getRecommendedApplicants(@PathVariable Integer jobId) {
        return jobService.findRecommendedApplicantsByJobId(jobId);
    }

    @PostMapping("")
    public void createJob(@RequestBody JobDto jobDto) {
        jobService.createJob(jobDto);
    }

    @PutMapping("{jobId}")
    public void updateJob(@PathVariable Integer jobId, @RequestBody JobDto jobDto) {
        jobService.updateJob(jobId, jobDto);
    }

    // TODO: Get applied user's ID (candidate or recruiter) from token to store to database
    @PostMapping("{jobId}")
    public void applyForJob(
            @PathVariable Integer jobId,
            @RequestParam Integer appliedUserId,
            @RequestParam Integer applicantId
    ) {
        jobService.applyForJob(jobId, applicantId, appliedUserId);
    }

    @DeleteMapping("{jobId}")
    public void upApplyForJob(@PathVariable Integer jobId, @RequestBody Integer applicantId) {
        jobService.unapplyForJob(jobId, applicantId);
    }
}
