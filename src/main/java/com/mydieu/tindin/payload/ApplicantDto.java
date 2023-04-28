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
        String perferLocation,
        String perferJobType,
        String perferIndustry,
        Integer perferSalary,
        Set<EducationDto> educations,
        Set<SkillDto> skills,
        Set<ExperienceDto> experiences
) implements Serializable {
}