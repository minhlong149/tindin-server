package com.mydieu.tindin.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "education_detail")
public class EducationDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "degree_id")
    private Degree degree;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_id")
    private Major major;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location")
    private Location location;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "completion_date")
    private Date completionDate;

    @Column(name = "gpa")
    private Integer gpa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public Integer getGpa() {
        return gpa;
    }

    public void setGpa(Integer gpa) {
        this.gpa = gpa;
    }

}