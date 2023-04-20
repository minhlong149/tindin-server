package com.mydieu.tindin.repositories;

import com.mydieu.tindin.models.Degree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DegreeRepository extends JpaRepository<Degree, Integer> {
}