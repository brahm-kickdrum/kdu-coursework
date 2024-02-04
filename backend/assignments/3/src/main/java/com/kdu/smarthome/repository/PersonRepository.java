package com.kdu.smarthome.repository;

import com.kdu.smarthome.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
    Optional<Person> getPersonByUsername(String username);
}
