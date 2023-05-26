package com.mydieu.tindin.repositories;

import com.mydieu.tindin.models.Applicant;
import com.mydieu.tindin.models.JobPost;
import com.mydieu.tindin.models.JobPostActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostActivityRepository extends JpaRepository<JobPostActivity, Integer> {
    void deleteByJobIdAndApplicantId(JobPost job, Applicant applicant);
}