package com.mydieu.tindin.payload;

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
}