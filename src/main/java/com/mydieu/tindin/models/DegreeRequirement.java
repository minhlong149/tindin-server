package com.mydieu.tindin.models;

import jakarta.persistence.*;

@Entity
@Table(name = "degree_requirement")
public class DegreeRequirement {
    @EmbeddedId
    private DegreeRequirementId id;

    @MapsId("jobId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private JobPost job;

    @MapsId("degree")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "degree", nullable = false)
    private Degree degree;

    public DegreeRequirementId getId() {
        return id;
    }

    public void setId(DegreeRequirementId id) {
        this.id = id;
    }

    public JobPost getJob() {
        return job;
    }

    public void setJob(JobPost job) {
        this.job = job;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

}