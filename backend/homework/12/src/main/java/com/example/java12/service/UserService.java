package com.example.java12.service;

import com.example.java12.model.User;
import com.example.java12.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void saveUser(User user) {
        userRepo.save(user);
    }

    public User getUserById(UUID userId) {
        return userRepo.findById(userId).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public void updateUserDetails(UUID userId, String username, int loggedIn, String timeZone) {
        userRepo.updateUserDetails(userId, username, loggedIn, timeZone);
    }
    public Page<User> getAllUsersInPage(Pageable pageable){
        return userRepo.findAll(pageable);
    }
}
