package com.mydieu.tindin.repositories;

import com.mydieu.tindin.models.ExperienceRequirement;
import com.mydieu.tindin.models.ExperienceRequirementId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRequirementRepository extends JpaRepository<ExperienceRequirement, ExperienceRequirementId> {
}