package com.mydieu.tindin.repositories;

import com.mydieu.tindin.models.JobType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTypeRepository extends JpaRepository<JobType, Integer> {
}