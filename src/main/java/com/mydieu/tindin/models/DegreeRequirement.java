package com.mydieu.tindin.models;

import jakarta.persistence.*;

@Entity
@Table(name = "degree_requirement")
public class DegreeRequirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private JobPost job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "degree_id")
    private Degree degree;

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

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

}