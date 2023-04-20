package com.mydieu.tindin.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SkillsDetailId implements Serializable {
    private static final long serialVersionUID = 5843026338093563337L;
    @Column(name = "applicant_id", nullable = false)
    private Integer applicantId;

    @Column(name = "skill", nullable = false)
    private Integer skill;

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
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
        SkillsDetailId entity = (SkillsDetailId) o;
        return Objects.equals(this.skill, entity.skill) &&
                Objects.equals(this.applicantId, entity.applicantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skill, applicantId);
    }

}