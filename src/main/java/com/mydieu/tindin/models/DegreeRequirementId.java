package com.mydieu.tindin.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DegreeRequirementId implements Serializable {
    private static final long serialVersionUID = -6719292017232594724L;
    @Column(name = "job_id", nullable = false)
    private Integer jobId;

    @Column(name = "degree", nullable = false)
    private Integer degree;

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DegreeRequirementId entity = (DegreeRequirementId) o;
        return Objects.equals(this.jobId, entity.jobId) &&
                Objects.equals(this.degree, entity.degree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, degree);
    }

}