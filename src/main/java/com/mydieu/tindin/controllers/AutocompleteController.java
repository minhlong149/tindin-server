package com.mydieu.tindin.controllers;

import com.mydieu.tindin.models.*;
import com.mydieu.tindin.services.AutocompleteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/suggestion")
public class AutocompleteController {
    private final AutocompleteService autocompleteService;

    public AutocompleteController(AutocompleteService autocompleteService) {
        this.autocompleteService = autocompleteService;
    }

    @GetMapping("locations")
    public List<Location> getLocations() {
        return autocompleteService.getLocations();
    }

    @GetMapping("degrees")
    public List<Degree> getDegrees() {
        return autocompleteService.getDegrees();
    }

    @GetMapping("majors")
    public List<Major> getMajors() {
        return autocompleteService.getMajors();
    }

    @GetMapping("organizations")
    public List<Organization> getOrganizations() {
        return autocompleteService.getOrganizations();
    }

    @GetMapping("industries")
    public List<Industry> getIndustries() {
        return autocompleteService.getIndustries();
    }

    @GetMapping("job-types")
    public List<JobType> getJobTypes() {
        return autocompleteService.getJobTypes();
    }

    @GetMapping("experience-levels")
    public List<ExperienceLevel> getExperienceLevels() {
        return autocompleteService.getExperienceLevels();
    }
}
