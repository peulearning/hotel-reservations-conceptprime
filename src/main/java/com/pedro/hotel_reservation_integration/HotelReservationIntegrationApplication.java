package com.pedro.hotel_reservation_integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HotelReservationIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelReservationIntegrationApplication.class, args);
	}

}
