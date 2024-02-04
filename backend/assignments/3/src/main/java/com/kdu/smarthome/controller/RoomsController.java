package com.kdu.smarthome.controller;

import com.kdu.smarthome.dto.RoomAdditionRequestDto;
import com.kdu.smarthome.dto.RoomRequestDto;
import com.kdu.smarthome.dto.RoomResponseDto;
import com.kdu.smarthome.model.Rooms;
import com.kdu.smarthome.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/room")
public class RoomsController {

    private final RoomsService roomService;

    @Autowired
    public RoomsController(RoomsService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/create")
    public ResponseEntity<RoomResponseDto> createRoom(@RequestBody RoomRequestDto roomRequestDTO) {
        RoomResponseDto response = roomService.createRoom(roomRequestDTO);
        return ResponseEntity.ok(response);
    }



}
