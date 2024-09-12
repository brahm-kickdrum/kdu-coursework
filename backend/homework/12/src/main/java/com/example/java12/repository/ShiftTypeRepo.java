package com.example.java12.repository;

import com.example.java12.model.ShiftType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShiftTypeRepo extends JpaRepository<ShiftType, UUID> {
}
