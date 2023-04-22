package com.mydieu.tindin.services;

import com.mydieu.tindin.payload.JobDto;
import com.mydieu.tindin.payload.OrganizationDto;
import com.mydieu.tindin.repositories.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public List<OrganizationDto> findOrganizations(
            Optional<String> organizationName,
            Optional<String> industry,
            Optional<String> location
    ) {
        // TODO: Find organizations by name, industry, location
        return null;
    }

    public OrganizationDto findOrganizationById(Integer organizationId) {
        // TODO: Find organization by id
        return null;
    }

    public List<JobDto> findJobsByOrganizationId(Integer organizationId) {
        // TODO: Find jobs posted by organization
        return null;
    }

    public void createOrganization(OrganizationDto organizationDto) {
        // TODO: Create organization
    }

    public void updateOrganization(Integer organizationId, OrganizationDto organizationDto) {
        // TODO: Update organization info by id
    }
}
