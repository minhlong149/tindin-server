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

    @Column(name = "open_for_job")
    private Boolean openForJob;

    @Column(name = "title", length = Integer.MAX_VALUE)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "experience_level_id")
    private ExperienceLevel experienceLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perfer_location_id")
    private Location perferLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perfer_job_type_id")
    private JobType perferJobType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perfer_industry_id")
    private Industry perferIndustry;

    @Column(name = "perfer_salary")
    private Integer perferSalary;

    @OneToMany(mappedBy = "applicant")
    private Set<ApplicantEducation> applicantEducations = new LinkedHashSet<>();

    @OneToMany(mappedBy = "applicant")
    private Set<ApplicantSkill> applicantSkills = new LinkedHashSet<>();

    @OneToMany(mappedBy = "applicant")
    private Set<ApplicantExperience> applicantExperiences = new LinkedHashSet<>();

    @OneToMany(mappedBy = "applicant")
    private Set<JobPostActivity> jobPostActivities = new LinkedHashSet<>();

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

    public Location getPerferLocation() {
        return perferLocation;
    }

    public void setPerferLocation(Location perferLocation) {
        this.perferLocation = perferLocation;
    }

    public JobType getPerferJobType() {
        return perferJobType;
    }

    public void setPerferJobType(JobType perferJobType) {
        this.perferJobType = perferJobType;
    }

    public Industry getPerferIndustry() {
        return perferIndustry;
    }

    public void setPerferIndustry(Industry perferIndustry) {
        this.perferIndustry = perferIndustry;
    }

    public Integer getPerferSalary() {
        return perferSalary;
    }

    public void setPerferSalary(Integer perferSalary) {
        this.perferSalary = perferSalary;
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