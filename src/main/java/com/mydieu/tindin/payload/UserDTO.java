package com.mydieu.tindin.payload;

import com.mydieu.tindin.models.Gender;
import com.mydieu.tindin.models.User;

import java.util.Date;

public record UserDTO(
        String username,
        String firstName,
        String lastName,
        Date dateOfBirth,
        Gender gender,
        String profileUrl,
        String email,
        String phone,
        String website
) {
    public static UserDTO fromUser(User user) {
        return new UserDTO(
                user.getAccount().getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getDateOfBirth(),
                user.getGender(),
                user.getProfileUrl(),
                user.getContact().getEmail(),
                user.getContact().getPhone(),
                user.getContact().getWebsite()
        );
    }
}
