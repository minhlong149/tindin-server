package com.mydieu.tindin.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MajorRequirementId implements Serializable {
    private static final long serialVersionUID = 7731904639310841992L;
    @Column(name = "job_id", nullable = false)
    private Integer jobId;

    @Column(name = "major", nullable = false)
    private Integer major;

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MajorRequirementId entity = (MajorRequirementId) o;
        return Objects.equals(this.jobId, entity.jobId) &&
                Objects.equals(this.major, entity.major);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, major);
    }

}