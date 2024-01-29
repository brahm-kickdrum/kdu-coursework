package com.example.java10.configuration;
//
//import com.example.java10.model.Person;
//import com.example.java10.service.PersonService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Component
//public class PersonUserDetails implements UserDetailsService {
//
//    @Autowired
//    PersonService personService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<Person> person = personService.getPersonByName(username);
//        String personUserName = null;
//        String personPassword = null;
//        List<GrantedAuthority> authorities = null;
//
//        if(person.isEmpty()){
//            throw new UsernameNotFoundException("User details not found for user : " + username + ". Please register first.");
//        }else{
//            personUserName = person.get().getUserName();
//            personPassword = person.get().getPassword();
//            authorities = new ArrayList<>();
//            authorities.add(new SimpleGrantedAuthority(person.get().getRole()));
//        }
//        return new User(personUserName, personPassword, authorities);
//    }
//}
import com.example.java10.model.Person;
import com.example.java10.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonUserDetails implements UserDetailsService {

    @Autowired
    PersonService personService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personService.getPersonUserName(username);
        String personName = null;
        String personPassword = null;
        List<GrantedAuthority> authorities = null;

        if(person == null){
            throw new UsernameNotFoundException("User details not found for user : " + username + ". Please register fist.");
        }else{
            personName = person.getUserName();
            personPassword = person.getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(person.getRole()));
        }
        return new User(personName, personPassword, authorities);
    }
}