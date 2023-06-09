/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mydieu.tindin.payload;

import com.mydieu.tindin.models.JobType;
import com.mydieu.tindin.models.Organization;
import com.mydieu.tindin.models.User;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

/**
 *
 * @author xuanbien
 */
public record JobRegistration (
        Integer id,
        Integer recruiterId,
        User user,
        Organization organization,
        JobType jobType,
        String title,
        String description,
        String jobTypeId,
        Integer salary,
        Instant createdDate,
        Instant closingDate,
        Boolean isOpen,
        Set<String> requireMajors,
        Set<String> requireDegrees,
        Set<String> requireExperienceLevels,
        Set<SkillDto> requireSkills
        
) implements Serializable {
    
}
    

