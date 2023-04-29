package com.mydieu.tindin.payload;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.mydieu.tindin.models.ApplicantExperience} entity
 */
public record ExperienceDto(
        OrganizationDto organization,
        String title,
        String experienceLeve,
        LocalDate startDate,
        LocalDate endDate,
        String accomplishment
) implements Serializable {
}