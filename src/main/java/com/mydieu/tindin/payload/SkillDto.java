package com.mydieu.tindin.payload;

import java.io.Serializable;

/**
 * A DTO for the {@link com.mydieu.tindin.models.ApplicantSkill} entity
 */
public record SkillDto(
        String skill,
        Integer skillLevel
) implements Serializable {
}