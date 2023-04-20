package com.mydieu.tindin.models;

import jakarta.persistence.*;

@Entity
@Table(name = "job_location")
public class JobLocation {
    @EmbeddedId
    private JobLocationId id;

    @MapsId("jobId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private JobPost job;

    @MapsId("location")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location", nullable = false)
    private Location location;

    public JobLocationId getId() {
        return id;
    }

    public void setId(JobLocationId id) {
        this.id = id;
    }

    public JobPost getJob() {
        return job;
    }

    public void setJob(JobPost job) {
        this.job = job;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}