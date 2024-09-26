package com.kdu.smarthome.service;

import com.kdu.smarthome.dto.RoomRequestDto;
import com.kdu.smarthome.dto.RoomResponseDto;
import com.kdu.smarthome.model.Houses;
import com.kdu.smarthome.model.Rooms;
import com.kdu.smarthome.repository.HousesRepository;
import com.kdu.smarthome.repository.RoomsRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomsService {
    RoomsRepository roomsRepository;

    public RoomsService(RoomsRepository roomsRepository){
        this.roomsRepository = roomsRepository;
    }

    public RoomResponseDto createRoom(RoomRequestDto roomRequestDTO) {
        Rooms room = new Rooms();
        room.setName(roomRequestDTO.getName());

        roomsRepository.save(room);

        return new RoomResponseDto("Room created successfully", room.toString(), "200 OK");
    }

}
