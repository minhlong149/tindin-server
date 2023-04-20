package com.mydieu.tindin.models;

import jakarta.persistence.*;

@Entity
@Table(name = "organization_location")
public class OrganizationLocation {
    @EmbeddedId
    private OrganizationLocationId id;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private Organization id1;

    @MapsId("location")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location", nullable = false)
    private Location location;

    public OrganizationLocationId getId() {
        return id;
    }

    public void setId(OrganizationLocationId id) {
        this.id = id;
    }

    public Organization getId1() {
        return id1;
    }

    public void setId1(Organization id1) {
        this.id1 = id1;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}