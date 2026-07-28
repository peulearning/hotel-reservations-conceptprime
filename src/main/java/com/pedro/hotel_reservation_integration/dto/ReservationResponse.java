package com.pedro.hotel_reservation_integration.dto;

import  com.pedro.hotel_reservation_integration.entity.enums.ReservationStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class ReservationResponse {

    private String reservationId;

    private Long hotelId;

    private String guestName;

    private ReservationStatus status;

    private LocalDate checkIn;

    private LocalDate checkOut;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime cancelDate;

}
