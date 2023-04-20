package com.mydieu.tindin.models;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "education_detail")
public class EducationDetail {
    @EmbeddedId
    private EducationDetailId id;

    @MapsId("applicantId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "applicant_id", nullable = false)
    private Applicant applicant;

    @MapsId("degree")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "degree", nullable = false)
    private Degree degree;

    @MapsId("major")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "major", nullable = false)
    private Major major;

    @MapsId("organization")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "organization", nullable = false)
    private Organization organization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location")
    private Location location;

    @Column(name = "start_date")
    private Instant startDate;

    @Column(name = "completion_date")
    private Instant completionDate;

    @Column(name = "gpa")
    private Integer gpa;

    public EducationDetailId getId() {
        return id;
    }

    public void setId(EducationDetailId id) {
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

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Instant completionDate) {
        this.completionDate = completionDate;
    }

    public Integer getGpa() {
        return gpa;
    }

    public void setGpa(Integer gpa) {
        this.gpa = gpa;
    }

}