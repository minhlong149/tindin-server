package com.mydieu.tindin.models;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @Column(name = "account_id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name = "role", columnDefinition = "role not null", nullable = false)
    @Enumerated(EnumType.STRING)
    @ColumnTransformer(
            read = "role::text",
            write = "?::role"
    )
    private Role role;

    @Column(name = "first_name", nullable = false, length = Integer.MAX_VALUE)
    private String firstName;

    @Column(name = "last_name", length = Integer.MAX_VALUE)
    private String lastName;

    @Column(name = "gender", columnDefinition = "gender")
    @Enumerated(EnumType.STRING)
    @ColumnTransformer(
            read = "gender::text",
            write = "?::gender"
    )
    private Gender gender;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "registration_date", columnDefinition = "timestamp default now()", insertable = false, updatable = false)
    @CreationTimestamp
    private Instant registrationDate;

    @Column(name = "profile_url", length = Integer.MAX_VALUE)
    private String profileUrl;
    @Column(name = "phone", length = Integer.MAX_VALUE)
    private String phone;

    @Column(name = "email", length = Integer.MAX_VALUE)
    private String email;
    @Column(name = "website", length = Integer.MAX_VALUE)
    private String website;

    public User() {
    }

    public User(Account newAccount, Role recruiter, String firstName) {
        this.id = newAccount.getId();
        this.account = newAccount;
        this.role = recruiter;
        this.firstName = firstName;
    }

    public User(Account account, Role role, String firstName, String lastName, Gender gender, LocalDate dateOfBirth, String profileUrl, String phone, String email, String website) {
        this.id = account.getId();
        this.account = account;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.profileUrl = profileUrl;
        this.phone = phone;
        this.email = email;
        this.website = website;
    }

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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Instant getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Instant registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}