package com.mydieu.tindin.services;

<<<<<<< HEAD
import com.mydieu.tindin.exception.InvalidRequestException;
import com.mydieu.tindin.exception.ResourceNotFoundException;
import com.mydieu.tindin.models.JobPost;
import com.mydieu.tindin.models.Recruiter;
import com.mydieu.tindin.payload.ApplicantDto;
import com.mydieu.tindin.payload.JobDto;
import com.mydieu.tindin.payload.JobRegistration;
import com.mydieu.tindin.repositories.JobPostRepository;
import com.mydieu.tindin.repositories.RecruiterRepository;
=======
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
>>>>>>> b80118a1fabd57b4f0f32d952c1790be740a12e4
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    private final JobPostRepository jobPostRepository;
    private final RecruiterRepository recruiterRepository;

<<<<<<< HEAD
    public JobService(JobPostRepository jobPostRepository, RecruiterRepository recruiterRepository) {
=======


    public JobService(JobPostRepository jobPostRepository, RecruiterRepository recruiterRepository, JobTypeRepository jobTypeRepository) {
>>>>>>> b80118a1fabd57b4f0f32d952c1790be740a12e4
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
        // Integer id,
        // RecruiterDto recruiter,
        // String title,
        // String description,
        // String jobType,
        // Integer salary,
        // Instant createdDate,
        // Instant closingDate,
        // Boolean isOpen,

    public void createJob(JobRegistration job) {
        // TODO: Create job
<<<<<<< HEAD
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
        
=======
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
>>>>>>> b80118a1fabd57b4f0f32d952c1790be740a12e4
    }

    public void updateJob(Integer jobId, JobRegistration newJob) {
        // TODO: Update job
        JobPost job = jobPostRepository.findById(jobId).orElseThrow(()-> new ResourceNotFoundException("Job not found"));
<<<<<<< HEAD
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
=======
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
>>>>>>> b80118a1fabd57b4f0f32d952c1790be740a12e4
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
