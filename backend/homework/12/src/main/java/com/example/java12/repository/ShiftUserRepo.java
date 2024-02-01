package com.example.java12.repository;

import com.example.java12.model.ShiftUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface ShiftUserRepo extends JpaRepository<ShiftUser, UUID> {
    List<ShiftUser> findByShiftEndTimeAndId(LocalTime timeEnd, UUID shiftUserId);
}
