package com.mydieu.tindin.services;

import com.mydieu.tindin.exception.ResourceNotFoundException;
<<<<<<< HEAD
import com.mydieu.tindin.models.Industry;
import com.mydieu.tindin.models.JobPost;
import com.mydieu.tindin.models.Location;
=======
import com.mydieu.tindin.models.JobPost;
>>>>>>> b80118a1fabd57b4f0f32d952c1790be740a12e4
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
<<<<<<< HEAD
    private final IndustryRepository industryRepository;
    private final LocationRepository locationRepository;
    private final JobPostRepository jobPostRepository;

    public OrganizationService(OrganizationRepository organizationRepository, IndustryRepository industryRepository, LocationRepository locationRepository, JobPostRepository jobPostRepository) {
        this.organizationRepository = organizationRepository;
        this.industryRepository = industryRepository;
        this.locationRepository = locationRepository;
=======
    private final JobPostRepository jobPostRepository;

    public OrganizationService(OrganizationRepository organizationRepository, JobPostRepository jobPostRepository) {
        this.organizationRepository = organizationRepository;
>>>>>>> b80118a1fabd57b4f0f32d952c1790be740a12e4
        this.jobPostRepository = jobPostRepository;
    }

    public List<OrganizationDto> findOrganizations(
            Optional<String> organizationName,
            Optional<String> industry,
            Optional<String> location
    ) {
        // TODO: Find organizations by name, industry, location
        return null;
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
<<<<<<< HEAD
=======

>>>>>>> b80118a1fabd57b4f0f32d952c1790be740a12e4
    }

    public List<JobDto> findJobsByOrganizationId(Integer organizationId) {
        // TODO: Find jobs posted by organization
<<<<<<< HEAD
        //return null;
=======
>>>>>>> b80118a1fabd57b4f0f32d952c1790be740a12e4
        List<JobPost> jobPosts = jobPostRepository.findJobsByOrganizationId(organizationId);

        if (jobPosts.isEmpty()) {
            throw new ResourceNotFoundException("No job found");
        }

        return jobPosts.stream().map(JobDto::fromJobPost).toList();
    }

    public void createOrganization(OrganizationRegistration organization) {
        // TODO: Create organization
<<<<<<< HEAD
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
        
=======
        Organization newOrganization = new Organization();
        newOrganization.setId(organizationDto.id());
        newOrganization.setName(organizationDto.name());
        newOrganization.setDescription(organizationDto.description());
        newOrganization.setIndustry_id(organizationDto.industry_id());
        newOrganization.setLocation_id(organizationDto.location_id());
        newOrganization.setEmail(organizationDto.email());
        newOrganization.setPhone(organizationDto.phone());
        newOrganization.setWebsite(organizationDto.website());
        organizationRepository.save(newOrganization);
>>>>>>> b80118a1fabd57b4f0f32d952c1790be740a12e4
    }

    public void updateOrganization(Integer organizationId, OrganizationRegistration newOrganization) {
        // TODO: Update organization info by id
        Organization organization = organizationRepository.findById(organizationId).orElseThrow(()-> new ResourceNotFoundException("Organization not found"));
<<<<<<< HEAD
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
=======
        if(organizationDto.name() != null && !organizationDto.name().isBlank()) {
            organization.setName(organizationDto.name());
        }
        if(organizationDto.description() != null && !organizationDto.description().isBlank()) {
            organization.setDescription(organizationDto.description());
        }
        if(organizationDto.industry_id() != null) {
            organization.setIndustry_id(organizationDto.industry_id());
        }
        if(organizationDto.location_id() != null) {
            organization.setLocation_id(organizationDto.location_id());
        }
        if(organizationDto.email() != null && !organizationDto.email().isBlank()) {
            organization.setEmail(organizationDto.email());
        }
        if(organizationDto.phone() != null && !organizationDto.phone().isBlank()) {
            organization.setPhone(organizationDto.phone());
        }
        if(organizationDto.website() != null && !organizationDto.website().isBlank()) {
            organization.setWebsite(organizationDto.website());
>>>>>>> b80118a1fabd57b4f0f32d952c1790be740a12e4
        }
        organizationRepository.save(organization);

    }
}
