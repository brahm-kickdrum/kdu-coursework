package com.example.java10.configuration;
//
//import com.example.java10.service.PersonService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import com.example.java10.model.Person;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Component
//public class CustomAuthenticationManager implements AuthenticationProvider {
//    @Autowired
//    PersonService personService;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();
//        String pwd = authentication.getCredentials().toString();
//        Optional<Person> person = personService.getPersonByName(username);
//
//        if(person.isEmpty()){
//            throw new BadCredentialsException("No user registered with this details!");
//        }else{
//            if (passwordEncoder.matches(pwd, person.get().getPassword())) {
//                return new UsernamePasswordAuthenticationToken(username, pwd, getGrantedAuthorities(person.get().getRole()));
//            } else {
//                throw new BadCredentialsException("Invalid password!");
//            }
//        }
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
//    }
//
//    private List<GrantedAuthority> getGrantedAuthorities(String role) {
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//
//        grantedAuthorities.add(new SimpleGrantedAuthority(role));
//
//        return grantedAuthorities;
//    }
//}


import com.example.java10.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.example.java10.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomAuthenticationManager implements AuthenticationProvider {
    @Autowired
    PersonService personService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        Optional<Person> person = Optional.ofNullable(personService.getPersonUserName(username));

        if(person.isEmpty()){
            throw new BadCredentialsException("No user registered with this details!");
        }else{
            if (passwordEncoder.matches(pwd, person.get().getPassword())) {
                return new UsernamePasswordAuthenticationToken(username, pwd, getGrantedAuthorities(person.get().getRole()));
            } else {
                throw new BadCredentialsException("Invalid password!");
            }
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

    private List<GrantedAuthority> getGrantedAuthorities(String role) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        grantedAuthorities.add(new SimpleGrantedAuthority(role));

        return grantedAuthorities;
    }
}