package com.example.java12.service;

import com.example.java12.model.ShiftType;
import com.example.java12.repository.ShiftTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ShiftTypeService {
    private final ShiftTypeRepo shiftTypeRepo;

    @Autowired
    public ShiftTypeService(ShiftTypeRepo shiftTypeRepo) {
        this.shiftTypeRepo = shiftTypeRepo;
    }
    //..............

    public void saveShiftType(ShiftType shiftType) {
        shiftTypeRepo.save(shiftType);
    }

    public ShiftType getShiftTypeById(UUID shiftTypeId) {
        return shiftTypeRepo.findById(shiftTypeId).orElse(null);
    }

    public List<ShiftType> getAllShiftTypes() {
        return shiftTypeRepo.findAll();
    }
}
