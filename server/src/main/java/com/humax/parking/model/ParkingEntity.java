package com.humax.parking.model;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Builder
@Data
@Setter
@Table(name = "parking_data")
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "delete_flag=0 OR delete_flag IS NULL")
public class ParkingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_id", nullable = false, unique = true)
    private Long parkingId;

    @Column(name = "code_number", nullable = false, unique = true)
    private String codeNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "lat")
    private String lat;

    @Column(name = "lon")
    private String lon;

    @Column(name = "operating_time")
    private String operatingTime;

    @Column(name = "normal_season")
    private String normalSeason;

    @Column(name = "tenant_season")
    private String tenantSeason;

    @Column(name = "time_ticket")
    private String timeTicket;

    @Column(name = "day_ticket")
    private String dayTicket;

    @Column(name = "special_day")
    private String specialDay;

    @Column(name = "special_hour")
    private String specialHour;

    @Column(name = "special_night")
    private String specialNight;

    @Column(name = "special_weekend")
    private String specialWeekend;

    @Column(name = "apply_day")
    private String applyDay;

    @Column(name = "apply_hour")
    private String applyHour;

    @Column(name = "apply_night")
    private String applyNight;

    @Column(name = "apply_weekend")
    private String applyWeekend;

    @Column(name = "is_active")
    private Integer isActive;

    @Column(name = "operation")
    private String operation;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @Column(name = "deleted_at")
    private String deletedAt;

    @Column(name = "time")
    private String time;

    @Column(name = "price")
    private String price;

    @Column(name="delete_flag")
    @ColumnDefault("0")
    private Boolean deleteYn;

}
