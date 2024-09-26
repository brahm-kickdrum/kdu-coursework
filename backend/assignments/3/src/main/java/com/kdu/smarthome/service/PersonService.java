package com.kdu.smarthome.service;

import com.kdu.smarthome.model.Person;
import com.kdu.smarthome.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class PersonService {

    PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }


    public void addPerson(Person person) throws Exception {
        if(person!=null){
            personRepository.save(person);
        }
        else{
            throw new Exception("person not found");
        }
    }

    public Person getPersonByUsername(String username) throws Exception {
        Optional<Person> person = personRepository.getPersonByUsername(username);
        if(person.isPresent()){
            return person.get();
        }
        else{
            throw new Exception("person not found");
        }
    }


}
