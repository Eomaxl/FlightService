package com.javaproject.flightserviceexample;

import com.javaproject.flightserviceexample.dto.FlightBookingAcknowledgement;
import com.javaproject.flightserviceexample.dto.FlightBookingRequest;
import com.javaproject.flightserviceexample.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class FlightServiceExampleApplication {

	@Autowired
	private FlightBookingService service;

	@PostMapping("/bookFlightTicket")
	public FlightBookingAcknowledgement bookFLightTicket(@RequestBody FlightBookingRequest request) {
		return  service.bookFlightTicket(request);
	}

	public static void main(String[] args) {
		SpringApplication.run(FlightServiceExampleApplication.class, args);
	}

}
