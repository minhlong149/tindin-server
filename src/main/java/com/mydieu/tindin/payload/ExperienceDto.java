package com.mydieu.tindin.payload;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link com.mydieu.tindin.models.ExperienceDetail} entity
 */
public record ExperienceDto(
        String jobTitle,
        String experienceLevel,
        OrganizationDto organization,
        LocationDto location,
        Date startDate,
        Date endDate,
        String description
) implements Serializable {
}