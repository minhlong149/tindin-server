package com.mydieu.tindin.models;

import jakarta.persistence.*;

@Entity
@Table(name = "skill_requirement")
public class SkillRequirement {
    @EmbeddedId
    private SkillRequirementId id;

    @MapsId("jobId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private JobPost job;

    @MapsId("skill")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "skill", nullable = false)
    private Skillset skill;

    @Column(name = "skill_level")
    private Integer skillLevel;

    public SkillRequirementId getId() {
        return id;
    }

    public void setId(SkillRequirementId id) {
        this.id = id;
    }

    public JobPost getJob() {
        return job;
    }

    public void setJob(JobPost job) {
        this.job = job;
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