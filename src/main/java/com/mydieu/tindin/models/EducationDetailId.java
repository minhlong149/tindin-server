package com.mydieu.tindin.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EducationDetailId implements Serializable {
    private static final long serialVersionUID = -9091928763669604065L;
    @Column(name = "applicant_id", nullable = false)
    private Integer applicantId;

    @Column(name = "degree", nullable = false)
    private Integer degree;

    @Column(name = "major", nullable = false)
    private Integer major;

    @Column(name = "organization", nullable = false)
    private Integer organization;

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
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
        EducationDetailId entity = (EducationDetailId) o;
        return Objects.equals(this.major, entity.major) &&
                Objects.equals(this.organization, entity.organization) &&
                Objects.equals(this.degree, entity.degree) &&
                Objects.equals(this.applicantId, entity.applicantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(major, organization, degree, applicantId);
    }

}