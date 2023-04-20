package com.mydieu.tindin.models;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "job_activity")
public class JobActivity {
    @EmbeddedId
    private JobActivityId id;

    @MapsId("jobId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private JobPost job;

    @MapsId("applicantId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "applicant_id", nullable = false)
    private Applicant applicant;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_apply", nullable = false)
    private User userApply;

    @Column(name = "apply_date", nullable = false)
    private Instant applyDate;

    public JobActivityId getId() {
        return id;
    }

    public void setId(JobActivityId id) {
        this.id = id;
    }

    public JobPost getJob() {
        return job;
    }

    public void setJob(JobPost job) {
        this.job = job;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public User getUserApply() {
        return userApply;
    }

    public void setUserApply(User userApply) {
        this.userApply = userApply;
    }

    public Instant getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Instant applyDate) {
        this.applyDate = applyDate;
    }

}