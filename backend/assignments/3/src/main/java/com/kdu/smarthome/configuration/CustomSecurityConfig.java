package com.kdu.smarthome.configuration;

import com.kdu.smarthome.filter.TokenGeneratorFilter;
import com.kdu.smarthome.filter.TokenValidatorFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class CustomSecurityConfig {


    @Bean
    SecurityFilterChain customDefaultFilter(HttpSecurity http) throws Exception {
        http

//                .addFilterAfter(new TokenGeneratorFilter(), BasicAuthenticationFilter.class)
//                .addFilterBefore(new TokenValidatorFilter(), BasicAuthenticationFilter.class)h
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/api/v1/auth/register","/**").permitAll()
                        .requestMatchers("/**").hasRole("BASIC")
                        .anyRequest().authenticated()).csrf().disable();
        http.httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
