package com.mydieu.tindin.repositories;

import com.mydieu.tindin.models.JobPost;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface JobPostRepository extends JpaRepository<JobPost, Integer> {
    List<JobPost> findByRecruiterId(Integer recruiterId, Pageable pageable);
  
    @Query("SELECT j FROM JobPost j WHERE j.recruiter.organization.id = ?1")    
    public List<JobPost> findJobsByOrganizationId(Integer organizationId);
  
    List<JobPost> findByTitle(String title);
}