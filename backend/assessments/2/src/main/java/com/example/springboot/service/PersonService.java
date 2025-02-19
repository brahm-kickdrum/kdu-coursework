package com.example.springboot.service;

import com.example.springboot.dao.PersonDAO;
import com.example.springboot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    PersonDAO personDAO = new PersonDAO();

    @Autowired
    public PersonService(PersonDAO personDAO){
        this.personDAO = personDAO;
    }


    public void addPerson(Person person){
        personDAO.addPerson(person);
    }

    public Person getPersonById(int id){
        return personDAO.getPersonByIdx(id);
    }

    public String getRoleById(int id){
        return personDAO.getRoleByPersonIdx(id);
    }

    public Person getPersonUsername(String name){
        for(Person p : personDAO.getAllPersons()){
            if(p.getUsername().equals(name)){
                return p;
            }
        }
        return null;
    }

}
