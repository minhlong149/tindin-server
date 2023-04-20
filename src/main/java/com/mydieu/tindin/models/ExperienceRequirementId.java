package com.mydieu.tindin.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ExperienceRequirementId implements Serializable {
    private static final long serialVersionUID = -8555885137812101530L;
    @Column(name = "job_id", nullable = false)
    private Integer jobId;

    @Column(name = "experience_level", nullable = false)
    private Integer experienceLevel;

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(Integer experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ExperienceRequirementId entity = (ExperienceRequirementId) o;
        return Objects.equals(this.jobId, entity.jobId) &&
                Objects.equals(this.experienceLevel, entity.experienceLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, experienceLevel);
    }

}