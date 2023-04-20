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
    private Integer isOpen;

    @OneToMany(mappedBy = "jobPost")
    private Set<SkillRequirement> skillRequirements = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "job_location",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "location"))
    private Set<Location> locations = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "major_requirement",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "major"))
    private Set<Major> majors = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "experience_requirement",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "experience_level"))
    private Set<ExperienceLevel> experienceLevels = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "degree_requirement",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "degree"))
    private Set<Degree> degrees = new LinkedHashSet<>();

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

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    public Set<SkillRequirement> getSkillRequirements() {
        return skillRequirements;
    }

    public void setSkillRequirements(Set<SkillRequirement> skillRequirements) {
        this.skillRequirements = skillRequirements;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

    public Set<Major> getMajors() {
        return majors;
    }

    public void setMajors(Set<Major> majors) {
        this.majors = majors;
    }

    public Set<ExperienceLevel> getExperienceLevels() {
        return experienceLevels;
    }

    public void setExperienceLevels(Set<ExperienceLevel> experienceLevels) {
        this.experienceLevels = experienceLevels;
    }

    public Set<Degree> getDegrees() {
        return degrees;
    }

    public void setDegrees(Set<Degree> degrees) {
        this.degrees = degrees;
    }

}