package com.mydieu.tindin.payload;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link com.mydieu.tindin.models.JobActivity} entity
 */
public record JobActivityDto(
        JobDto job,
        ApplicantDto applicant,
        UserDto userApply,
        Date applyDate
) implements Serializable {
}