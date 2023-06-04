package com.mydieu.tindin.services;

import com.mydieu.tindin.models.*;
import com.mydieu.tindin.exception.ResourceNotFoundException;
import com.mydieu.tindin.payload.ApplicantDto;
import com.mydieu.tindin.payload.JobDto;
import com.mydieu.tindin.repositories.ApplicantRepository;
import com.mydieu.tindin.repositories.JobPostActivityRepository;
import com.mydieu.tindin.repositories.JobPostRepository;
import com.mydieu.tindin.repositories.UserRepository;
import org.springframework.stereotype.Service;


import java.time.Instant;
import java.util.List;
import java.util.Optional;
import com.mydieu.tindin.models.*;


@Service
public class JobService {
    private final JobPostRepository jobPostRepository;
    private final ApplicantRepository applicantRepository;
    private final UserRepository userRepository;
    private final JobPostActivityRepository jobPostActivityRepository;

    public JobService(JobPostRepository jobPostRepository, ApplicantRepository applicantRepository, UserRepository userRepository, JobPostActivityRepository jobPostActivityRepository) {
        this.jobPostRepository = jobPostRepository;
        this.applicantRepository = applicantRepository;
        this.userRepository = userRepository;
        this.jobPostActivityRepository = jobPostActivityRepository;
    }

    public List<JobDto> findJobs(
            Optional<Integer> applicantId,
            Optional<String> jobTitle,
            Optional<String> jobType,
            Optional<String> jobLocation,
            Optional<String> organizationName,
            Optional<String> organizationIndustry,
            Optional<String> skills,
            Optional<String> experienceLevel,
            Optional<Integer> minimumSalary
    ) {
        // TODO: Return jobs for applicant based on filters
        Integer id=77;
        if(applicantId.isPresent()) {
            id = applicantId.get();
        }
        Applicant applicant = applicantRepository.findById(id).orElseThrow();

        List<JobPost> jobFilter = jobPostRepository.findByTitle(applicant.getTitle());
        if (jobFilter.isEmpty()){
            throw new ResourceNotFoundException("No job found");
        }

        return jobFilter.stream().map(JobDto::fromJobPost).toList();
    }

    public JobDto findJobById(Integer jobId) {
        // TODO: Find job by ID
        return null;
    }

    public void createJob(JobDto jobDto) {
        // TODO: Create job
    }

    public void updateJob(Integer jobId, JobDto jobDto) {
        // TODO: Update job

    }

    public void applyForJob(Integer jobId, Integer applicantId, Integer appliedUserId) {
        // TODO: Apply applicant for job
        JobPost jobPost = jobPostRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("Job not found"));
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new ResourceNotFoundException("Applicant not found"));
        User user = userRepository.findById(appliedUserId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found"));
        Instant now = Instant.now();

        JobPostActivity newJobPostActivity = new JobPostActivity();
        newJobPostActivity.setJob(jobPost);
        newJobPostActivity.setApplicant(applicant);
        newJobPostActivity.setUserApplied(user);
        newJobPostActivity.setApplyDate(now);
        jobPostActivityRepository.save(newJobPostActivity);

    }

    public void unapplyForJob(Integer jobId, Integer applicantId) {
        // TODO: Unapply applicant from job
        JobPost jobPost = jobPostRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("Job not found"));
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new ResourceNotFoundException("Applicant not found"));
        try{
        jobPostActivityRepository.deleteByJobIdAndApplicantId(jobPost,applicant);
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }

    }

    public List<ApplicantDto> findApplicantsByJobId(Integer jobId) {
        // TODO: Find applicants applied for job
        return null;
    }

    public List<ApplicantDto> findRecommendedApplicantsByJobId(Integer jobId) {
        // TODO: Find applicants suitable for job
        return null;
    }
}
