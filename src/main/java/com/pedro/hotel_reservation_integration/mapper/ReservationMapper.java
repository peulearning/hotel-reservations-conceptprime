package com.pedro.hotel_reservation_integration.mapper;

import com.pedro.hotel_reservation_integration.dto.ReservationRequest;
import com.pedro.hotel_reservation_integration.dto.ReservationResponse;
import com.pedro.hotel_reservation_integration.entity.Reservation;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    Reservation toEntity(ReservationRequest request);

    ReservationResponse toResponse(Reservation reservation);

    List<ReservationResponse> toResponseList(List<Reservation> reservations);
}