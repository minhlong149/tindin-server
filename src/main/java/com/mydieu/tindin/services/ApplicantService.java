package com.mydieu.tindin.services;

import com.mydieu.tindin.exception.DuplicateResourceException;
import com.mydieu.tindin.exception.InvalidRequestException;
import com.mydieu.tindin.exception.ResourceNotFoundException;
import com.mydieu.tindin.models.*;
import com.mydieu.tindin.payload.ApplicantDto;
import com.mydieu.tindin.payload.ApplicantRegistration;
import com.mydieu.tindin.payload.JobDto;
import com.mydieu.tindin.repositories.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {
    private final ApplicantRepository applicantRepository;
    private final AccountRepository accountRepository;
    private final ExperienceLevelRepository experienceLevelRepository;
    private final LocationRepository locationRepository;
    private final JobTypeRepository jobTypeRepository;
    private final IndustryRepository industryRepository;
    private final DegreeRepository degreeRepository;
    private final MajorRepository majorRepository;
    private final OrganizationRepository organizationRepository;

    public ApplicantService(ApplicantRepository applicantRepository, AccountRepository accountRepository, ExperienceLevelRepository experienceLevelRepository, LocationRepository locationRepository, JobTypeRepository jobTypeRepository, IndustryRepository industryRepository, DegreeRepository degreeRepository, MajorRepository majorRepository, OrganizationRepository organizationRepository) {
        this.applicantRepository = applicantRepository;
        this.accountRepository = accountRepository;
        this.experienceLevelRepository = experienceLevelRepository;
        this.locationRepository = locationRepository;
        this.jobTypeRepository = jobTypeRepository;
        this.industryRepository = industryRepository;
        this.degreeRepository = degreeRepository;
        this.majorRepository = majorRepository;
        this.organizationRepository = organizationRepository;
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
        return applicantRepository.findById(applicantId)
                .map(ApplicantDto::fromApplicant)
                .orElseThrow(() -> new ResourceNotFoundException("Applicant not found"));
    }

    public ApplicantDto createApplicant(ApplicantRegistration applicant) {
        if (applicant.username() == null || applicant.username().isBlank()) {
            throw new InvalidRequestException("Username is required");
        }

        if (applicant.password() == null || applicant.password().isBlank()) {
            throw new InvalidRequestException("Password is required");
        }

        if (applicant.firstName() == null || applicant.firstName().isBlank()) {
            throw new InvalidRequestException("First name is required");
        }

        Boolean usernameIsTaken = accountRepository.existsByUsername(applicant.username());
        if (usernameIsTaken) {
            throw new DuplicateResourceException("Username is already taken");
        }

        User newUser = new User(
                new Account(applicant.username(), applicant.password()),
                Role.CANDIDATE,
                applicant.firstName(),
                applicant.lastName(),
                applicant.gender(),
                applicant.dateOfBirth(),
                applicant.profileUrl(),
                applicant.phone(),
                applicant.email(),
                applicant.website()
        );

        Applicant newApplicant = new Applicant(newUser);
        updateApplicantInfo(newApplicant, applicant);

        applicantRepository.save(newApplicant);
        return ApplicantDto.fromApplicant(newApplicant);
    }

    private void updateApplicantInfo(Applicant applicant, ApplicantRegistration applicantRegistration) {
        if (applicantRegistration.openForJob() != null) {
            applicant.setOpenForJob(applicantRegistration.openForJob());
        }

        if (applicantRegistration.title() != null && !applicantRegistration.title().isBlank()) {
            applicant.setTitle(applicantRegistration.title());
        }

        if (applicantRegistration.experienceLevelId() != null) {
            ExperienceLevel experienceLevel = experienceLevelRepository.findById(applicantRegistration.experienceLevelId())
                    .orElseThrow(() -> new ResourceNotFoundException("Experience level not found"));
            applicant.setExperienceLevel(experienceLevel);
        }

        if (applicantRegistration.preferLocationId() != null) {
            Location location = locationRepository.findById(applicantRegistration.preferLocationId())
                    .orElseThrow(() -> new ResourceNotFoundException("Location not found"));
            applicant.setPreferLocation(location);
        }

        if (applicantRegistration.preferJobTypeId() != null) {
            JobType jobType = jobTypeRepository.findById(applicantRegistration.preferJobTypeId())
                    .orElseThrow(() -> new ResourceNotFoundException("Job type not found"));
            applicant.setPreferJobType(jobType);
        }

        if (applicantRegistration.preferIndustryId() != null) {
            Industry industry = industryRepository.findById(applicantRegistration.preferIndustryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Industry not found"));
            applicant.setPreferIndustry(industry);
        }

        if (applicantRegistration.preferSalary() != null) {
            applicant.setPreferSalary(applicantRegistration.preferSalary());
        }

        if (applicantRegistration.educations() != null && !applicantRegistration.educations().isEmpty()) {
            applicantRegistration.educations().forEach(education -> {
                if (education.universityName() == null || education.universityName().isBlank()) {
                    throw new InvalidRequestException("University name is required");
                }

                ApplicantEducation applicantEducation = new ApplicantEducation(
                        applicant,
                        education.universityName()
                );

                if (education.degreeId() != null) {
                    Degree degree = degreeRepository.findById(education.degreeId())
                            .orElseThrow(() -> new ResourceNotFoundException("Degree for " + education.universityName() + " not found"));
                    applicantEducation.setDegree(degree);
                }

                if (education.majorId() != null) {
                    Major major = majorRepository.findById(education.majorId())
                            .orElseThrow(() -> new ResourceNotFoundException("Major for " + education.universityName() + " not found"));
                    applicantEducation.setMajor(major);
                }

                if (education.locationId() != null) {
                    Location location = locationRepository.findById(education.locationId())
                            .orElseThrow(() -> new ResourceNotFoundException("Location for " + education.universityName() + " not found"));
                    applicantEducation.setLocation(location);
                }

                if (education.startDate() != null) {
                    try {
                        LocalDate startDate = LocalDate.parse(education.startDate());
                        applicantEducation.setStartDate(startDate);
                    } catch (DateTimeParseException e) {
                        throw new InvalidRequestException("Start date for " + education.universityName() + " is invalid");
                    }
                }

                if (education.completionDate() != null) {
                    try {
                        LocalDate completionDate = LocalDate.parse(education.completionDate());
                        applicantEducation.setCompletionDate(completionDate);
                    } catch (DateTimeParseException e) {
                        throw new InvalidRequestException("Completion date for " + education.universityName() + " is invalid");
                    }
                }

                if (education.gpa() != null) {
                    applicantEducation.setGpa(education.gpa());
                }

                applicant.getApplicantEducations().add(applicantEducation);
            });
        }

        if (applicantRegistration.experiences() != null && !applicantRegistration.experiences().isEmpty()) {
            applicantRegistration.experiences().forEach(experience -> {
                if (experience.organizationId() == null) {
                    throw new InvalidRequestException("Organization id is required");
                }

                Organization organization = organizationRepository.findById(experience.organizationId())
                        .orElseThrow(() -> new ResourceNotFoundException("Organization not found"));

                ApplicantExperience applicantExperience = new ApplicantExperience(
                        applicant,
                        organization
                );

                if (experience.title() != null && !experience.title().isBlank()) {
                    applicantExperience.setTitle(experience.title());
                }

                if (experience.experienceLevelId() != null) {
                    ExperienceLevel experienceLevel = experienceLevelRepository.findById(experience.experienceLevelId())
                            .orElseThrow(() -> new ResourceNotFoundException("Experience level for organization " + experience.organizationId() + " not found"));
                    applicantExperience.setExperienceLevel(experienceLevel);
                }

                if (experience.startDate() != null) {
                    try {
                        LocalDate startDate = LocalDate.parse(experience.startDate());
                        applicantExperience.setStartDate(startDate);
                    } catch (DateTimeParseException e) {
                        throw new InvalidRequestException("Start date for organization " + experience.organizationId() + " is invalid");
                    }
                }

                if (experience.endDate() != null) {
                    try {
                        LocalDate endDate = LocalDate.parse(experience.endDate());
                        if (endDate.isBefore(applicantExperience.getStartDate())) {
                            throw new InvalidRequestException("End date for organization " + experience.organizationId() + " must be after start date");
                        }
                        applicantExperience.setEndDate(endDate);
                    } catch (DateTimeParseException e) {
                        throw new InvalidRequestException("End date for organization " + experience.organizationId() + " is invalid");
                    }
                }

                if (experience.accomplishment() != null && !experience.accomplishment().isBlank()) {
                    applicantExperience.setAccomplishment(experience.accomplishment());
                }

                applicant.getApplicantExperiences().add(applicantExperience);
            });
        }

        if (applicantRegistration.skills() != null && !applicantRegistration.skills().isEmpty()) {
            applicantRegistration.skills().forEach(skill -> {
                if (skill.skill() == null || skill.skill().isBlank()) {
                    throw new InvalidRequestException("Skill name is required");
                }

                ApplicantSkill applicantSkill = new ApplicantSkill(
                        applicant,
                        skill.skill()
                );

                if (skill.skillLevel() != null) {
                    applicantSkill.setSkillLevel(skill.skillLevel());
                }

                applicant.getApplicantSkills().add(applicantSkill);
            });
        }
    }

    public ApplicantDto updateApplicant(Integer applicantId, ApplicantRegistration applicantRegistration) {
        Applicant updateApplicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new ResourceNotFoundException("Applicant not found"));

        if (applicantRegistration.username() != null && !applicantRegistration.username().isBlank()) {
            Boolean usernameIsTaken = accountRepository.existsByUsername(applicantRegistration.username());
            if (usernameIsTaken) {
                throw new InvalidRequestException("Username is taken");
            }
            updateApplicant.getUser().getAccount().setUsername(applicantRegistration.username());
        }

        if (applicantRegistration.password() != null && !applicantRegistration.password().isBlank()) {
            updateApplicant.getUser().getAccount().setPassword(applicantRegistration.password());
        }

        updateUserInfo(updateApplicant, applicantRegistration);
        updateApplicantInfo(updateApplicant, applicantRegistration);

        applicantRepository.save(updateApplicant);
        return ApplicantDto.fromApplicant(updateApplicant);
    }

    private static void updateUserInfo(Applicant applicant, ApplicantRegistration applicantRegistration) {
        if (applicantRegistration.firstName() != null && !applicantRegistration.firstName().isBlank()) {
            applicant.getUser().setFirstName(applicantRegistration.firstName());
        }

        if (applicantRegistration.lastName() != null && !applicantRegistration.lastName().isBlank()) {
            applicant.getUser().setLastName(applicantRegistration.lastName());
        }

        if (applicantRegistration.gender() != null) {
            applicant.getUser().setGender(applicantRegistration.gender());
        }

        if (applicantRegistration.dateOfBirth() != null) {
            applicant.getUser().setDateOfBirth(applicantRegistration.dateOfBirth());
        }

        if (applicantRegistration.profileUrl() != null && !applicantRegistration.profileUrl().isBlank()) {
            applicant.getUser().setProfileUrl(applicantRegistration.profileUrl());
        }

        if (applicantRegistration.email() != null && !applicantRegistration.email().isBlank()) {
            applicant.getUser().setEmail(applicantRegistration.email());
        }

        if (applicantRegistration.phone() != null && !applicantRegistration.phone().isBlank()) {
            applicant.getUser().setPhone(applicantRegistration.phone());
        }

        if (applicantRegistration.website() != null && !applicantRegistration.website().isBlank()) {
            applicant.getUser().setWebsite(applicantRegistration.website());
        }

    }

    public List<JobDto> findJobsByApplicantId(Integer applicantId) {
        // TODO: Return jobs that the applicant with the given ID has applied for
        return null;
    }
}
