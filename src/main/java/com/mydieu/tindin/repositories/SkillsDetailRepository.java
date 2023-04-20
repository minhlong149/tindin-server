package com.mydieu.tindin.repositories;

import com.mydieu.tindin.models.SkillsDetail;
import com.mydieu.tindin.models.SkillsDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsDetailRepository extends JpaRepository<SkillsDetail, SkillsDetailId> {
}