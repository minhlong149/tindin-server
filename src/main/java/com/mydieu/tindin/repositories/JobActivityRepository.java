package com.mydieu.tindin.repositories;

import com.mydieu.tindin.models.JobActivity;
import com.mydieu.tindin.models.JobActivityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobActivityRepository extends JpaRepository<JobActivity, JobActivityId> {
}