package com.mydieu.tindin.services;

import com.mydieu.tindin.exception.InvalidRequestException;
import com.mydieu.tindin.exception.ResourceNotFoundException;
import com.mydieu.tindin.models.JobPost;
import com.mydieu.tindin.models.Recruiter;
import com.mydieu.tindin.payload.ApplicantDto;
import com.mydieu.tindin.payload.JobDto;
import com.mydieu.tindin.payload.JobRegistration;
import com.mydieu.tindin.repositories.JobPostRepository;
import com.mydieu.tindin.repositories.RecruiterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    private final JobPostRepository jobPostRepository;
    private final RecruiterRepository recruiterRepository;

    public JobService(JobPostRepository jobPostRepository, RecruiterRepository recruiterRepository) {
        this.jobPostRepository = jobPostRepository;
        this.recruiterRepository = recruiterRepository;
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

    public void createJob(JobRegistration job) {
        // TODO: Create job
        if(job.recruiterId() == null) {
            throw new InvalidRequestException("Recruiter Id is required");
        }
        JobPost newJob = new JobPost(
                new Recruiter(job.user(), job.organization()),
                job.recruiterId(),
                job.title(),
                job.description(),
                job.jobTypeId(),
                job.salary(),
                job.createdDate(),
                job.closingDate(),
                job.isOpen()
                
        );
        jobPostRepository.save(newJob);
        
    }

    public void updateJob(Integer jobId, JobRegistration newJob) {
        // TODO: Update job
        JobPost job = jobPostRepository.findById(jobId).orElseThrow(()-> new ResourceNotFoundException("Job not found"));
        if(newJob.title() != null && !newJob.title().isBlank()) {
            job.setTitle(newJob.title());
        }
        if(newJob.recruiterId() != null) {
            Recruiter recruiter = recruiterRepository.findById(newJob.recruiterId())
                    .orElseThrow(() -> new InvalidRequestException("Recruiter ID is invalid"));
            job.setRecruiter(recruiter);
        }
        if(newJob.description() != null && !newJob.description().isBlank()) {
            job.setDescription(newJob.description());
        }
        if(newJob.jobType() != null) {
            job.setJobType(newJob.jobType());
        }
        if(newJob.salary() != null) {
            job.setSalary(newJob.salary());
        }
        if(newJob.createdDate() != null) {
            job.setCreatedDate(newJob.createdDate());
        }
        if(newJob.closingDate() != null) {
            job.setClosingDate(newJob.closingDate());
        }
        if(newJob.isOpen() != null) {
            job.setIsOpen(newJob.isOpen());
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
