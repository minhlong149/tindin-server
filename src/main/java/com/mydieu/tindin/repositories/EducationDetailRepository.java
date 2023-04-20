package com.mydieu.tindin.repositories;

import com.mydieu.tindin.models.EducationDetail;
import com.mydieu.tindin.models.EducationDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationDetailRepository extends JpaRepository<EducationDetail, EducationDetailId> {
}