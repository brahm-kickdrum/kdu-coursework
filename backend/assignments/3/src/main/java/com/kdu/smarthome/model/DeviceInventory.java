package com.kdu.smarthome.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceInventory {
    @Id
    @Column(name = "kickston_id")
    private String kickstonId;

    @Column(name = "device_username")
    private String deviceUsername;

    @Column(name = "device_password")
    private String devicePassword;

    @Column(name = "manufacture_date_time")
    private LocalDateTime manufactureDateTime;

    @Column(name = "manufacture_factory_place")
    private String manufactureFactoryPlace;
}
