package com.mydieu.tindin.payload;

import com.mydieu.tindin.models.JobPost;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link JobPost} entity
 */
public record JobSmallDto(
        Integer id,
        OrganizationDto organizationDto,
        String title,
        String description,
        String jobType,
        Integer salary,
        Instant createdDate,
        Instant closingDate,
        Boolean isOpen
) implements Serializable {
    public static JobSmallDto fromJobPost(JobPost jobPost) {
        return new JobSmallDto(
                jobPost.getId(),
                OrganizationDto.fromOrganization(jobPost.getRecruiter().getOrganization()),
                jobPost.getTitle(),
                jobPost.getDescription(),
                jobPost.getJobType().getName(),
                jobPost.getSalary(),
                jobPost.getCreatedDate(),
                jobPost.getClosingDate(),
                jobPost.getIsOpen()
        );
    }
}