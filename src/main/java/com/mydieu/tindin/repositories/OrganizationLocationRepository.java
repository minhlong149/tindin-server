package com.mydieu.tindin.repositories;

import com.mydieu.tindin.models.OrganizationLocation;
import com.mydieu.tindin.models.OrganizationLocationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationLocationRepository extends JpaRepository<OrganizationLocation, OrganizationLocationId> {
}