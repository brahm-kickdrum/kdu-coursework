package com.example.java10.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private String userName;
    private String name;
    private String password;
    private String role;
}
