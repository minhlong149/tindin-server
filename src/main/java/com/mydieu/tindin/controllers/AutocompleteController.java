package com.mydieu.tindin.controllers;

import com.mydieu.tindin.services.AutocompleteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/suggestion")
public class AutocompleteController {
    private final AutocompleteService autocompleteService;

    public AutocompleteController(AutocompleteService autocompleteService) {
        this.autocompleteService = autocompleteService;
    }

    @GetMapping("locations")
    public String getLocations() {
        return autocompleteService.getLocations();
    }

    @GetMapping("degrees")
    public String getDegrees() {
        return autocompleteService.getDegrees();
    }

    @GetMapping("majors")
    public String getMajors() {
        return autocompleteService.getMajors();
    }

    @GetMapping("organizations")
    public String getOrganizations() {
        return autocompleteService.getOrganizations();
    }

    @GetMapping("industries")
    public String getIndustries() {
        return autocompleteService.getIndustries();
    }

    @GetMapping("job-types")
    public String getJobTypes() {
        return autocompleteService.getJobTypes();
    }

    @GetMapping("experience-levels")
    public String getExperienceLevels() {
        return autocompleteService.getExperienceLevels();
    }

    @GetMapping("skills")
    public String getSkills() {
        return autocompleteService.getSkills();
    }
}
