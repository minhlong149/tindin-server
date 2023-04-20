package com.mydieu.tindin.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ExperienceDetailId implements Serializable {
    private static final long serialVersionUID = -6810602334021223026L;
    @Column(name = "applicant_id", nullable = false)
    private Integer applicantId;

    @Column(name = "job_title", nullable = false)
    private Integer jobTitle;

    @Column(name = "experience_level", nullable = false)
    private Integer experienceLevel;

    @Column(name = "organization", nullable = false)
    private Integer organization;

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public Integer getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(Integer jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(Integer experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public Integer getOrganization() {
        return organization;
    }

    public void setOrganization(Integer organization) {
        this.organization = organization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ExperienceDetailId entity = (ExperienceDetailId) o;
        return Objects.equals(this.experienceLevel, entity.experienceLevel) &&
                Objects.equals(this.jobTitle, entity.jobTitle) &&
                Objects.equals(this.organization, entity.organization) &&
                Objects.equals(this.applicantId, entity.applicantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(experienceLevel, jobTitle, organization, applicantId);
    }

}