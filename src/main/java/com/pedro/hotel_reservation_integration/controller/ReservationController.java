package com.pedro.hotel_reservation_integration.controller;

import com.pedro.hotel_reservation_integration.dto.ReservationRequest;
import com.pedro.hotel_reservation_integration.dto.ReservationResponse;
import com.pedro.hotel_reservation_integration.service.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationResponse save(
            @Valid @RequestBody ReservationRequest request) {

        return reservationService.save(request);
    }

    @GetMapping
    public List<ReservationResponse> findAll() {
        return reservationService.findAll();
    }

    @GetMapping("/{reservationId}")
    public ReservationResponse findByReservationId(
            @PathVariable String reservationId) {

        return reservationService.findByReservationId(reservationId);
    }

    @DeleteMapping("/{reservationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancel(@PathVariable String reservationId) {

        reservationService.cancel(reservationId);
    }
}