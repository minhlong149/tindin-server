package com.mydieu.tindin.services;

import com.mydieu.tindin.exception.ResourceNotFoundException;
import com.mydieu.tindin.models.JobPost;
import com.mydieu.tindin.models.JobType;
import com.mydieu.tindin.models.Recruiter;
import com.mydieu.tindin.payload.ApplicantDto;
import com.mydieu.tindin.payload.JobDto;
import com.mydieu.tindin.payload.RecruiterDto;
import com.mydieu.tindin.repositories.JobPostRepository;
import com.mydieu.tindin.repositories.RecruiterRepository;
import com.mydieu.tindin.repositories.*;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    private final JobPostRepository jobPostRepository;



    public JobService(JobPostRepository jobPostRepository, RecruiterRepository recruiterRepository, JobTypeRepository jobTypeRepository) {
        this.jobPostRepository = jobPostRepository;
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
        return null;
    }

    public JobDto findJobById(Integer jobId) {
        // TODO: Find job by ID
        return jobPostRepository.findById(jobId).map(JobDto::fromJobPost).orElseThrow(() -> new ResourceNotFoundException("Job not found"));
    }
        // Integer id,
        // RecruiterDto recruiter,
        // String title,
        // String description,
        // String jobType,
        // Integer salary,
        // Instant createdDate,
        // Instant closingDate,
        // Boolean isOpen,

    public void createJob(JobDto jobDto) {
        // TODO: Create job
        JobPost newJob = new JobPost();
        newJob.setId(jobDto.id());
        newJob.setRecruiter_id(jobDto.recruiter_id());
        newJob.setTitle(jobDto.title());
        newJob.setDescription(jobDto.description());
        newJob.setJobType_id(jobDto.jobType_id());
        newJob.setSalary(jobDto.salary());
        newJob.setCreatedDate(jobDto.createdDate());
        newJob.setClosingDate(jobDto.closingDate());
        newJob.setIsOpen(jobDto.isOpen());
        jobPostRepository.save(newJob);
    }

    public void updateJob(Integer jobId, JobDto jobDto) {
        // TODO: Update job
        JobPost job = jobPostRepository.findById(jobId).orElseThrow(()-> new ResourceNotFoundException("Job not found"));
        if(jobDto.title() != null && !jobDto.title().isBlank()) {
            job.setTitle(jobDto.title());
        }
        if(jobDto.recruiter_id() != null) {
            job.setRecruiter_id(jobDto.recruiter_id());
        }
        if(jobDto.description() != null && !jobDto.description().isBlank()) {
            job.setDescription(jobDto.description());
        }
        if(jobDto.jobType_id() != null) {
            job.setJobType_id(jobDto.jobType_id());
        }
        if(jobDto.salary() != null) {
            job.setSalary(jobDto.salary());
        }
        if(jobDto.createdDate() != null) {
            job.setCreatedDate(jobDto.createdDate());
        }
        if(jobDto.closingDate() != null) {
            job.setClosingDate(jobDto.closingDate());
        }
        if(jobDto.isOpen() != null) {
            job.setIsOpen(jobDto.isOpen());
        }
        jobPostRepository.save(job);

    }

    public void applyForJob(Integer jobId, Integer applicantId, Integer appliedUserId) {
        // TODO: Apply applicant for job
    }

    public void unapplyForJob(Integer jobId, Integer applicantId) {
        // TODO: Unapply applicant from job
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
