package com.mydieu.tindin.services;

import com.mydieu.tindin.payload.JobDto;
import com.mydieu.tindin.payload.RecruiterDto;
import com.mydieu.tindin.repositories.RecruiterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruiterService {
    private final RecruiterRepository recruiterRepository;

    public RecruiterService(RecruiterRepository recruiterRepository) {
        this.recruiterRepository = recruiterRepository;
    }

    public RecruiterDto findRecruiterById(Integer recruiterId) {
        // TODO: Find recruiter by id
        return null;
    }

    public void createRecruiter(RecruiterDto recruiterDto) {
        // TODO: Create recruiter
    }

    public void updateRecruiter(Integer recruiterId, RecruiterDto recruiterDto) {
        // TODO: Update recruiter info by id
    }

    public List<JobDto> findJobsByRecruiterId(Integer recruiterId) {
        // TODO: Find jobs posted by recruiter
        return null;
    }
}
