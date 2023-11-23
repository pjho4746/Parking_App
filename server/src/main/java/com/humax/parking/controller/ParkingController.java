package com.humax.parking.controller;

import com.humax.parking.dto.ParkingDTO;
import com.humax.parking.model.ParkingEntity;
import com.humax.parking.repository.ParkingRepository;
import com.humax.parking.service.ParkingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/parking")
@RequiredArgsConstructor
public class ParkingController {
    private final ParkingService parkingService;

    private final ParkingRepository parkingRepository;

    @PostMapping("/create")
    public ResponseEntity<String> createParkingInfo(@RequestBody ParkingDTO parkingDTO) {
        parkingService.createParkingInfo(parkingDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("성공적으로 추가되었습니다.");
    }

    @GetMapping("/read/list")
    public ResponseEntity<List<ParkingDTO>> getParkingInfo(){
        return ResponseEntity.status(HttpStatus.OK).body(parkingService.getParkingInfo());
    }

    @GetMapping("/read/detail/{parking_id}")
    public ResponseEntity<ParkingDTO> getParkingDetail(@PathVariable Long parking_id){
        return ResponseEntity.status(HttpStatus.OK).body(parkingService.getParkingDetail(parking_id));
    }

    @PatchMapping("/update")
    public ResponseEntity<ParkingDTO> updateParking(@RequestBody ParkingDTO parkingDTO){
        ParkingEntity existingParking = parkingRepository.findByParkingId(parkingDTO.getParkingId()).orElse(null);
        if(existingParking != null){
            parkingService.updateParkingInfo(existingParking, parkingDTO);
            return new ResponseEntity<>(new ParkingDTO(parkingRepository.save(existingParking)), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{parking_id}")
    public ResponseEntity<String> deleteParking(@PathVariable Long parking_id) {
        parkingService.deleteParking(parking_id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("삭제되었습니다.");
    }
}


