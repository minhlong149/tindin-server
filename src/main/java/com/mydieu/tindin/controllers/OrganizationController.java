package com.mydieu.tindin.controllers;

import com.mydieu.tindin.payload.JobDto;
import com.mydieu.tindin.payload.OrganizationDto;
import com.mydieu.tindin.services.OrganizationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/organizations")
public class OrganizationController {
    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("")
    public List<OrganizationDto> getOrganizations(
            @RequestParam Optional<String> organizationName,
            @RequestParam Optional<String> industry,
            @RequestParam Optional<String> location
    ) {
        return organizationService.findOrganizations(organizationName, industry, location);
    }

    @GetMapping("{organizationId}")
    public OrganizationDto getOrganization(@PathVariable Integer organizationId) {
        return organizationService.findOrganizationById(organizationId);
    }

    @GetMapping("{organizationId}/jobs")
    public List<JobDto> getJobs(@PathVariable Integer organizationId) {
        return organizationService.findJobsByOrganizationId(organizationId);
    }

    @PostMapping("")
    public void createOrganization(@RequestBody OrganizationDto organizationDto) {
        organizationService.createOrganization(organizationDto);
    }

    @PutMapping("{organizationId}")
    public void updateOrganization(@PathVariable Integer organizationId, @RequestBody OrganizationDto organizationDto) {
        organizationService.updateOrganization(organizationId, organizationDto);
    }
}
