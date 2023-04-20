package com.mydieu.tindin.models;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "industry_id")
    private Industry industry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @OneToMany(mappedBy = "organization")
    private Set<OrganizationLocation> organizationLocations = new LinkedHashSet<>();

    @OneToMany(mappedBy = "organization")
    private Set<JobPost> jobPosts = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Set<OrganizationLocation> getOrganizationLocations() {
        return organizationLocations;
    }

    public void setOrganizationLocations(Set<OrganizationLocation> organizationLocations) {
        this.organizationLocations = organizationLocations;
    }

    public Set<JobPost> getJobPosts() {
        return jobPosts;
    }

    public void setJobPosts(Set<JobPost> jobPosts) {
        this.jobPosts = jobPosts;
    }

}