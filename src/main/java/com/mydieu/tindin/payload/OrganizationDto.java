package com.mydieu.tindin.payload;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link com.mydieu.tindin.models.Organization} entity
 */
public record OrganizationDto(
        String name,
        String description,
        String industry,
        String email,
        String phone,
        String website,
        Set<LocationDto> locations
) implements Serializable {
}