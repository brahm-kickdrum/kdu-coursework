package com.kdu.smarthome.repository;

import com.kdu.smarthome.model.Devices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevicesRepository extends JpaRepository<Devices, String> {
    
}
