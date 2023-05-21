package com.mydieu.tindin.payload;

import com.mydieu.tindin.models.ApplicantExperience;

import java.io.Serializable;

/**
 * A DTO for the {@link ApplicantExperience} entity
 */
public record ExperienceRegistration(
        Integer organizationId,
        String title,
        Integer experienceLevelId,
        String startDate,
        String endDate,
        String accomplishment
) implements Serializable {
}