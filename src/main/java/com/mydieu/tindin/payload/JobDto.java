package com.mydieu.tindin.payload;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * A DTO for the {@link com.mydieu.tindin.models.JobPost} entity
 */
public record JobDto(
        Integer id,
        RecruiterDto recruiter,
        String jobTitle,
        String jobDescription,
        String jobType,
        OrganizationDto organization,
        Integer salary,
        String email,
        String phone,
        String website,
        Date createdDate,
        Date closingDate,
        Boolean isOpen,
        Set<LocationDto> jobLocations,
        Set<SkillDto> skillsRequirement,
        Set<String> experienceLevelsRequirement,
        Set<String> majorsRequirement,
        Set<String> degreesRequirement
) implements Serializable {
}