package com.example.java12.controller;

import com.example.java12.exceptions.CustomNotFoundException;
import com.example.java12.model.ShiftUser;
import com.example.java12.service.ShiftUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ShiftUserController {
    private final ShiftUserService shiftUserService;

    @Autowired
    public ShiftUserController(ShiftUserService shiftUserService) {
        this.shiftUserService = shiftUserService;
    }

    @PostMapping("/shift-user")
    public ResponseEntity<String> saveShiftUser(@RequestBody ShiftUser shiftUser) {
        shiftUserService.saveShiftUser(shiftUser);
        return new ResponseEntity<>("ShiftUser saved successfully", HttpStatus.CREATED);
    }

    @GetMapping("/shift-user/{shiftUserId}")
    public ResponseEntity<ShiftUser> getShiftUserById(@PathVariable UUID shiftUserId) {
        ShiftUser retrievedShiftUser = shiftUserService.getShiftUserById(shiftUserId);
        if (retrievedShiftUser != null) {
            return new ResponseEntity<>(retrievedShiftUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/shift-user")
    public ResponseEntity<List<ShiftUser>> getAllShiftUsers() {
        List<ShiftUser> allShiftUsers = shiftUserService.getAllShiftUsers();
        return new ResponseEntity<>(allShiftUsers, HttpStatus.OK);
    }

    @DeleteMapping("/shift-user/{shiftUserId}")
    public ResponseEntity<String> deleteShiftUser(@PathVariable UUID shiftUserId) throws CustomNotFoundException {
        shiftUserService.deleteShiftUser(shiftUserId);
        return new ResponseEntity<>("ShiftUser deleted successfully", HttpStatus.OK);
    }
}
