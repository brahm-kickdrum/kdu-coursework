package com.example.java12.repository;

import com.example.java12.model.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface ShiftRepo extends JpaRepository<Shift, UUID> {
    @Query("SELECT s FROM Shift s WHERE s.dateStart = :startDate AND s.dateEnd = :endDate ORDER BY s.name ASC LIMIT 3")
    List<Shift> findTop3ShiftsByDateRange(LocalDate startDate, LocalDate endDate);
}
