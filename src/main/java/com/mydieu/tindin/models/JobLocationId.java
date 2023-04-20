package com.mydieu.tindin.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class JobLocationId implements Serializable {
    private static final long serialVersionUID = 5647345455747892787L;
    @Column(name = "job_id", nullable = false)
    private Integer jobId;

    @Column(name = "location", nullable = false)
    private Integer location;

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        JobLocationId entity = (JobLocationId) o;
        return Objects.equals(this.jobId, entity.jobId) &&
                Objects.equals(this.location, entity.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, location);
    }

}