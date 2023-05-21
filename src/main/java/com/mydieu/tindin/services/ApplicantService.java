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

        // Add basic information
        if (applicant.openForJob() != null) {
            newApplicant.setOpenForJob(applicant.openForJob());
        }

        if (applicant.title() != null && !applicant.title().isBlank()) {
            newApplicant.setTitle(applicant.title());
        }

        if (applicant.experienceLevelId() != null) {
            ExperienceLevel experienceLevel = experienceLevelRepository.findById(applicant.experienceLevelId())
                    .orElseThrow(() -> new ResourceNotFoundException("Experience level not found"));
            newApplicant.setExperienceLevel(experienceLevel);
        }

        if (applicant.preferLocationId() != null) {
            Location location = locationRepository.findById(applicant.preferLocationId())
                    .orElseThrow(() -> new ResourceNotFoundException("Location not found"));
            newApplicant.setPreferLocation(location);
        }

        if (applicant.preferJobTypeId() != null) {
            JobType jobType = jobTypeRepository.findById(applicant.preferJobTypeId())
                    .orElseThrow(() -> new ResourceNotFoundException("Job type not found"));
            newApplicant.setPreferJobType(jobType);
        }

        if (applicant.preferIndustryId() != null) {
            Industry industry = industryRepository.findById(applicant.preferIndustryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Industry not found"));
            newApplicant.setPreferIndustry(industry);
        }

        if (applicant.preferSalary() != null) {
            newApplicant.setPreferSalary(applicant.preferSalary());
        }

        if (applicant.educations() != null && !applicant.educations().isEmpty()) {
            applicant.educations().forEach(education -> {
                if (education.universityName() == null || education.universityName().isBlank()) {
                    throw new InvalidRequestException("University name is required");
                }

                ApplicantEducation applicantEducation = new ApplicantEducation(
                        newApplicant,
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

                newApplicant.getApplicantEducations().add(applicantEducation);
            });
        }

        if (applicant.experiences() != null && !applicant.experiences().isEmpty()) {
            applicant.experiences().forEach(experience -> {
                if (experience.organizationId() == null) {
                    throw new InvalidRequestException("Organization id is required");
                }

                Organization organization = organizationRepository.findById(experience.organizationId())
                        .orElseThrow(() -> new ResourceNotFoundException("Organization not found"));

                ApplicantExperience applicantExperience = new ApplicantExperience(
                        newApplicant,
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

                newApplicant.getApplicantExperiences().add(applicantExperience);
            });
        }

        if (applicant.skills() != null && !applicant.skills().isEmpty()) {
            applicant.skills().forEach(skill -> {
                if (skill.skill() == null || skill.skill().isBlank()) {
                    throw new InvalidRequestException("Skill name is required");
                }

                ApplicantSkill applicantSkill = new ApplicantSkill(
                        newApplicant,
                        skill.skill()
                );

                if (skill.skillLevel() != null) {
                    applicantSkill.setSkillLevel(skill.skillLevel());
                }

                newApplicant.getApplicantSkills().add(applicantSkill);
            });
        }

        applicantRepository.save(newApplicant);
        return ApplicantDto.fromApplicant(newApplicant);
    }

    public void updateApplicant(Integer applicantId, ApplicantDto applicantDto) {
        // TODO: Update applicant's information with the given ID
    }

    public List<JobDto> findJobsByApplicantId(Integer applicantId) {
        // TODO: Return jobs that the applicant with the given ID has applied for
        return null;
    }
}
