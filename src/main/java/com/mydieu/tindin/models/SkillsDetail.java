package com.mydieu.tindin.models;

import jakarta.persistence.*;

@Entity
@Table(name = "skills_detail")
public class SkillsDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Column(name = "skill_level")
    private Integer skillLevel;

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

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Integer getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(Integer skillLevel) {
        this.skillLevel = skillLevel;
    }

}