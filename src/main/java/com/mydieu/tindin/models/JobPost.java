package com.mydieu.tindin.models;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "job_post")
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recruiter_id", nullable = false)
    private Integer recruiter_id;
    private Recruiter recruiter;

    @Column(name = "title", nullable = false, length = Integer.MAX_VALUE)
    private String title;

    @Column(name = "description", nullable = false, length = Integer.MAX_VALUE)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_type_id", nullable = false)
    private Integer jobType_id;
    private JobType jobType;

    @Column(name = "salary", nullable = false)
    private Integer salary;

    @Column(name = "created_date")
    private Instant createdDate;

    @Column(name = "closing_date")
    private Instant closingDate;

    @Column(name = "is_open")
    private Boolean isOpen;

    @OneToMany(mappedBy = "job")
    private Set<JobRequireMajor> jobRequireMajors = new LinkedHashSet<>();

    @OneToMany(mappedBy = "job")
    private Set<JobRequireSkill> jobRequireSkills = new LinkedHashSet<>();

    @OneToMany(mappedBy = "job")
    private Set<JobRequireExperienceLevel> jobRequireExperienceLevels = new LinkedHashSet<>();

    @OneToMany(mappedBy = "job")
    private Set<JobPostActivity> jobPostActivities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "job")
    private Set<JobRequireDegree> jobRequireDegrees = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecruiter_id() {
        return recruiter_id;
    }

    public void setRecruiter_id(Integer recruiter_id) {
        this.recruiter_id = recruiter_id;
    }

    public Recruiter getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getJobType_id() {
        return jobType_id;
    }

    public void setJobType_id(Integer jobType_id) {
        this.jobType_id = jobType_id;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Instant closingDate) {
        this.closingDate = closingDate;
    }

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    public Set<JobRequireMajor> getJobRequireMajors() {
        return jobRequireMajors;
    }

    public void setJobRequireMajors(Set<JobRequireMajor> jobRequireMajors) {
        this.jobRequireMajors = jobRequireMajors;
    }

    public Set<JobRequireSkill> getJobRequireSkills() {
        return jobRequireSkills;
    }

    public void setJobRequireSkills(Set<JobRequireSkill> jobRequireSkills) {
        this.jobRequireSkills = jobRequireSkills;
    }

    public Set<JobRequireExperienceLevel> getJobRequireExperienceLevels() {
        return jobRequireExperienceLevels;
    }

    public void setJobRequireExperienceLevels(Set<JobRequireExperienceLevel> jobRequireExperienceLevels) {
        this.jobRequireExperienceLevels = jobRequireExperienceLevels;
    }

    public Set<JobPostActivity> getJobPostActivities() {
        return jobPostActivities;
    }

    public void setJobPostActivities(Set<JobPostActivity> jobPostActivities) {
        this.jobPostActivities = jobPostActivities;
    }

    public Set<JobRequireDegree> getJobRequireDegrees() {
        return jobRequireDegrees;
    }

    public void setJobRequireDegrees(Set<JobRequireDegree> jobRequireDegrees) {
        this.jobRequireDegrees = jobRequireDegrees;
    }

}