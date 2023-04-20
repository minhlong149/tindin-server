package com.mydieu.tindin.models;

import jakarta.persistence.*;

@Entity
@Table(name = "experience_requirement")
public class ExperienceRequirement {
    @EmbeddedId
    private ExperienceRequirementId id;

    @MapsId("jobId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private JobPost job;

    @MapsId("experienceLevel")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "experience_level", nullable = false)
    private ExperienceLevel experienceLevel;

    public ExperienceRequirementId getId() {
        return id;
    }

    public void setId(ExperienceRequirementId id) {
        this.id = id;
    }

    public JobPost getJob() {
        return job;
    }

    public void setJob(JobPost job) {
        this.job = job;
    }

    public ExperienceLevel getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(ExperienceLevel experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

}