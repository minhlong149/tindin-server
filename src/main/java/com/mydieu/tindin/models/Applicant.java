package com.mydieu.tindin.models;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "applicant")
public class Applicant {
    @Id
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "open_for_job")
    private Integer openForJob;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_title")
    private JobTitle jobTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "experience_level")
    private ExperienceLevel experienceLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location")
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_type_prefer")
    private JobType jobTypePrefer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "industry")
    private Industry industry;

    @Column(name = "salary_prefer")
    private Integer salaryPrefer;

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

    public Integer getOpenForJob() {
        return openForJob;
    }

    public void setOpenForJob(Integer openForJob) {
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

    public JobType getJobTypePrefer() {
        return jobTypePrefer;
    }

    public void setJobTypePrefer(JobType jobTypePrefer) {
        this.jobTypePrefer = jobTypePrefer;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public Integer getSalaryPrefer() {
        return salaryPrefer;
    }

    public void setSalaryPrefer(Integer salaryPrefer) {
        this.salaryPrefer = salaryPrefer;
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