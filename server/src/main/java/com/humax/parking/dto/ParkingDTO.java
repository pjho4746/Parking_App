package com.humax.parking.dto;

import com.humax.parking.model.ParkingEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkingDTO {
    private Long parkingId;
    private String codeNumber;
    private String name;
    private String address;
    private String lat;
    private String lon;
    private String operatingTime;
    private String normalSeason;
    private String tenantSeason;
    private String timeTicket;
    private String dayTicket;
    private String specialDay;
    private String specialHour;
    private String specialNight;
    private String specialWeekend;
    private String applyDay;
    private String applyHour;
    private String applyNight;
    private String applyWeekend;
    private Integer isActive;
    private String operation;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
    private String time;
    private String price;
    private Boolean deleteYn;


    public ParkingDTO(final ParkingEntity entity){
        this.parkingId = entity.getParkingId();
        this.codeNumber = entity.getCodeNumber();
        this.name = entity.getName();
        this.address = entity.getAddress();
        this.lat = entity.getLat();
        this.lon = entity.getLon();
        this.operatingTime = entity.getOperatingTime();
        this.normalSeason = entity.getNormalSeason();
        this.tenantSeason = entity.getTenantSeason();
        this.timeTicket = entity.getTimeTicket();
        this.dayTicket = entity.getDayTicket();
        this.specialDay = entity.getSpecialDay();
        this.specialHour = entity.getSpecialHour();
        this.specialNight = entity.getSpecialNight();
        this.specialWeekend = entity.getSpecialWeekend();
        this.applyDay = entity.getApplyDay();
        this.applyHour = entity.getApplyHour();
        this.applyNight = entity.getApplyNight();
        this.applyWeekend = entity.getApplyWeekend();
        this.isActive = entity.getIsActive();
        this.operation = entity.getOperation();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
        this.deletedAt = entity.getDeletedAt();
        this.time = entity.getTime();
        this.price = entity.getPrice();
        this.deleteYn = false;
    }

    public ParkingEntity toEntity(){
        return ParkingEntity.builder()
                .parkingId(parkingId)
                .codeNumber(codeNumber)
                .name(name)
                .address(address)
                .lat(lat)
                .lon(lon)
                .operatingTime(operatingTime)
                .normalSeason(normalSeason)
                .tenantSeason(tenantSeason)
                .timeTicket(timeTicket)
                .dayTicket(dayTicket)
                .specialDay(specialDay)
                .specialHour(specialHour)
                .specialNight(specialNight)
                .specialWeekend(specialWeekend)
                .applyHour(applyHour)
                .applyNight(applyNight)
                .applyWeekend(applyWeekend)
                .isActive(isActive)
                .operation(operation)
                .createdAt(createdAt)
                .deletedAt(deletedAt)
                .time(time)
                .price(price)
                .deleteYn(false)
                .build();
    }


}
