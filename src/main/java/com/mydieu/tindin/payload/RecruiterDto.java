package com.mydieu.tindin.payload;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link com.mydieu.tindin.models.Recruiter} entity
 */
public record RecruiterDto(
        UserDto user,
        OrganizationDto organization,
        Set<JobDto> jobPosts
) implements Serializable {
}