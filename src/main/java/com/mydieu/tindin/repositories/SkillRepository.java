package com.mydieu.tindin.repositories;

import com.mydieu.tindin.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
}