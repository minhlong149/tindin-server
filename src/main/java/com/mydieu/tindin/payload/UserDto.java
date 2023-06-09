package com.mydieu.tindin.payload;

import com.mydieu.tindin.models.Gender;
import com.mydieu.tindin.models.Role;
import com.mydieu.tindin.models.User;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.mydieu.tindin.models.User} entity
 */
public record UserDto(
        Integer accountId,
        String accountUsername,
        Role role,
        String firstName,
        String lastName,
        Gender gender,
        LocalDate dateOfBirth,
        Instant registrationDate,
        String profileUrl,
        String phone,
        String email,
        String website
) implements Serializable {
    public static UserDto fromUser(User user) {
        return new UserDto(
                user.getAccount().getId(),
                user.getAccount().getUsername(),
                user.getRole(),
                user.getFirstName(),
                user.getLastName(),
                user.getGender(),
                user.getDateOfBirth(),
                user.getRegistrationDate(),
                user.getProfileUrl(),
                user.getPhone(),
                user.getEmail(),
                user.getWebsite()
        );
    }
}