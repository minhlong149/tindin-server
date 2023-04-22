package com.mydieu.tindin.services;

import com.mydieu.tindin.payload.ApplicantDto;
import com.mydieu.tindin.payload.JobDto;
import com.mydieu.tindin.repositories.ApplicantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {
    private final ApplicantRepository applicantRepository;

    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public List<ApplicantDto> findApplicants(
            Optional<String> name,
            Optional<String> email,
            Optional<String> phone,
            Optional<String> location,
            Optional<String> skills,
            Optional<String> experience,
            Optional<String> education) {
        // TODO: Return applicants that match the given criteria
        return null;
    }

    public ApplicantDto findApplicantById(Integer applicantId) {
        // TODO: Return applicant with the given ID
        return null;
    }

    public void createApplicant(ApplicantDto applicantDto) {
        // TODO: Create applicant
    }

    public void updateApplicant(Integer applicantId, ApplicantDto applicantDto) {
        // TODO: Update applicant's information with the given ID
    }

    public List<JobDto> findJobsByApplicantId(Integer applicantId) {
        // TODO: Return jobs that the applicant with the given ID has applied for
        return null;
    }
}
