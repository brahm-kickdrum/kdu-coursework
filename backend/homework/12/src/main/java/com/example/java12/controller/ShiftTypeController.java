package com.example.java12.controller;

import com.example.java12.model.ShiftType;
import com.example.java12.service.ShiftTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ShiftTypeController {
    private final ShiftTypeService shiftTypeService;

    @Autowired
    public ShiftTypeController(ShiftTypeService shiftTypeService) {
        this.shiftTypeService = shiftTypeService;
    }

    @PostMapping("/shift-type")
    public ResponseEntity<String> saveShiftType(@RequestBody ShiftType shiftType) {
        shiftTypeService.saveShiftType(shiftType);
        return new ResponseEntity<>("ShiftType saved successfully", HttpStatus.CREATED);
    }

    @GetMapping("/shift-type/{shiftTypeId}")
    public ResponseEntity<ShiftType> getShiftTypeById(@PathVariable UUID shiftTypeId) {
        ShiftType retrievedShiftType = shiftTypeService.getShiftTypeById(shiftTypeId);
        if (retrievedShiftType != null) {
            return new ResponseEntity<>(retrievedShiftType, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/shift-type")
    public ResponseEntity<List<ShiftType>> getAllShiftTypes() {
        List<ShiftType> allShiftTypes = shiftTypeService.getAllShiftTypes();
        return new ResponseEntity<>(allShiftTypes, HttpStatus.OK);
    }

}
