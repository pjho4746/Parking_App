package com.humax.parking.service;

import com.humax.parking.dto.ParkingDTO;
import com.humax.parking.dto.UserLocationDTO;
import com.humax.parking.model.ParkingEntity;
import com.humax.parking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<ParkingDTO> findNearbyParking(UserLocationDTO userLocationDTO){
        try{
            double userLatitude = Double.parseDouble(userLocationDTO.getLat());
            double userLongitude = Double.parseDouble(userLocationDTO.getLon());
            int maxDistance = userLocationDTO.getDistance();

            List<ParkingEntity> nearParkingEntities = userRepository.findNearbyParking(
                    userLatitude, userLongitude, maxDistance);

            return mapEntitiesToDTOs(nearParkingEntities);
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("가까운 주차장을 찾지 못했습니다.", e);
        }
    }

    private List<ParkingDTO>mapEntitiesToDTOs(List<ParkingEntity> parkingEntities){
        return parkingEntities.stream()
                .map(ParkingDTO::new)
                .collect(Collectors.toList());
    }
}
