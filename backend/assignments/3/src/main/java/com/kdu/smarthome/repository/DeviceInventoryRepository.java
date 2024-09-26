package com.kdu.smarthome.repository;

import com.kdu.smarthome.model.DeviceInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceInventoryRepository extends JpaRepository<DeviceInventory, String> {
}
