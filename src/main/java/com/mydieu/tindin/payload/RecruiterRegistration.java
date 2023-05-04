package com.mydieu.tindin.payload;

import com.mydieu.tindin.models.Gender;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.mydieu.tindin.models.Recruiter} entity
 */
public record RecruiterRegistration(
        String username,
        String password,
        String firstName,
        String lastName,
        Gender gender,
        LocalDate dateOfBirth,
        String profileUrl,
        String phone,
        String email,
        String website,
        Integer organizationId
) implements Serializable {
}