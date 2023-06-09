package com.mydieu.tindin.repositories;

import com.mydieu.tindin.models.Applicant;
import com.mydieu.tindin.models.JobPost;
import com.mydieu.tindin.models.JobPostActivity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JobPostActivityRepository extends JpaRepository<JobPostActivity, Integer> {
    @Modifying
    @Transactional
    @Query("delete from JobPostActivity jb where jb.job.id = ?1 and jb.applicant.id = ?2")
    void deleteByJobIdAndApplicantId(Integer job, Integer applicant);

    @Transactional
    @Query("select applicant from JobPostActivity jb where jb.job = ?1 ")
    List<Applicant> findApplicantByJob(JobPost job);

    @Query("select applicant from JobPostActivity jb where jb.job.id = ?1 and jb.applicant.id =?2 ")
    Applicant findApplicantByJobAndAppplicant(Integer job, Integer applicant);

    @Query(value = "SELECT j FROM JobPostActivity jpa JOIN jpa.job j WHERE jpa.applicant = :applicant")
    List<JobPost> findJobPostsByApplicant(@Param("applicant") Applicant applicant, Pageable pageable);

}