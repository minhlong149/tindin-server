package com.mydieu.tindin.repositories;

import com.mydieu.tindin.models.SkillRequirement;
import com.mydieu.tindin.models.SkillRequirementId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRequirementRepository extends JpaRepository<SkillRequirement, SkillRequirementId> {
}