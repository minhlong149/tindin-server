package com.mydieu.tindin.repositories;

import com.mydieu.tindin.models.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
}