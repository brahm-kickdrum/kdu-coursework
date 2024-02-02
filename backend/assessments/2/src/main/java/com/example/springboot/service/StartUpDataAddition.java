package com.example.springboot.service;

import com.example.springboot.dao.PersonDAO;
import com.example.springboot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StartUpDataAddition implements CommandLineRunner {

    @Autowired
    PersonDAO personDAO = new PersonDAO();

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        personDAO.addPerson(new Person("Brahm", "brahm", passwordEncoder.encode("Testing123"), "ROLE_ADMIN"));
        personDAO.addPerson(new Person("Armaan", "armaan", passwordEncoder.encode("Testing123"), "ROLE_BASIC"));
    }
}
