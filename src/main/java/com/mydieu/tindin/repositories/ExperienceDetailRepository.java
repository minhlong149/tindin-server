package com.mydieu.tindin.repositories;

import com.mydieu.tindin.models.ExperienceDetail;
import com.mydieu.tindin.models.ExperienceDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceDetailRepository extends JpaRepository<ExperienceDetail, ExperienceDetailId> {
}