package com.mydieu.tindin.services;

import com.mydieu.tindin.exception.ResourceNotFoundException;
import com.mydieu.tindin.models.JobPost;
import com.mydieu.tindin.payload.JobDto;
import com.mydieu.tindin.payload.RecruiterDto;
import com.mydieu.tindin.payload.RecruiterRegistration;
import com.mydieu.tindin.repositories.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecruiterService {
    private final RecruiterRepository recruiterRepository;
    private final JobPostRepository jobPostRepository;
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final OrganizationRepository organizationRepository;

    public RecruiterService(RecruiterRepository recruiterRepository, JobPostRepository jobPostRepository, AccountRepository accountRepository, UserRepository userRepository, OrganizationRepository organizationRepository) {
        this.recruiterRepository = recruiterRepository;
        this.jobPostRepository = jobPostRepository;
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.organizationRepository = organizationRepository;
    }

    public RecruiterDto findRecruiterById(Integer recruiterId) {
        return recruiterRepository.findById(recruiterId)
                .map(RecruiterDto::fromRecruiter)
                .orElseThrow(() -> new ResourceNotFoundException("Recruiter not found"));
    }

    public void createRecruiter(RecruiterRegistration recruiterRegistration) {
        // String username = recruiterRegistration.username();
        // Boolean usernameIsTaken = accountRepository.existsByUsername(username);
        // if (usernameIsTaken) {
        //     throw new IllegalArgumentException("Username is already taken");
        // }
        //
        // System.out.println("> Username " + username + " is not taken");
        //
        // String password = recruiterRegistration.password();
        // Account newAccount = accountRepository.save(new Account(username, password));
        //
        // System.out.println("> Account created");
        //
        // String firstName = recruiterRegistration.firstName();
        // User newUser = userRepository.save(new User(newAccount, Role.RECRUITER, firstName));
        //
        // System.out.println("> User created");
        //
        // Integer organizationId = recruiterRegistration.organizationId();
        // Organization organization = organizationRepository.findById(organizationId)
        //         .orElseThrow(() -> new ResourceNotFoundException("Organization not found"));
        //
        // System.out.println("> Found organization" + organization.getName());
        //
        // recruiterRepository.save(new Recruiter(newUser, organization));
    }

    public void updateRecruiter(Integer recruiterId, RecruiterDto recruiterDto) {
        // TODO: Update recruiter info by id
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
