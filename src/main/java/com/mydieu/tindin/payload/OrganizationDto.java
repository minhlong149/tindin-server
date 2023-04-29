package com.mydieu.tindin.payload;

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
}