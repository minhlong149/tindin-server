package com.mydieu.tindin.models;

import jakarta.persistence.*;

import java.util.Date;
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
    private Recruiter recruiter;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_title", nullable = false)
    private JobTitle jobTitle;

    @Column(name = "job_description", nullable = false, length = Integer.MAX_VALUE)
    private String jobDescription;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_type", nullable = false)
    private JobType jobType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "organization", nullable = false)
    private Organization organization;

    @Column(name = "salary", nullable = false)
    private Integer salary;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "contact", nullable = false)
    private Contact contact;

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(name = "closing_date")
    private Date closingDate;

    @Column(name = "is_open")
    private Boolean isOpen;

    @OneToMany(mappedBy = "job")
    private Set<JobActivity> jobActivities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "job")
    private Set<SkillRequirement> skillRequirements = new LinkedHashSet<>();

    @OneToMany(mappedBy = "job")
    private Set<JobLocation> jobLocations = new LinkedHashSet<>();

    @OneToMany(mappedBy = "job")
    private Set<MajorRequirement> majorRequirements = new LinkedHashSet<>();

    @OneToMany(mappedBy = "job")
    private Set<ExperienceRequirement> experienceRequirements = new LinkedHashSet<>();

    @OneToMany(mappedBy = "job")
    private Set<DegreeRequirement> degreeRequirements = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Recruiter getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    public Set<JobActivity> getJobActivities() {
        return jobActivities;
    }

    public void setJobActivities(Set<JobActivity> jobActivities) {
        this.jobActivities = jobActivities;
    }

    public Set<SkillRequirement> getSkillRequirements() {
        return skillRequirements;
    }

    public void setSkillRequirements(Set<SkillRequirement> skillRequirements) {
        this.skillRequirements = skillRequirements;
    }

    public Set<JobLocation> getJobLocations() {
        return jobLocations;
    }

    public void setJobLocations(Set<JobLocation> jobLocations) {
        this.jobLocations = jobLocations;
    }

    public Set<MajorRequirement> getMajorRequirements() {
        return majorRequirements;
    }

    public void setMajorRequirements(Set<MajorRequirement> majorRequirements) {
        this.majorRequirements = majorRequirements;
    }

    public Set<ExperienceRequirement> getExperienceRequirements() {
        return experienceRequirements;
    }

    public void setExperienceRequirements(Set<ExperienceRequirement> experienceRequirements) {
        this.experienceRequirements = experienceRequirements;
    }

    public Set<DegreeRequirement> getDegreeRequirements() {
        return degreeRequirements;
    }

    public void setDegreeRequirements(Set<DegreeRequirement> degreeRequirements) {
        this.degreeRequirements = degreeRequirements;
    }

}