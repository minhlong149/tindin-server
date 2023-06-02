package com.mydieu.tindin.payload;

import com.mydieu.tindin.models.JobPost;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A DTO for the {@link com.mydieu.tindin.models.JobPost} entity
 */
public record JobDto(
        Integer id,
        Integer recruiter_id,
        String title,
        String description,
        Integer jobType_id,
        Integer salary,
        Instant createdDate,
        Instant closingDate,
        Boolean isOpen,
        Set<String> requireMajors,
        Set<String> requireDegrees,
        Set<String> requireExperienceLevels,
        Set<SkillDto> requireSkills
) implements Serializable {
    public static JobDto fromJobPost(JobPost jobPost) {
        return new JobDto(
                jobPost.getId(),
                jobPost.getRecruiter_id(),
                jobPost.getTitle(),
                jobPost.getDescription(),
                jobPost.getJobType_id(),
                jobPost.getSalary(),
                jobPost.getCreatedDate(),
                jobPost.getClosingDate(),
                jobPost.getIsOpen(),
                jobPost.getJobRequireMajors()
                        .stream().map(jobRequireMajor -> jobRequireMajor.getMajor().getName())
                        .collect(Collectors.toSet()),
                jobPost.getJobRequireDegrees()
                        .stream().map(jobRequireDegree -> jobRequireDegree.getDegree().getName())
                        .collect(Collectors.toSet()),
                jobPost.getJobRequireExperienceLevels()
                        .stream().map(jobRequireExperienceLevel -> jobRequireExperienceLevel.getExperienceLevel().getName())
                        .collect(Collectors.toSet()),
                jobPost.getJobRequireSkills()
                        .stream().map(SkillDto::fromJobRequireSkill)
                        .collect(Collectors.toSet())
        );
    }
}