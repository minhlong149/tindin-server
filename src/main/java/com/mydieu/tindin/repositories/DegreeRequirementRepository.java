package com.mydieu.tindin.repositories;

import com.mydieu.tindin.models.DegreeRequirement;
import com.mydieu.tindin.models.DegreeRequirementId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DegreeRequirementRepository extends JpaRepository<DegreeRequirement, DegreeRequirementId> {
}