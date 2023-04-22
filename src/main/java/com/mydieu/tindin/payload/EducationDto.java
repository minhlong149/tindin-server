package com.mydieu.tindin.payload;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link com.mydieu.tindin.models.EducationDetail} entity
 */
public record EducationDto(
        String degreeName,
        String majorName,
        OrganizationDto organization,
        LocationDto location,
        Date startDate,
        Date completionDate,
        String gpa
) implements Serializable {
}