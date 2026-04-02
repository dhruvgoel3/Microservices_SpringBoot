package com.ms.user.service.UserService.services;

import com.ms.user.service.UserService.Repositories.UserRepository;
import com.ms.user.service.UserService.entities.User;
import com.ms.user.service.UserService.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User saveUer(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUser(Integer userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User id not found on server " + userId));

    }

}
