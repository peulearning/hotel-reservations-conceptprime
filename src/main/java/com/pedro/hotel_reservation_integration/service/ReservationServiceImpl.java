package com.pedro.hotel_reservation_integration.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.pedro.hotel_reservation_integration.exception.ResourceNotFoundException;


import org.springframework.stereotype.Service;
import com.pedro.hotel_reservation_integration.dto.ReservationRequest;
import com.pedro.hotel_reservation_integration.dto.ReservationResponse;
import com.pedro.hotel_reservation_integration.entity.Reservation;
import com.pedro.hotel_reservation_integration.entity.enums.ReservationStatus;
import com.pedro.hotel_reservation_integration.mapper.ReservationMapper;
import com.pedro.hotel_reservation_integration.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;
    private final ReservationMapper mapper;

    @Override
    public ReservationResponse save(ReservationRequest request) {

        Optional<Reservation> existingReservation =
                repository.findByReservationId(request.getReservationId());

        if (existingReservation.isEmpty()) {
            return createReservation(request);
        }

        Reservation reservation = existingReservation.get();

        if (request.getStatus() == ReservationStatus.CANCELLED) {
            return cancelReservation(reservation);
        }

        return updateReservation(reservation, request);
    }

    @Override
    public List<ReservationResponse> findAll() {

        List<Reservation> reservations = repository.findAll();

        return mapper.toResponseList(reservations);
    }

   @Override
    public ReservationResponse findByReservationId(String reservationId) {

        Reservation reservation = repository
                .findByReservationId(reservationId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Reservation not found."));

        return mapper.toResponse(reservation);
    }

    @Override
    public void cancel(String reservationId) {

        Reservation reservation = repository
                .findByReservationId(reservationId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Reservation not found."));

        cancelReservation(reservation);
    }

    private ReservationResponse createReservation(ReservationRequest request) {

        Reservation reservation = mapper.toEntity(request);

        reservation.setCreatedAt(LocalDateTime.now());

        Reservation savedReservation = repository.save(reservation);

        return mapper.toResponse(savedReservation);
    }

    private ReservationResponse updateReservation(
        Reservation reservation,
        ReservationRequest request) {

        reservation.setHotelId(request.getHotelId());
        reservation.setGuestName(request.getGuestName());
        reservation.setStatus(request.getStatus());
        reservation.setCheckIn(request.getCheckIn());
        reservation.setCheckOut(request.getCheckOut());

        reservation.setUpdatedAt(LocalDateTime.now());

        Reservation updatedReservation = repository.save(reservation);

        return mapper.toResponse(updatedReservation);
    }

    private ReservationResponse cancelReservation(
        Reservation reservation) {

        reservation.setStatus(ReservationStatus.CANCELLED);
        reservation.setCancelDate(LocalDateTime.now());
        reservation.setUpdatedAt(LocalDateTime.now());

        Reservation cancelledReservation = repository.save(reservation);

        return mapper.toResponse(cancelledReservation);
    }

}