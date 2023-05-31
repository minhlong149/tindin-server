package com.mydieu.tindin.payload;

import com.mydieu.tindin.models.Organization;

import java.io.Serializable;

/**
 * A DTO for the {@link com.mydieu.tindin.models.Organization} entity
 */
public record OrganizationDto(
        Integer id,
        String name,
        String description,
        String industry,
        String location,
        String email,
        String phone,
        String website
) implements Serializable {
    public static OrganizationDto fromOrganization(Organization organization) {
        return new OrganizationDto(
                organization.getId(),
                organization.getName(),
                organization.getDescription(),
                organization.getIndustry().getName(),
                organization.getLocation().getCity(),
                organization.getEmail(),
                organization.getPhone(),
                organization.getWebsite()
        );
    }

}