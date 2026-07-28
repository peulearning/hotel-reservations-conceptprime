package com.pedro.hotel_reservation_integration.controller;

import com.pedro.hotel_reservation_integration.dto.ReservationRequest;
import com.pedro.hotel_reservation_integration.entity.enums.ReservationStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class MockReservationController {

    @GetMapping("/mock/omnibees/reservations")
    public List<ReservationRequest> getReservations() {

        ReservationRequest reservation = new ReservationRequest();

        reservation.setReservationId("ABC123");
        reservation.setHotelId(1L);
        reservation.setGuestName("João da Silva");
        reservation.setStatus(ReservationStatus.NEW);
        reservation.setCheckIn(LocalDate.of(2026,8,1));
        reservation.setCheckOut(LocalDate.of(2026,8,5));

        return List.of(reservation);
    }

}