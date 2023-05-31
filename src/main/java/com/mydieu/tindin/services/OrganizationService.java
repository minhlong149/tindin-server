package com.mydieu.tindin.services;

import com.mydieu.tindin.models.Industry;
import com.mydieu.tindin.models.Location;
import com.mydieu.tindin.models.Organization;
import com.mydieu.tindin.payload.JobDto;
import com.mydieu.tindin.payload.OrganizationDto;
import com.mydieu.tindin.repositories.IndustryRepository;
import com.mydieu.tindin.repositories.LocationRepository;
import com.mydieu.tindin.repositories.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final IndustryRepository industryRepository;
    private final LocationRepository locationRepository;

    public OrganizationService(OrganizationRepository organizationRepository, IndustryRepository industryRepository, LocationRepository locationRepository) {
        this.organizationRepository = organizationRepository;
        this.industryRepository = industryRepository;
        this.locationRepository = locationRepository;
    }

    public List<OrganizationDto> findOrganizations(
            Optional<String> organizationName,
            Optional<String> industry,
            Optional<String> location
    ) {
        // TODO: Find organizations by name, industry, location
        String filter = null;
        List<Organization> organizationList = null;
        if(!organizationName.isEmpty()) {
            organizationList = organizationRepository.findByName(organizationName.orElse(""));
        }
        if(!industry.isEmpty()) {
            Industry industry1 = industryRepository.findByName(industry.orElse(""));
            organizationList = organizationRepository.findByIndustry(industry1);
        }
        if(!location.isEmpty()) {
            Location location1 = locationRepository.findByCity(location.orElse(""));
            organizationList = organizationRepository.findByLocation(location1);
        }

        return organizationList.stream().map(OrganizationDto::fromOrganization).toList();
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
