package com.pedro.hotel_reservation_integration.scheduler;

import com.pedro.hotel_reservation_integration.dto.ReservationRequest;
import com.pedro.hotel_reservation_integration.integration.OmnibeesClient;
import com.pedro.hotel_reservation_integration.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReservationScheduler {

    private final OmnibeesClient omnibeesClient;
    private final ReservationService reservationService;

    @Scheduled(fixedDelayString = "${reservation.scheduler.delay}")
    public void processReservations() {

        log.info("Starting reservation polling...");

        List<ReservationRequest> reservations =
                omnibeesClient.getReservations();

        reservations.forEach(reservationService::save);

        log.info("{} reservations processed.", reservations.size());
    }

}