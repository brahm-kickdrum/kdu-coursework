package com.example.java10.dao;

import com.example.java10.model.Person;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class PersonDao {
    List<Person> personList;

    public PersonDao() {
        this.personList = new ArrayList<>();
    }

    public void addPerson(Person person){
        personList.add(person);
    }

    public Optional<Person> getPerson(String userName) {
        return personList.stream()
                .filter(person -> person.getUserName().equals(userName))
                .findFirst();
    }

    public List<Person> getAllPersons(){
        return personList;
    }
}
