package com.mydieu.tindin.specification;

import com.mydieu.tindin.models.JobPost;
import com.mydieu.tindin.models.JobType;
import org.springframework.data.jpa.domain.Specification;

public final class JobPostSpecification {
    public static Specification<JobPost> jobTitleContains(String jobTitle) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), "%"+ jobTitle + "%");
    }

    public static Specification<JobPost> jobTypeLike(String jobType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.join("jobType").get("name"),jobType);
    }

    public static Specification<JobPost> jobLocationLike(String jobLocation) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.join("recruiter").join("organization").join("location").get("city"),jobLocation);
    }
    public static Specification<JobPost> jobOrganizationNameLike(String organizationName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.join("recruiter").join("organization").get("name"),"%" + organizationName + "%" );
    }
    public static Specification<JobPost> jobOrganizationIndustryLike(String organizationIndustry) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.join("recruiter").join("organization").join("industry").get("name"),"%" + organizationIndustry + "%" );
    }
    public static Specification<JobPost> jobSkillIs(String skills) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.join("jobRequireSkills").get("skill"),"%" + skills + "%" );
    }

    public static Specification<JobPost> jobExperienceLevelIs(String experienceLevel) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.join("jobRequireExperienceLevels").get("experienceLevel"),"%" + experienceLevel + "%" );
    }
    public static Specification<JobPost> jobMinimumSalaryIs(Integer minimumSalary) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("salary"), minimumSalary );
    }
}
