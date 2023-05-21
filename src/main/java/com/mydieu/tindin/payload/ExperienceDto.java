package com.mydieu.tindin.payload;

import com.mydieu.tindin.models.ApplicantExperience;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.mydieu.tindin.models.ApplicantExperience} entity
 */
public record ExperienceDto(
        OrganizationDto organization,
        String title,
        String experienceLevel,
        LocalDate startDate,
        LocalDate endDate,
        String accomplishment
) implements Serializable {
    public static ExperienceDto fromApplicantExperience(ApplicantExperience applicantExperience) {
        return new ExperienceDto(
                OrganizationDto.fromOrganization(applicantExperience.getOrganization()),
                applicantExperience.getTitle(),
                applicantExperience.getExperienceLevel().getName(),
                applicantExperience.getStartDate(),
                applicantExperience.getEndDate(),
                applicantExperience.getAccomplishment()
        );
    }
}