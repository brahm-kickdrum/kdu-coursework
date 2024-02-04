package com.kdu.smarthome.repository;

import com.kdu.smarthome.model.Houses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HousesRepository extends JpaRepository<Houses, Long> {
}
