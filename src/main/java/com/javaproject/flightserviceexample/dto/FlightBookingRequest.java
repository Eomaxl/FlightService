package com.javaproject.flightserviceexample.dto;

import com.javaproject.flightserviceexample.entity.PassengerInfo;
import com.javaproject.flightserviceexample.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {
    private PassengerInfo passengerInfo;
    private PaymentInfo paymentInfo;
}
