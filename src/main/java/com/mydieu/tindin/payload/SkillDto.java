package com.mydieu.tindin.payload;

import com.mydieu.tindin.models.JobRequireSkill;

import java.io.Serializable;

/**
 * A DTO for the {@link com.mydieu.tindin.models.ApplicantSkill} entity
 */
public record SkillDto(
        String skill,
        Integer skillLevel
) implements Serializable {
    public static SkillDto fromJobRequireSkill(JobRequireSkill jobRequireSkills) {
        return new SkillDto(
                jobRequireSkills.getSkill(),
                jobRequireSkills.getSkillLevel()
        );
    }
}