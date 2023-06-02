package com.mydieu.tindin.services;

import com.mydieu.tindin.models.*;
import com.mydieu.tindin.exception.ResourceNotFoundException;
import com.mydieu.tindin.payload.ApplicantDto;
import com.mydieu.tindin.payload.JobDto;
import com.mydieu.tindin.payload.JobSmallDto;
import com.mydieu.tindin.repositories.ApplicantRepository;
import com.mydieu.tindin.repositories.JobPostActivityRepository;
import com.mydieu.tindin.repositories.JobPostRepository;
import com.mydieu.tindin.repositories.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.mydieu.tindin.utils.Retrieval;
import com.mydieu.tindin.specification.JobPostSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;



@Service
public class JobService {
    private final JobPostRepository jobPostRepository;
    private final ApplicantRepository applicantRepository;
    private final UserRepository userRepository;
    private final JobPostActivityRepository jobPostActivityRepository;
    public JobService(JobPostRepository jobPostRepository,
                      ApplicantRepository applicantRepository,
                      UserRepository userRepository,
                      JobPostActivityRepository jobPostActivityRepository
                      //RecruiterRepository recruiterRepository,
                      //JobTypeRepository jobTypeRepository
        ) {
        this.jobPostRepository = jobPostRepository;
        this.applicantRepository = applicantRepository;
        this.userRepository = userRepository;
        this.jobPostActivityRepository = jobPostActivityRepository;
    }

    public List<JobSmallDto> findJobs(
            Optional<Integer> applicantId,
            Optional<String> jobTitle,
            Optional<String> jobType,
            Optional<String> jobLocation,
            Optional<String> organizationName,
            Optional<String> organizationIndustry,
            Optional<String> skills,
            Optional<String> experienceLevel,
            Optional<Integer> minimumSalary,
            Optional<Integer> pageNumber,
            Optional<Integer> pageSize)
    {
        // TODO: Return jobs for applicant based on filters
        Integer id=0;
        if(applicantId.isPresent()) {
            id = applicantId.orElse(0);
        }
        Applicant applicant = applicantRepository.findById(id).orElseThrow();

        Specification<JobPost> spec = Specification.where(null);

        if (jobTitle.isPresent()) {
            spec = spec.and(JobPostSpecification.jobTitleContains(jobTitle.orElse("")));
        }

        if (jobType.isPresent()) {
            spec = spec.and(JobPostSpecification.jobTypeLike(jobType.get()));
        }

        if (jobLocation.isPresent()) {
            spec = spec.and(JobPostSpecification.jobLocationLike(jobLocation.get()));
        }

        if (organizationName.isPresent()){
            spec=spec.and(JobPostSpecification.jobOrganizationNameLike(organizationName.get()));
        }

        if(organizationIndustry.isPresent()) {
            spec =spec.and(JobPostSpecification.jobOrganizationIndustryLike(organizationIndustry.get()));
        }

        if(skills.isPresent()){
            spec=spec.and(JobPostSpecification.jobSkillIs(skills.get()));
        }

        if(experienceLevel.isPresent()){
            spec=spec.and(JobPostSpecification.jobExperienceLevelIs(experienceLevel.get()));
        }

        if(minimumSalary.isPresent()){
            spec=spec.and(JobPostSpecification.jobMinimumSalaryIs(minimumSalary.get()));
        }else{
            spec=spec.and(JobPostSpecification.jobMinimumSalaryIs(applicant.getPreferSalary()));
        }
        Integer currentPage = pageNumber.orElse(0);
        Integer currentPageSize = pageSize.orElse(15);

        List<JobPost> jobFilter = jobPostRepository.findAll(spec).subList(currentPage*currentPageSize,currentPageSize*(currentPage+1));
        List<JobPost> jobPostsSortList = Retrieval.sortJobPosts(jobFilter,applicant);
        return jobPostsSortList.stream().map(JobSmallDto::fromJobPost).toList();
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
        ZoneOffset zoneOffset = ZoneOffset.ofHours(7);
        OffsetDateTime offsetDateTime = OffsetDateTime.of(2022, 12, 31, 23, 59, 59, 0, zoneOffset);
        Instant now = offsetDateTime.toInstant();

        Applicant checkExist = jobPostActivityRepository.findApplicantByJobAndAppplicant(jobId, applicantId);
        if(checkExist != null) {
            throw new ResourceNotFoundException("Have applied");
        }
        else {
            JobPostActivity newJobPostActivity = new JobPostActivity();
            newJobPostActivity.setJob(jobPost);
            newJobPostActivity.setApplicant(applicant);
            newJobPostActivity.setUserApplied(user);
            newJobPostActivity.setApplyDate(now);
            jobPostActivityRepository.saveAndFlush(newJobPostActivity);
        }

    }

    public void unapplyForJob(Integer jobId, Integer applicantId) {
        // TODO: Unapply applicant from job
            Applicant checkExist = jobPostActivityRepository.findApplicantByJobAndAppplicant(jobId,applicantId);
            if(checkExist == null) {
                throw new ResourceNotFoundException( "Haven't applied yet");
            }
            else {
                jobPostActivityRepository.deleteByJobIdAndApplicantId(jobId, applicantId);
            }

    }

    public List<ApplicantDto> findApplicantsByJobId(Integer jobId) {
        // TODO: Find applicants applied for job
        JobPost jobPost = jobPostRepository.findById(jobId).orElseThrow(() -> new ResourceNotFoundException("Job not found"));
        List<Applicant> applicantList = jobPostActivityRepository.findApplicantByJob(jobPost);
        return applicantList.stream().map(ApplicantDto::fromApplicant).toList();
    }

    public List<ApplicantDto> findRecommendedApplicantsByJobId(Integer jobId) {
        // TODO: Find applicants suitable for job
        JobPost jobPost = jobPostRepository.findById(jobId).orElseThrow(() -> new ResourceNotFoundException("Job not found"));
        List<Applicant> applicantList = jobPostActivityRepository.findApplicantByJob(jobPost);
        List<Applicant> sortApplicant = Retrieval.sortApplicants(applicantList,jobPost);
        return sortApplicant.stream().map(ApplicantDto::fromApplicant).toList();

    }
}
