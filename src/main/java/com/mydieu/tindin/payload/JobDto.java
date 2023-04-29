package com.mydieu.tindin.payload;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

/**
 * A DTO for the {@link com.mydieu.tindin.models.JobPost} entity
 */
public record JobDto(
        Integer id,
        RecruiterDto recruiter,
        String title,
        String description,
        String jobType,
        Integer salary,
        Instant createdDate,
        Instant closingDate,
        Boolean isOpen,
        Set<String> requireMajors,
        Set<String> requireDegrees,
        Set<String> requireExperienceLevels,
        Set<SkillDto> requireSkills
) implements Serializable {
}