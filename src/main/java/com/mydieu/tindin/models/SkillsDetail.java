package com.mydieu.tindin.models;

import jakarta.persistence.*;

@Entity
@Table(name = "skills_detail")
public class SkillsDetail {
    @EmbeddedId
    private SkillsDetailId id;

    @MapsId("applicantId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "applicant_id", nullable = false)
    private Applicant applicant;

    @MapsId("skill")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "skill", nullable = false)
    private Skillset skill;

    @Column(name = "skill_level")
    private Integer skillLevel;

    public SkillsDetailId getId() {
        return id;
    }

    public void setId(SkillsDetailId id) {
        this.id = id;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Skillset getSkill() {
        return skill;
    }

    public void setSkill(Skillset skill) {
        this.skill = skill;
    }

    public Integer getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(Integer skillLevel) {
        this.skillLevel = skillLevel;
    }

}