package com.mydieu.tindin.payload;

import com.mydieu.tindin.models.ApplicantEducation;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.mydieu.tindin.models.ApplicantEducation} entity
 */
public record EducationDto(
        String universityName,
        String degree,
        String major,
        String location,
        LocalDate startDate,
        LocalDate completionDate,
        BigDecimal gpa
) implements Serializable {
    public static EducationDto fromApplicantEducation(ApplicantEducation applicantEducation) {
        return new EducationDto(
                applicantEducation.getUniversityName(),
                applicantEducation.getDegree() != null ? applicantEducation.getDegree().getName() : null,
                applicantEducation.getMajor() != null ? applicantEducation.getMajor().getName() : null,
                applicantEducation.getLocation() != null ? applicantEducation.getLocation().getCity() : null,
                applicantEducation.getStartDate(),
                applicantEducation.getCompletionDate(),
                applicantEducation.getGpa()
        );
    }
}