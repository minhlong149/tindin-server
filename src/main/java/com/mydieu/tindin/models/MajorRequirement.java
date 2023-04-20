package com.mydieu.tindin.models;

import jakarta.persistence.*;

@Entity
@Table(name = "major_requirement")
public class MajorRequirement {
    @EmbeddedId
    private MajorRequirementId id;

    @MapsId("jobId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private JobPost job;

    @MapsId("major")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "major", nullable = false)
    private Major major;

    public MajorRequirementId getId() {
        return id;
    }

    public void setId(MajorRequirementId id) {
        this.id = id;
    }

    public JobPost getJob() {
        return job;
    }

    public void setJob(JobPost job) {
        this.job = job;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

}