package com.pedro.hotel_reservation_integration.integration;

import com.pedro.hotel_reservation_integration.dto.ReservationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OmnibeesClient {

    private final RestClient restClient;

    @Value("${integration.omnibees.url}")
    private String url;

    public List<ReservationRequest> getReservations() {

        return restClient
                .get()
                .uri(url)
                .retrieve()
                .body(new ParameterizedTypeReference<List<ReservationRequest>>() {});
    }

}