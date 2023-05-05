package com.mydieu.tindin.payload;

import com.mydieu.tindin.models.Applicant;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A DTO for the {@link com.mydieu.tindin.models.Applicant} entity
 */
public record ApplicantDto(
        UserDto user,
        Boolean openForJob,
        String title,
        String experienceLevel,
        String preferLocation,
        String preferJobType,
        String preferIndustry,
        Integer preferSalary,
        Set<EducationDto> educations,
        Set<SkillDto> skills,
        Set<ExperienceDto> experiences
) implements Serializable {
    public static ApplicantDto fromApplicant(Applicant applicant) {
        return new ApplicantDto(
                UserDto.fromUser(applicant.getUser()),
                applicant.getOpenForJob(),
                applicant.getTitle(),
                applicant.getExperienceLevel().getName(),
                applicant.getPreferLocation().getCity(),
                applicant.getPreferJobType().getName(),
                applicant.getPreferIndustry().getName(),
                applicant.getPreferSalary(),
                applicant.getApplicantEducations()
                        .stream().map(EducationDto::fromApplicantEducation)
                        .collect(Collectors.toSet()),
                applicant.getApplicantSkills()
                        .stream().map(SkillDto::fromApplicantSkill)
                        .collect(Collectors.toSet()),
                applicant.getApplicantExperiences()
                        .stream().map(ExperienceDto::fromApplicantExperience)
                        .collect(Collectors.toSet())
        );
    }
}