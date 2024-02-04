package com.kdu.smarthome.service;

import com.kdu.smarthome.dto.*;
import com.kdu.smarthome.model.Houses;
import com.kdu.smarthome.model.Person;
import com.kdu.smarthome.model.Rooms;
import com.kdu.smarthome.repository.HousesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HousesService {

    private final HousesRepository housesRepository;

    @Autowired
    public HousesService(HousesRepository housesRepository) {
        this.housesRepository = housesRepository;
    }

    public Houses addHouse(Houses house) {
        return housesRepository.save(house);
    }

    public String addUserToHouse(Long houseId, String username) {
        Optional<Houses> optionalHouses = housesRepository.findById(houseId);

        if (optionalHouses.isPresent()) {
            Houses house = optionalHouses.get();
            Person newPerson = new Person();
            newPerson.setUsername(username);

            house.getPersonList().add(newPerson);

            housesRepository.save(house);

            return "User added successfully to the house!";
        } else {
            return "House not found!";
        }
    }

    public HouseResponseDto getAllHouses() {
        List<Houses> houses = housesRepository.findAll();
        return new HouseResponseDto("Success", houses, "200 OK");
    }

    public HouseUpdateResponseDto updateHouseAddress(String houseId, String newAddress) {
        Optional<Houses> optionalHouse = housesRepository.findById(Long.parseLong(houseId));

        if (optionalHouse.isPresent()) {
            Houses house = optionalHouse.get();
            house.setAddress(newAddress);
            housesRepository.save(house);

            return new HouseUpdateResponseDto("Success", "House address updated", "200 OK");
        } else {
            return new HouseUpdateResponseDto("Error", "House not found", "404 Not Found");
        }
    }

    public HouseDetailsResponseDto getHouseDetails(String houseId) {
        Optional<Houses> optionalHouse = housesRepository.findById(Long.parseLong(houseId));

        if (optionalHouse.isPresent()) {
            Houses house = optionalHouse.get();

            // Assuming you have a List<Rooms> and List<Devices> in your Houses entity
            String roomsAndDevices = house.getRooms().stream()
                    .map(room -> {
                        String roomInfo = String.format("Room ID: %d, Name: %s", room.getId(), room.getName());
                        String devicesInfo = room.getDevices().stream()
                                .map(device -> String.format("Device ID: %s, Name: %s", device.getKickstonId(), device.getDeviceUsername()))
                                .collect(Collectors.joining(", "));
                        return roomInfo + ", Devices: [" + devicesInfo + "]";
                    })
                    .collect(Collectors.joining(", "));

            return new HouseDetailsResponseDto("Success", roomsAndDevices, "200 OK");
        } else {
            return new HouseDetailsResponseDto("Error", "House not found", "404 Not Found");
        }
    }

    public RoomResponseDto addRoomToHouse(String houseId, RoomAdditionRequestDto roomDTO) throws ChangeSetPersister.NotFoundException {
        Long convertedHouseId = Long.parseLong(houseId);

        Houses house = housesRepository.findById(convertedHouseId)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);

        Rooms room = new Rooms();
        room.setId(roomDTO.getId());
        room.setName(roomDTO.getName());
        room.setHouse(house);

        house.getRooms().add(room);
        housesRepository.save(house);
        return new RoomResponseDto("Room added to house successfully", room.getId().toString(), "200 OK");
    }
}
