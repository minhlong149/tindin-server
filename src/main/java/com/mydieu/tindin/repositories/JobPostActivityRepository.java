package com.mydieu.tindin.repositories;

import com.mydieu.tindin.models.Applicant;
import com.mydieu.tindin.models.JobPost;
import com.mydieu.tindin.models.JobPostActivity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobPostActivityRepository extends JpaRepository<JobPostActivity, Integer> {
    @Query(value = "SELECT j FROM JobPostActivity jpa JOIN jpa.job j WHERE jpa.applicant = :applicant")
    List<JobPost> findJobPostsByApplicant(@Param("applicant") Applicant applicant, Pageable pageable);

    void deleteByJobIdAndApplicantId(JobPost job, Applicant applicant);
}