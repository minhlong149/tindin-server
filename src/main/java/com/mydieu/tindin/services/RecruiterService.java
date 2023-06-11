package com.mydieu.tindin.services;

import com.mydieu.tindin.exception.DuplicateResourceException;
import com.mydieu.tindin.exception.InvalidRequestException;
import com.mydieu.tindin.exception.ResourceNotFoundException;
import com.mydieu.tindin.models.*;
import com.mydieu.tindin.payload.JobDto;
import com.mydieu.tindin.payload.RecruiterDto;
import com.mydieu.tindin.payload.RecruiterRegistration;
import com.mydieu.tindin.repositories.AccountRepository;
import com.mydieu.tindin.repositories.JobPostRepository;
import com.mydieu.tindin.repositories.OrganizationRepository;
import com.mydieu.tindin.repositories.RecruiterRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecruiterService {
    private final RecruiterRepository recruiterRepository;
    private final JobPostRepository jobPostRepository;
    private final AccountRepository accountRepository;
    private final OrganizationRepository organizationRepository;
    private final PasswordEncoder passwordEncoder;

    public RecruiterService(RecruiterRepository recruiterRepository, JobPostRepository jobPostRepository, AccountRepository accountRepository, OrganizationRepository organizationRepository, PasswordEncoder passwordEncoder) {
        this.recruiterRepository = recruiterRepository;
        this.jobPostRepository = jobPostRepository;
        this.accountRepository = accountRepository;
        this.organizationRepository = organizationRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RecruiterDto findRecruiterById(Integer recruiterId) {
        return recruiterRepository.findById(recruiterId)
                .map(RecruiterDto::fromRecruiter)
                .orElseThrow(() -> new ResourceNotFoundException("Recruiter not found"));
    }

    public RecruiterDto createRecruiter(RecruiterRegistration recruiter) {
        if (recruiter.username() == null || recruiter.username().isBlank()) {
            throw new InvalidRequestException("Username is required");
        }

        if (recruiter.password() == null || recruiter.password().isBlank()) {
            throw new InvalidRequestException("Password is required");
        }

        if (recruiter.firstName() == null || recruiter.firstName().isBlank()) {
            throw new InvalidRequestException("First name is required");
        }

        if (recruiter.organizationId() == null) {
            throw new InvalidRequestException("Organization ID is required");
        }

        Boolean usernameIsTaken = accountRepository.existsByUsername(recruiter.username());
        if (usernameIsTaken) {
            throw new DuplicateResourceException("Username is already taken");
        }

        Organization organization = organizationRepository.findById(recruiter.organizationId())
                .orElseThrow(() -> new InvalidRequestException("Organization ID is invalid"));

        User newUser = new User(
                new Account(recruiter.username(), passwordEncoder.encode(recruiter.password())),
                Role.RECRUITER,
                recruiter.firstName(),
                recruiter.lastName(),
                recruiter.gender(),
                recruiter.dateOfBirth(),
                recruiter.profileUrl(),
                recruiter.phone(),
                recruiter.email(),
                recruiter.website()
        );
        Recruiter newRecruiter = new Recruiter(newUser, organization);
        recruiterRepository.save(newRecruiter);
        return RecruiterDto.fromRecruiter(newRecruiter);
    }

    public RecruiterDto updateRecruiter(Integer recruiterId, RecruiterRegistration newRecruiter) {
        Recruiter recruiter = recruiterRepository.findById(recruiterId)
                .orElseThrow(() -> new ResourceNotFoundException("Recruiter not found"));

        if (newRecruiter.username() != null && !newRecruiter.username().isBlank()) {
            Boolean usernameIsTaken = accountRepository.existsByUsername(newRecruiter.username());
            if (usernameIsTaken) {
                throw new DuplicateResourceException("Username is already taken");
            }
            recruiter.getUser().getAccount().setUsername(newRecruiter.username());
        }

        if (newRecruiter.password() != null && !newRecruiter.password().isBlank()) {
            recruiter.getUser().getAccount().setPassword(passwordEncoder.encode(newRecruiter.password()));
        }

        if (newRecruiter.firstName() != null && !newRecruiter.firstName().isBlank()) {
            recruiter.getUser().setFirstName(newRecruiter.firstName());
        }

        if (newRecruiter.lastName() != null && !newRecruiter.lastName().isBlank()) {
            recruiter.getUser().setLastName(newRecruiter.lastName());
        }

        if (newRecruiter.gender() != null) {
            recruiter.getUser().setGender(newRecruiter.gender());
        }

        if (newRecruiter.dateOfBirth() != null) {
            recruiter.getUser().setDateOfBirth(newRecruiter.dateOfBirth());
        }

        if (newRecruiter.profileUrl() != null && !newRecruiter.profileUrl().isBlank()) {
            recruiter.getUser().setProfileUrl(newRecruiter.profileUrl());
        }

        if (newRecruiter.phone() != null && !newRecruiter.phone().isBlank()) {
            recruiter.getUser().setPhone(newRecruiter.phone());
        }

        if (newRecruiter.email() != null && !newRecruiter.email().isBlank()) {
            recruiter.getUser().setEmail(newRecruiter.email());
        }

        if (newRecruiter.website() != null && !newRecruiter.website().isBlank()) {
            recruiter.getUser().setWebsite(newRecruiter.website());
        }

        if (newRecruiter.organizationId() != null) {
            Organization organization = organizationRepository.findById(newRecruiter.organizationId())
                    .orElseThrow(() -> new InvalidRequestException("Organization ID is invalid"));
            recruiter.setOrganization(organization);
        }

        recruiterRepository.save(recruiter);
        return RecruiterDto.fromRecruiter(recruiter);
    }

    public List<JobDto> findJobsByRecruiterId(Integer recruiterId, Optional<Integer> pageNumber, Optional<Integer> pageSize) {
        Integer currentPage = pageNumber.orElse(0);
        Integer currentPageSize = pageSize.orElse(10);
        Pageable pageable = PageRequest.of(currentPage, currentPageSize);

        List<JobPost> jobPosts = jobPostRepository.findByRecruiterId(recruiterId, pageable);

        if (jobPosts.isEmpty()) {
            throw new ResourceNotFoundException("No job found");
        }

        return jobPosts.stream().map(JobDto::fromJobPost).toList();
    }
}
