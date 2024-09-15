package com.example.java10.repository;

import com.example.java10.model.Person;
import com.example.java10.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepo {
    List<User> userList = new ArrayList<>(Arrays.asList(new User("john", "pass123", "john@gmail.com"),
        new User("Brahm", "brahm@123", "brahmleen2002@gmail.com")));
    public List<User> getAllUsers() {
        return userList;
    }

    public Optional<User> getUser(String userName) {
        return userList.stream()
                .filter(person -> person.getUserName().equals(userName))
                .findFirst();
    }

    public void addUser(User user) {
        userList.add(user);
    }
}
