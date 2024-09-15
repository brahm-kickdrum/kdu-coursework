package com.example.java10.service;

import com.example.java10.dao.PersonDao;
import com.example.java10.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StartUpDataAddition implements CommandLineRunner {
    @Autowired
    PersonDao personDAO;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        personDAO.addPerson(new Person("Brahm", "brahm", passwordEncoder.encode("Brahm@123"), "ROLE_ADMIN"));
        personDAO.addPerson(new Person("Armaan", "armaan", passwordEncoder.encode("Armaan@123"), "ROLE_BASIC"));
    }
}