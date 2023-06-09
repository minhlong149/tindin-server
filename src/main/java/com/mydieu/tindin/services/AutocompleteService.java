package com.mydieu.tindin.services;

import com.mydieu.tindin.repositories.*;
import com.mydieu.tindin.models.*;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutocompleteService {
    private final LocationRepository locationRepository;
    private final OrganizationRepository organizationRepository;
    private final IndustryRepository industryRepository;
    private final JobTypeRepository jobTypeRepository;
    private final ExperienceLevelRepository experienceLevelRepository;
    private final DegreeRepository degreeRepository;
    private final MajorRepository majorRepository;

    public AutocompleteService(
            LocationRepository locationRepository,
            OrganizationRepository organizationRepository,
            IndustryRepository industryRepository,
            JobTypeRepository jobTypeRepository,
            ExperienceLevelRepository experienceLevelRepository,
            DegreeRepository degreeRepository,
            MajorRepository majorRepository
    ) {
        this.locationRepository = locationRepository;
        this.organizationRepository = organizationRepository;
        this.industryRepository = industryRepository;
        this.jobTypeRepository = jobTypeRepository;
        this.experienceLevelRepository = experienceLevelRepository;
        this.degreeRepository = degreeRepository;
        this.majorRepository = majorRepository;
    }

    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    public List<Degree> getDegrees() {
        return degreeRepository.findAll();
    }

    public List<Major> getMajors() {
        return majorRepository.findAll();
    }

    public List<Organization> getOrganizations() {
        return organizationRepository.findAll();
    }

    public List<Industry> getIndustries() {
        return industryRepository.findAll();
    }

    public List<JobType> getJobTypes() {
        return jobTypeRepository.findAll();
    }

    public List<ExperienceLevel> getExperienceLevels() {
        return experienceLevelRepository.findAll();
    }
}
