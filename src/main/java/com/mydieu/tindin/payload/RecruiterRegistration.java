package com.mydieu.tindin.payload;

import java.io.Serializable;

/**
 * A DTO for the {@link com.mydieu.tindin.models.Recruiter} entity
 */
public record RecruiterRegistration(
        String username,
        String password,
        String firstName,
        Integer organizationId
) implements Serializable {
}