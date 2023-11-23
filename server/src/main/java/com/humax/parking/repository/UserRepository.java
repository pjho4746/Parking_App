package com.humax.parking.repository;

import com.humax.parking.dto.ParkingDTO;
import com.humax.parking.model.ParkingEntity;
import com.humax.parking.model.QParkingEntity;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.PersistenceContext;

import static com.humax.parking.model.QParkingEntity.parkingEntity;

@Repository
public class UserRepository {

    private final EntityManager em;

    private final JPAQueryFactory queryFactory;

    public UserRepository(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    public List<ParkingEntity> findNearbyParking(double userLon, double userLat, int maxDistance) {
        QParkingEntity parkingEntity = QParkingEntity.parkingEntity;

        return queryFactory
                .selectFrom(parkingEntity)
                .where(Expressions.numberTemplate(Double.class,
                                "FUNCTION('ST_Distance_Sphere', FUNCTION('POINT', {0}, {1}), FUNCTION('POINT', {2}, {3}))",
                                parkingEntity.lon, parkingEntity.lat, userLon, userLat)
                        .loe(maxDistance))
                .orderBy(Expressions.numberTemplate(Double.class,
                        "FUNCTION('ST_Distance_Sphere', FUNCTION('POINT', {0}, {1}), FUNCTION('POINT', {2}, {3}))",
                        parkingEntity.lon, parkingEntity.lat, userLon, userLat).asc())
                .fetch();
    }


}



