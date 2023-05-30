package com.mydieu.tindin.services;

import com.mydieu.tindin.exception.ResourceNotFoundException;
import com.mydieu.tindin.models.JobPost;
import com.mydieu.tindin.models.Organization;
import com.mydieu.tindin.payload.JobDto;
import com.mydieu.tindin.payload.OrganizationDto;
import com.mydieu.tindin.repositories.OrganizationRepository;
import com.mydieu.tindin.repositories.JobPostRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final JobPostRepository jobPostRepository;

    public OrganizationService(OrganizationRepository organizationRepository, JobPostRepository jobPostRepository) {
        this.organizationRepository = organizationRepository;
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

    }

    public List<JobDto> findJobsByOrganizationId(Integer organizationId) {
        // TODO: Find jobs posted by organization
        List<JobPost> jobPosts = jobPostRepository.findJobsByOrganizationId(organizationId);

        if (jobPosts.isEmpty()) {
            throw new ResourceNotFoundException("No job found");
        }

        return jobPosts.stream().map(JobDto::fromJobPost).toList();
    }

    public void createOrganization(OrganizationDto organizationDto) {
        // TODO: Create organization
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
    }

    public void updateOrganization(Integer organizationId, OrganizationDto organizationDto) {
        // TODO: Update organization info by id
        Organization organization = organizationRepository.findById(organizationId).orElseThrow(()-> new ResourceNotFoundException("Organization not found"));
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
        }
        organizationRepository.save(organization);

    }
}
