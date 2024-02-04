package com.kdu.smarthome.service;

import com.kdu.smarthome.dto.DeviceAddRequestDTO;
import com.kdu.smarthome.dto.DeviceRegisterRequestDto;
import com.kdu.smarthome.model.Devices;
import com.kdu.smarthome.model.Houses;
import com.kdu.smarthome.model.Rooms;
import com.kdu.smarthome.repository.DevicesRepository;
import com.kdu.smarthome.repository.HousesRepository;
import com.kdu.smarthome.repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DevicesService {
    private final DevicesRepository devicesRepository;
    private final HousesRepository houseRepository;
    private final RoomsRepository roomRepository;

    @Autowired
    public DevicesService(DevicesRepository devicesRepository,
                              HousesRepository houseRepository,
                              RoomsRepository roomRepository) {
        this.devicesRepository = devicesRepository;
        this.houseRepository = houseRepository;
        this.roomRepository = roomRepository;
    }



//    public void addDeviceToHouse(DeviceAddRequestDTO requestDTO) {
//        Long roomId = Long.parseLong(requestDTO.getRoomId());
//
//        Rooms room = roomRepository.findById(roomId)
//                .orElseThrow(() -> new RuntimeException("Room not found with ID: " + roomId));
//
//        Devices device = new Devices();
//        device.setKickstonId(requestDTO.getKickstonId());
//
//        device.setRoom(room);
//
//        devicesRepository.save(device);
//    }

    public void addDeviceToHouse(DeviceAddRequestDTO requestDTO) {
        Long houseId = Long.parseLong(requestDTO.getHouseId());
        Long roomId = Long.parseLong(requestDTO.getRoomId());

        Houses house = houseRepository.findById(houseId)
                .orElseThrow(() -> new RuntimeException("House not found with ID: " + houseId));

        Optional<Object> roomOptional = roomRepository.findByIdAndHouse(roomId, house);
        Rooms room = (Rooms) roomOptional.orElseThrow(() -> new RuntimeException("Room not found with ID: " + roomId + " in House ID: " + houseId));

        Devices device = new Devices();
        device.setKickstonId(requestDTO.getKickstonId());
        device.setAvailable(true);

        device.setRoom(room);

        devicesRepository.save(device);
    }

    public void registerDevice(DeviceRegisterRequestDto requestDTO) {
        Devices device = new Devices();
        device.setKickstonId(requestDTO.getKickstonId());
        device.setDeviceUsername(requestDTO.getDeviceUsername());
        device.setDevicePassword(requestDTO.getDevicePassword());
        device.setAvailable(true);

        devicesRepository.save(device);
    }

}
