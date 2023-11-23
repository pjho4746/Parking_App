package com.humax.parking.repository;

import com.humax.parking.model.ParkingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParkingRepository extends JpaRepository<ParkingEntity, Long> {
    Optional<ParkingEntity> findByParkingId(Long parkingId);

    ParkingEntity findByCodeNumber(String codeNum);

    @Override
    List<ParkingEntity> findAll();
}
