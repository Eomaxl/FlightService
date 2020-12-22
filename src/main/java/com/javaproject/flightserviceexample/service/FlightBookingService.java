package com.javaproject.flightserviceexample.service;

import com.javaproject.flightserviceexample.dto.FlightBookingAcknowledgement;
import com.javaproject.flightserviceexample.dto.FlightBookingRequest;
import com.javaproject.flightserviceexample.entity.PassengerInfo;
import com.javaproject.flightserviceexample.entity.PaymentInfo;
import com.javaproject.flightserviceexample.repository.PassengerInfoRepository;
import com.javaproject.flightserviceexample.repository.PaymentInfoRepository;
import com.javaproject.flightserviceexample.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class FlightBookingService {
    @Autowired
    private PassengerInfoRepository passengerInfoRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request){
       FlightBookingAcknowledgement acknowledgement = null;

        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfo = passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(),passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPid());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);
        return new FlightBookingAcknowledgement("SUCCESS",passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0],passengerInfo);
    }
}
