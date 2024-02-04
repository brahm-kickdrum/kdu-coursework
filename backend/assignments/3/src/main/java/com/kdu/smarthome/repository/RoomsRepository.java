package com.kdu.smarthome.repository;

import com.kdu.smarthome.model.Houses;
import com.kdu.smarthome.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomsRepository  extends JpaRepository<Rooms, Long> {
    Optional<Object> findByIdAndHouse(Long roomId, Houses house);
}
