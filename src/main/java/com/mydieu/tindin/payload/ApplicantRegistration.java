package com.mydieu.tindin.payload;

import com.mydieu.tindin.models.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * A DTO for the {@link com.mydieu.tindin.models.Recruiter} entity
 */
public record ApplicantRegistration(
        String username,
        String password,
        String firstName,
        String lastName,
        Gender gender,
        LocalDate dateOfBirth,
        String profileUrl,
        String phone,
        String email,
        String website,
        Boolean openForJob,
        String title,
        Integer experienceLevelId,
        Integer preferLocationId,
        Integer preferJobTypeId,
        Integer preferIndustryId,
        Integer preferSalary,
        Set<EducationRegistration> educations,
        Set<ExperienceRegistration> experiences,
        Set<SkillDto> skills
) implements Serializable {
}