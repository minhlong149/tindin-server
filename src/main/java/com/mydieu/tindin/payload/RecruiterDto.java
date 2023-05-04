package com.mydieu.tindin.payload;

import com.mydieu.tindin.models.Recruiter;

import java.io.Serializable;

/**
 * A DTO for the {@link com.mydieu.tindin.models.Recruiter} entity
 */
public record RecruiterDto(
        UserDto user,
        OrganizationDto organization
) implements Serializable {
    public static RecruiterDto fromRecruiter(Recruiter recruiter) {
        return new RecruiterDto(
                UserDto.fromUser(recruiter.getUser()),
                OrganizationDto.fromOrganization(recruiter.getOrganization())
        );
    }
}