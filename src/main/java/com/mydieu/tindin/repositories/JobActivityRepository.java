package com.mydieu.tindin.repositories;

import com.mydieu.tindin.models.JobActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobActivityRepository extends JpaRepository<JobActivity, Integer> {
}