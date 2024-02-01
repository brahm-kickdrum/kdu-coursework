package com.example.java12.controller;

import com.example.java12.model.Shift;
import com.example.java12.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
public class ShiftController {
    private final ShiftService shiftService;

    @Autowired
    public ShiftController(ShiftService shiftService) {
        this.shiftService = shiftService;
    }

    @PostMapping("/shift")
    public ResponseEntity<String> saveShift(@RequestBody Shift shift) {
        shiftService.saveShift(shift);
        return new ResponseEntity<>("Shift saved successfully", HttpStatus.CREATED);
    }

    @GetMapping("/shift/{shiftId}")
    public ResponseEntity<Shift> getShiftById(@PathVariable UUID shiftId) {
        Shift retrievedShift = shiftService.getShiftById(shiftId);
        if (retrievedShift != null) {
            return new ResponseEntity<>(retrievedShift, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/shift")
    public ResponseEntity<List<Shift>> getAllShifts() {
        List<Shift> allShifts = shiftService.getAllShifts();
        return new ResponseEntity<>(allShifts, HttpStatus.OK);
    }

    @GetMapping("/top3")
    public ResponseEntity<List<Shift>> getTop3ShiftsByDateRange(
            @RequestParam("startDate") @DateTimeFormat(pattern = "dd-MMM-yyyy") LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "dd-MMM-yyyy") LocalDate endDate) {
        List<Shift> top3Shifts = shiftService.findTop3ShiftsByDateRange(startDate, endDate);
        return new ResponseEntity<>(top3Shifts, HttpStatus.OK);
    }
}
