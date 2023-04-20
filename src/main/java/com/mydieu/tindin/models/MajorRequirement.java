package com.mydieu.tindin.models;

import jakarta.persistence.*;

@Entity
@Table(name = "major_requirement")
public class MajorRequirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private JobPost job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_id")
    private Major major;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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