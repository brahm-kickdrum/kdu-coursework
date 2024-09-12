package com.example.java12.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "users")
public class User extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 32)
    private String username;

    private int loggedIn;

    @Column(length = 32)
    private String timeZone;

    @ManyToOne(fetch = FetchType.EAGER)
    private Tenant tenant;
}
