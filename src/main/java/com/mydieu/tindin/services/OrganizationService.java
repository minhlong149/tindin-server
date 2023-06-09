package com.mydieu.tindin.services;

import com.mydieu.tindin.exception.ResourceNotFoundException;
import com.mydieu.tindin.models.Industry;
import com.mydieu.tindin.models.JobPost;
import com.mydieu.tindin.models.Location;
import com.mydieu.tindin.models.Organization;
import com.mydieu.tindin.payload.JobDto;
import com.mydieu.tindin.payload.OrganizationDto;
import com.mydieu.tindin.payload.OrganizationRegistration;
import com.mydieu.tindin.repositories.IndustryRepository;
import com.mydieu.tindin.repositories.JobPostRepository;
import com.mydieu.tindin.repositories.LocationRepository;
import com.mydieu.tindin.repositories.OrganizationRepository;
import com.mydieu.tindin.repositories.JobPostRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final IndustryRepository industryRepository;
    private final LocationRepository locationRepository;
    private final JobPostRepository jobPostRepository;

    public OrganizationService(OrganizationRepository organizationRepository, IndustryRepository industryRepository, LocationRepository locationRepository, JobPostRepository jobPostRepository) {
        this.organizationRepository = organizationRepository;
        this.industryRepository = industryRepository;
        this.locationRepository = locationRepository;
        this.jobPostRepository = jobPostRepository;
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
        // Integer id,
        // String name,
        // String description,
        // String industry,
        // String location,
        // String email,
        // String phone,
        // String website
    public OrganizationDto findOrganizationById(Integer organizationId) {
        // TODO: Find organization by id
        return organizationRepository.findById(organizationId).map(OrganizationDto::fromOrganization).orElseThrow(() -> new ResourceNotFoundException("Organization not found"));
    }

    public List<JobDto> findJobsByOrganizationId(Integer organizationId) {
        // TODO: Find jobs posted by organization
        List<JobPost> jobPosts = jobPostRepository.findJobsByOrganizationId(organizationId);

        if (jobPosts.isEmpty()) {
            throw new ResourceNotFoundException("No job found");
        }

        return jobPosts.stream().map(JobDto::fromJobPost).toList();
    }

    public void createOrganization(OrganizationRegistration organization) {
        // TODO: Create organization
        Organization newOrganization = new Organization (
                organization.name(),
                organization.description(),
                organization.industryId(),
                organization.locationId(),
                organization.email(),
                organization.phone(),
                organization.website()
        );
        organizationRepository.save(newOrganization);
    }

    public void updateOrganization(Integer organizationId, OrganizationRegistration newOrganization) {
        // TODO: Update organization info by id
        Organization organization = organizationRepository.findById(organizationId).orElseThrow(()-> new ResourceNotFoundException("Organization not found"));
        if(newOrganization.name() != null && !newOrganization.name().isBlank()) {
            organization.setName(newOrganization.name());
        }
        if(newOrganization.description() != null && !newOrganization.description().isBlank()) {
            organization.setDescription(newOrganization.description());
        }
        if(newOrganization.industryId()!=null) {
            Industry industry = industryRepository.findById(newOrganization.industryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Industry not found"));
            organization.setIndustry(industry);
        }
        if(newOrganization.locationId()!=null) {
            Location location = locationRepository.findById(newOrganization.locationId())
                    .orElseThrow(() -> new ResourceNotFoundException("Industry not found"));
            organization.setLocation(location);
        }
        if(newOrganization.email() != null && !newOrganization.email().isBlank()) {
            organization.setEmail(newOrganization.email());
        }
        if(newOrganization.phone() != null && !newOrganization.phone().isBlank()) {
            organization.setPhone(newOrganization.phone());
        }
        if(newOrganization.website() != null && !newOrganization.website().isBlank()) {
            organization.setWebsite(newOrganization.website());
        }
        organizationRepository.save(organization);

    }
}
