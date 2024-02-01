package com.example.java12.service;

import com.example.java12.exceptions.CustomNotFoundException;
import com.example.java12.model.ShiftUser;
import com.example.java12.repository.ShiftUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Service
public class ShiftUserService {
    private final ShiftUserRepo shiftUserRepo;

    @Autowired
    public ShiftUserService(ShiftUserRepo shiftUserRepo) {
        this.shiftUserRepo = shiftUserRepo;
    }

    public void saveShiftUser(ShiftUser shiftUser) {
        shiftUserRepo.save(shiftUser);
    }

    public ShiftUser getShiftUserById(UUID shiftUserId) {
        return shiftUserRepo.findById(shiftUserId).orElse(null);
    }

    public List<ShiftUser> getAllShiftUsers() {
        return shiftUserRepo.findAll();
    }

    public void deleteShiftUser(UUID shiftUserId) throws CustomNotFoundException {
        List<ShiftUser> shiftUsers = shiftUserRepo.findByShiftEndTimeAndId(LocalTime.of(23, 0), shiftUserId);

        if (!shiftUsers.isEmpty()) {
            shiftUserRepo.deleteById(shiftUserId);
        } else {
            throw new CustomNotFoundException("ShiftUser not found");
        }
    }
}
