package com.mydieu.tindin.models;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "applicant")
public class Applicant {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private User user;

    @Column(name = "open_for_job")
    private Boolean openForJob;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_title_id")
    private JobTitle jobTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "experience_level_id")
    private ExperienceLevel experienceLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_type_id")
    private JobType jobType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "industry_id")
    private Industry industry;

    @Column(name = "salary")
    private Integer salary;

    @OneToMany(mappedBy = "applicant")
    private Set<JobActivity> jobActivities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "applicant")
    private Set<SkillsDetail> skillsDetails = new LinkedHashSet<>();

    @OneToMany(mappedBy = "applicant")
    private Set<EducationDetail> educationDetails = new LinkedHashSet<>();

    @OneToMany(mappedBy = "applicant")
    private Set<ExperienceDetail> experienceDetails = new LinkedHashSet<>();

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

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public ExperienceLevel getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(ExperienceLevel experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Set<JobActivity> getJobActivities() {
        return jobActivities;
    }

    public void setJobActivities(Set<JobActivity> jobActivities) {
        this.jobActivities = jobActivities;
    }

    public Set<SkillsDetail> getSkillsDetails() {
        return skillsDetails;
    }

    public void setSkillsDetails(Set<SkillsDetail> skillsDetails) {
        this.skillsDetails = skillsDetails;
    }

    public Set<EducationDetail> getEducationDetails() {
        return educationDetails;
    }

    public void setEducationDetails(Set<EducationDetail> educationDetails) {
        this.educationDetails = educationDetails;
    }

    public Set<ExperienceDetail> getExperienceDetails() {
        return experienceDetails;
    }

    public void setExperienceDetails(Set<ExperienceDetail> experienceDetails) {
        this.experienceDetails = experienceDetails;
    }

}