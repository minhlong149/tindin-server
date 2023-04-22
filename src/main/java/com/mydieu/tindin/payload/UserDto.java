package com.mydieu.tindin.payload;

import com.mydieu.tindin.models.Gender;
import com.mydieu.tindin.models.Role;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link com.mydieu.tindin.models.User} entity
 */
public record UserDto(
        Integer id,
        String username,
        Role role,
        String firstName,
        String lastName,
        Date dateOfBirth,
        Gender gender,
        String profileUrl,
        Date registrationDate,
        String email,
        String phone,
        String website
) implements Serializable {
}