package com.mydieu.tindin.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private Account account;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Column(name = "first_name", nullable = false, length = Integer.MAX_VALUE)
    private String firstName;

    @Column(name = "last_name", length = Integer.MAX_VALUE)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "profile_url", length = Integer.MAX_VALUE)
    private String profileUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact")
    private Contact contact;
    @OneToMany(mappedBy = "userApply")
    private Set<JobActivity> jobActivities = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Set<JobActivity> getJobActivities() {
        return jobActivities;
    }

    public void setJobActivities(Set<JobActivity> jobActivities) {
        this.jobActivities = jobActivities;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}