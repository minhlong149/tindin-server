package com.mydieu.tindin.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class JobActivityId implements Serializable {
    private static final long serialVersionUID = 7531710724122873138L;
    @Column(name = "job_id", nullable = false)
    private Integer jobId;

    @Column(name = "applicant_id", nullable = false)
    private Integer applicantId;

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        JobActivityId entity = (JobActivityId) o;
        return Objects.equals(this.jobId, entity.jobId) &&
                Objects.equals(this.applicantId, entity.applicantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, applicantId);
    }

}