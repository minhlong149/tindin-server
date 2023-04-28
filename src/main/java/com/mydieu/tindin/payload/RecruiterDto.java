package com.mydieu.tindin.payload;

import java.io.Serializable;

/**
 * A DTO for the {@link com.mydieu.tindin.models.Recruiter} entity
 */
public record RecruiterDto(
        UserDto user,
        OrganizationDto organization
) implements Serializable {
}