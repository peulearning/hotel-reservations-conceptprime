package com.pedro.hotel_reservation_integration.service;

import com.pedro.hotel_reservation_integration.dto.ReservationRequest;
import com.pedro.hotel_reservation_integration.dto.ReservationResponse;

import java.util.List;

public interface ReservationService {

    ReservationResponse save(ReservationRequest request);

    List<ReservationResponse> findAll();

    ReservationResponse findByReservationId(String reservationId);

    void cancel(String reservationId);
}