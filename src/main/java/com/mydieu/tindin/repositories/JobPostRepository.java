package com.mydieu.tindin.repositories;

import com.mydieu.tindin.models.JobPost;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobPostRepository extends JpaRepository<JobPost, Integer> {
    List<JobPost> findByRecruiterId(Integer recruiterId, Pageable pageable);

    //@Query(value = "SELECT jb FROM job_post jb WHERE jb.job_type_id = ?1")
    //List<JobPost> findByJobTypeId(Integer jobType);
    //@Query(value = "SELECT jb FROM job_post jb WHERE jb.title= ?1")
    List<JobPost> findByTitle(String title);



}