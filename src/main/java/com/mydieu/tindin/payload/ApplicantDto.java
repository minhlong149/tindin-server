package com.mydieu.tindin.payload;

import java.io.Serializable;
import java.util.Set;

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
}