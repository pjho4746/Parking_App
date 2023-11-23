package com.humax.parking.controller;


import com.humax.parking.dto.*;
import com.humax.parking.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/search")
    public ResponseEntity<List<ParkingDTO>> getNearParking(@RequestBody UserLocationDTO userLocationDTO){
        try{
            List<ParkingDTO> nearbyParking = userService.findNearbyParking(userLocationDTO);
            return ResponseEntity.status(HttpStatus.OK).body(nearbyParking);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

//    @GetMapping("/detail/{parking_id}")
//    public ResponseEntity<List<ParkingDTO>> getUserParkingDetail(@PathVariable Long parking_id){
//
//    }
//
//    @GetMapping("/calculatefee")
//    public ResponseEntity<String> getUserParkingFee(//사용자 정보, 어느 주차장, 출입시간){
//    }
}
