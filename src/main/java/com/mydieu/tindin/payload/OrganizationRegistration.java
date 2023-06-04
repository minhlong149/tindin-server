/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mydieu.tindin.payload;

import com.mydieu.tindin.models.Industry;
import com.mydieu.tindin.models.Location;
import java.io.Serializable;

/**
 *
 * @author xuanbien
 */
public record OrganizationRegistration  (
        Integer id,
        String name,
        String description,
        Industry industry,
        Integer industryId,
        Location location,
        Integer locationId,
        String city,
        String email,
        String phone,
        String website
) implements Serializable {
    
}
