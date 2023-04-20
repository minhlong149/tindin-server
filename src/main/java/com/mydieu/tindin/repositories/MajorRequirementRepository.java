package com.mydieu.tindin.repositories;

import com.mydieu.tindin.models.MajorRequirement;
import com.mydieu.tindin.models.MajorRequirementId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorRequirementRepository extends JpaRepository<MajorRequirement, MajorRequirementId> {
}