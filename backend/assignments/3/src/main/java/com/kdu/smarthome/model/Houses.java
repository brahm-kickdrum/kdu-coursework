package com.kdu.smarthome.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "houses")
public class Houses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "house_id")
    private Long houseId;

    @Column(name = "house_name")
    private String houseName;

    @Column(name = "address")
    private String address;

    @OneToMany
    private List<Person> personList;

    @OneToMany
    private List<Rooms> rooms;
}
