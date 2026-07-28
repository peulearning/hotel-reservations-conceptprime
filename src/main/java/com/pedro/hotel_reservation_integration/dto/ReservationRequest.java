package com.pedro.hotel_reservation_integration.dto;

import  com.pedro.hotel_reservation_integration.entity.enums.ReservationStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationRequest {

    @NotBlank
    private String reservationId;

    @NotNull
    private Long hotelId;

    @NotBlank
    private String guestName;

    @NotNull
    private ReservationStatus status;

    @NotNull
    private LocalDate checkIn;

    @NotNull
    private LocalDate checkOut;

}