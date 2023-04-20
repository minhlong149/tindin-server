package com.mydieu.tindin.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "job_activity")
public class JobActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private JobPost job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_apply", nullable = false)
    private User userApply;

    @Column(name = "apply_date", nullable = false)
    private Date applyDate;

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

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

}