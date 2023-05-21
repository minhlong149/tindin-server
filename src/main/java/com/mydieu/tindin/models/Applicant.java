package com.mydieu.tindin.models;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "applicant")
public class Applicant {
    @Id
    @Column(name = "account_id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private User user;

    @Column(name = "open_for_job", columnDefinition = "boolean default true")
    private Boolean openForJob;

    @Column(name = "title", length = Integer.MAX_VALUE)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "experience_level_id")
    private ExperienceLevel experienceLevel;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "prefer_location_id")
    private Location preferLocation;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "prefer_job_type_id")
    private JobType preferJobType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "prefer_industry_id")
    private Industry preferIndustry;

    @Column(name = "prefer_salary")
    private Integer preferSalary;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL)
    private Set<ApplicantEducation> applicantEducations = new LinkedHashSet<>();

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL)
    private Set<ApplicantSkill> applicantSkills = new LinkedHashSet<>();

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL)
    private Set<ApplicantExperience> applicantExperiences = new LinkedHashSet<>();

    @OneToMany(mappedBy = "applicant")
    private Set<JobPostActivity> jobPostActivities = new LinkedHashSet<>();

    public Applicant() {
    }

    public Applicant(User user) {
        this.id = user.getId();
        this.user = user;
        this.openForJob = true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getOpenForJob() {
        return openForJob;
    }

    public void setOpenForJob(Boolean openForJob) {
        this.openForJob = openForJob;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ExperienceLevel getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(ExperienceLevel experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public Location getPreferLocation() {
        return preferLocation;
    }

    public void setPreferLocation(Location preferLocation) {
        this.preferLocation = preferLocation;
    }

    public JobType getPreferJobType() {
        return preferJobType;
    }

    public void setPreferJobType(JobType preferJobType) {
        this.preferJobType = preferJobType;
    }

    public Industry getPreferIndustry() {
        return preferIndustry;
    }

    public void setPreferIndustry(Industry preferIndustry) {
        this.preferIndustry = preferIndustry;
    }

    public Integer getPreferSalary() {
        return preferSalary;
    }

    public void setPreferSalary(Integer preferSalary) {
        this.preferSalary = preferSalary;
    }

    public Set<ApplicantEducation> getApplicantEducations() {
        return applicantEducations;
    }

    public void setApplicantEducations(Set<ApplicantEducation> applicantEducations) {
        this.applicantEducations = applicantEducations;
    }

    public Set<ApplicantSkill> getApplicantSkills() {
        return applicantSkills;
    }

    public void setApplicantSkills(Set<ApplicantSkill> applicantSkills) {
        this.applicantSkills = applicantSkills;
    }

    public Set<ApplicantExperience> getApplicantExperiences() {
        return applicantExperiences;
    }

    public void setApplicantExperiences(Set<ApplicantExperience> applicantExperiences) {
        this.applicantExperiences = applicantExperiences;
    }

    public Set<JobPostActivity> getJobPostActivities() {
        return jobPostActivities;
    }

    public void setJobPostActivities(Set<JobPostActivity> jobPostActivities) {
        this.jobPostActivities = jobPostActivities;
    }

}