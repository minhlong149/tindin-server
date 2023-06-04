package com.mydieu.tindin.payload;

import com.mydieu.tindin.models.ApplicantEducation;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link ApplicantEducation} entity
 */
public record EducationRegistration(
        String universityName,
        Integer degreeId,
        Integer majorId,
        Integer locationId,
        String startDate,
        String completionDate,
        BigDecimal gpa
) implements Serializable {
}