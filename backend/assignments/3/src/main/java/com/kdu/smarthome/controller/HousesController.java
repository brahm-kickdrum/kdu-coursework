package com.kdu.smarthome.controller;

import com.kdu.smarthome.dto.*;
import com.kdu.smarthome.exception.MyCustomException;
import com.kdu.smarthome.model.Houses;
import com.kdu.smarthome.service.HousesService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/house")
public class HousesController {

    private final HousesService housesService;

    @Autowired
    public HousesController(HousesService housesService) {
        this.housesService = housesService;
    }

    @PostMapping
    public ResponseEntity<Houses> addHouse(@RequestBody Houses house) {
        Houses addedHouse = housesService.addHouse(house);
        return ResponseEntity.ok(addedHouse);
    }

    @PostMapping("/{houseId}/add-user")
    public ResponseEntity<AddUserResponseDto> addUserToHouse(@PathVariable Long houseId, @RequestBody AddUserRequestDto addUserRequestDto, HttpServletRequest request) {
        if(request.getHeader("Authorization") == null){
            throw new MyCustomException("Unauthorized User");
        }
        String result = housesService.addUserToHouse(houseId, addUserRequestDto.getUsername());

        AddUserResponseDto responseDto = new AddUserResponseDto();
        responseDto.setMessage(result);
        responseDto.setObject("User added successfully");
        responseDto.setHttpStatus(HttpStatus.OK.toString());

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping
    public HouseResponseDto getAllHouses() {
        return housesService.getAllHouses();
    }

    @PutMapping
    public HouseUpdateResponseDto updateHouseAddress(
            @RequestParam String houseId,
            @RequestBody HouseUpdateRequestDto requestDTO) {
        return housesService.updateHouseAddress(houseId, requestDTO.getNewAddress());
    }

    @GetMapping("/{houseId}")
    public HouseDetailsResponseDto getHouseDetails(@PathVariable String houseId) {
        return housesService.getHouseDetails(houseId);
    }

    @PostMapping("/room")
    public ResponseEntity<RoomResponseDto> addRoomToHouse(@RequestParam String houseId, @RequestBody RoomAdditionRequestDto roomDTO) throws ChangeSetPersister.NotFoundException {
        RoomResponseDto responseDto = housesService.addRoomToHouse(houseId, roomDTO);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
