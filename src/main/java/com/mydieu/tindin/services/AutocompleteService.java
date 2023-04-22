package com.mydieu.tindin.services;

import com.mydieu.tindin.repositories.*;
import org.springframework.stereotype.Service;

@Service
public class AutocompleteService {
    private final LocationRepository locationRepository;
    private final OrganizationRepository organizationRepository;
    private final IndustryRepository industryRepository;
    private final JobTypeRepository jobTypeRepository;
    private final ExperienceLevelRepository experienceLevelRepository;
    private final SkillRepository skillRepository;
    private final DegreeRepository degreeRepository;
    private final MajorRepository majorRepository;

    public AutocompleteService(
            LocationRepository locationRepository,
            OrganizationRepository organizationRepository,
            IndustryRepository industryRepository,
            JobTypeRepository jobTypeRepository,
            ExperienceLevelRepository experienceLevelRepository,
            SkillRepository skillRepository,
            DegreeRepository degreeRepository,
            MajorRepository majorRepository
    ) {
        this.locationRepository = locationRepository;
        this.organizationRepository = organizationRepository;
        this.industryRepository = industryRepository;
        this.jobTypeRepository = jobTypeRepository;
        this.experienceLevelRepository = experienceLevelRepository;
        this.skillRepository = skillRepository;
        this.degreeRepository = degreeRepository;
        this.majorRepository = majorRepository;
    }

    public String getLocations() {
        return null;
    }

    public String getSkills() {
        return null;
    }

    public String getDegrees() {
        return null;
    }

    public String getMajors() {
        return null;
    }

    public String getOrganizations() {
        return null;
    }

    public String getIndustries() {
        return null;
    }

    public String getJobTypes() {
        return null;
    }

    public String getExperienceLevels() {
        return null;
    }
}
