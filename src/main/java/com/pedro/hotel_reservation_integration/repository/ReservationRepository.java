package com.pedro.hotel_reservation_integration.repository;

import com.pedro.hotel_reservation_integration.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Optional<Reservation> findByReservationId(String reservationId);

    boolean existsByReservationId(String reservationId);

}
