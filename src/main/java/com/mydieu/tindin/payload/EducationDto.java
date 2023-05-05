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
                applicantEducation.getDegree().getName(),
                applicantEducation.getMajor().getName(),
                applicantEducation.getLocation().getCity(),
                applicantEducation.getStartDate(),
                applicantEducation.getCompletionDate(),
                applicantEducation.getGpa()
        );
    }
}