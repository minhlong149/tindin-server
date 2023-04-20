package com.mydieu.tindin.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SkillRequirementId implements Serializable {
    private static final long serialVersionUID = 8127437146767808060L;
    @Column(name = "job_id", nullable = false)
    private Integer jobId;

    @Column(name = "skill", nullable = false)
    private Integer skill;

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getSkill() {
        return skill;
    }

    public void setSkill(Integer skill) {
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SkillRequirementId entity = (SkillRequirementId) o;
        return Objects.equals(this.jobId, entity.jobId) &&
                Objects.equals(this.skill, entity.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, skill);
    }

}