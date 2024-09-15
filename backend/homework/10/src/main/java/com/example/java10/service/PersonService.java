package com.example.java10.service;

import com.example.java10.dao.PersonDao;
import com.example.java10.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {
    PersonDao personDao = new PersonDao();

    @Autowired
    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public Optional<Person> getPersonByName(String userName) {
        return personDao.getPerson(userName);
    }

    public Person getPersonUserName(String name){
        for(Person person : personDao.getAllPersons()){
            if(person.getUserName().equals(name)){
                return person;
            }
        }
        return null;
    }
}
