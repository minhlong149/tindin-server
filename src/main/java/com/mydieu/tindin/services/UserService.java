package com.mydieu.tindin.services;

import com.mydieu.tindin.payload.UserDTO;
import com.mydieu.tindin.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserDTO::fromUser)
                .toList();
    }

    public UserDTO findById(Integer userId) {
        return userRepository.findById(userId)
                .map(UserDTO::fromUser)
                .orElseThrow();
    }
}
