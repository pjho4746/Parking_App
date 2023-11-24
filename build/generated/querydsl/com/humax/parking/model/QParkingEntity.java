package com.humax.parking.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QParkingEntity is a Querydsl query type for ParkingEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QParkingEntity extends EntityPathBase<ParkingEntity> {

    private static final long serialVersionUID = -1252680964L;

    public static final QParkingEntity parkingEntity = new QParkingEntity("parkingEntity");

    public final StringPath address = createString("address");

    public final StringPath applyDay = createString("applyDay");

    public final StringPath applyHour = createString("applyHour");

    public final StringPath applyNight = createString("applyNight");

    public final StringPath applyWeekend = createString("applyWeekend");

    public final StringPath codeNumber = createString("codeNumber");

    public final StringPath createdAt = createString("createdAt");

    public final StringPath dayTicket = createString("dayTicket");

    public final StringPath deletedAt = createString("deletedAt");

    public final BooleanPath deleteYn = createBoolean("deleteYn");

    public final NumberPath<Integer> isActive = createNumber("isActive", Integer.class);

    public final StringPath lat = createString("lat");

    public final StringPath lon = createString("lon");

    public final StringPath name = createString("name");

    public final StringPath normalSeason = createString("normalSeason");

    public final StringPath operatingTime = createString("operatingTime");

    public final StringPath operation = createString("operation");

    public final NumberPath<Long> parkingId = createNumber("parkingId", Long.class);

    public final StringPath price = createString("price");

    public final StringPath specialDay = createString("specialDay");

    public final StringPath specialHour = createString("specialHour");

    public final StringPath specialNight = createString("specialNight");

    public final StringPath specialWeekend = createString("specialWeekend");

    public final StringPath tenantSeason = createString("tenantSeason");

    public final StringPath time = createString("time");

    public final StringPath timeTicket = createString("timeTicket");

    public final StringPath updatedAt = createString("updatedAt");

    public QParkingEntity(String variable) {
        super(ParkingEntity.class, forVariable(variable));
    }

    public QParkingEntity(Path<? extends ParkingEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QParkingEntity(PathMetadata metadata) {
        super(ParkingEntity.class, metadata);
    }

}

