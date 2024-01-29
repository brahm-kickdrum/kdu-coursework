package com.example.java10.service;

import com.example.java10.model.User;
import com.example.java10.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepo repo = new UserRepo();

    @Autowired
    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public List<User> getAllUsers() {
        return repo.getAllUsers();
    }

    public Optional<User> getUserByName(String userName) {
        return repo.getUser(userName);
    }

    public void addUser(User user) {
        repo.addUser(user);
    }
}