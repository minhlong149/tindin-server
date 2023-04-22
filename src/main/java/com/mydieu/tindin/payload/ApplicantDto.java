package com.mydieu.tindin.payload;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link com.mydieu.tindin.models.Applicant} entity
 */
public record ApplicantDto(
        UserDto user,
        LocationDto location,
        Boolean openForJob,
        String jobTitle,
        String experienceLevel,
        String jobType,
        String industry,
        Integer salary,
        Set<SkillDto> skills,
        Set<EducationDto> educations,
        Set<ExperienceDto> experiences,
        Set<JobDto> savedJobs
) implements Serializable {
}