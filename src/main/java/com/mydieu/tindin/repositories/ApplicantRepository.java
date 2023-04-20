package com.mydieu.tindin.repositories;

import com.mydieu.tindin.models.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
}