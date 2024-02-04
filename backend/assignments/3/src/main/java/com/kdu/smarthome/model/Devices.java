package com.kdu.smarthome.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "devices")
public class Devices {

    @Id
    @Column(name = "kickston_id")
    private String kickstonId;

    @Column(name = "device_username")
    private String deviceUsername;

    @Column(name = "device_password")
    private String devicePassword;

    @Column(name = "available")
    private boolean available;

    @ManyToOne
    private Rooms room;
}
