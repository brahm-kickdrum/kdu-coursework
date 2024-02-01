package com.example.java12.service;

import com.example.java12.model.Shift;
import com.example.java12.repository.ShiftRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ShiftService {
    private final ShiftRepo shiftRepository;

    @Autowired
    public ShiftService(ShiftRepo shiftRepository) {
        this.shiftRepository = shiftRepository;
    }

    public void saveShift(Shift shift) {
        shiftRepository.save(shift);
    }

    public Shift getShiftById(UUID shiftId) {
        return shiftRepository.findById(shiftId).orElse(null);
    }

    public List<Shift> getAllShifts() {
        return shiftRepository.findAll();
    }

    public List<Shift> findTop3ShiftsByDateRange(LocalDate startDate, LocalDate endDate) {
        return shiftRepository.findTop3ShiftsByDateRange(startDate, endDate);
    }

}
