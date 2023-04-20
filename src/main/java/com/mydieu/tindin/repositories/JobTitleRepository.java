package com.mydieu.tindin.repositories;

import com.mydieu.tindin.models.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTitleRepository extends JpaRepository<JobTitle, Integer> {
}