package com.mydieu.tindin.repositories;

import com.mydieu.tindin.models.Industry;
import com.mydieu.tindin.models.Location;
import com.mydieu.tindin.models.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
    List<Organization> findByName (String name);
    List<Organization> findByIndustry (Industry industry);
    List<Organization> findByLocation (Location location);
}