package com.mydieu.tindin.services;

import com.mydieu.tindin.exception.ResourceNotFoundException;
import com.mydieu.tindin.models.JobPost;
import com.mydieu.tindin.payload.JobDto;
import com.mydieu.tindin.payload.RecruiterDto;
import com.mydieu.tindin.repositories.JobPostRepository;
import com.mydieu.tindin.repositories.RecruiterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruiterService {
    private final RecruiterRepository recruiterRepository;
    private final JobPostRepository jobPostRepository;

    public RecruiterService(RecruiterRepository recruiterRepository, JobPostRepository jobPostRepository) {
        this.recruiterRepository = recruiterRepository;
        this.jobPostRepository = jobPostRepository;
    }

    public RecruiterDto findRecruiterById(Integer recruiterId) {
        return recruiterRepository.findById(recruiterId)
                .map(RecruiterDto::fromRecruiter)
                .orElseThrow(() -> new ResourceNotFoundException("Recruiter not found"));
    }

    public void createRecruiter(RecruiterDto recruiterDto) {
        // TODO: Create recruiter
    }

    public void updateRecruiter(Integer recruiterId, RecruiterDto recruiterDto) {
        // TODO: Update recruiter info by id
    }

    public List<JobDto> findJobsByRecruiterId(Integer recruiterId) {
        List<JobPost> jobPosts = jobPostRepository.findByRecruiterId(recruiterId);

        if (jobPosts.isEmpty()) {
            throw new ResourceNotFoundException("No job found");
        }

        return jobPosts.stream().map(JobDto::fromJobPost).toList();
    }
}
