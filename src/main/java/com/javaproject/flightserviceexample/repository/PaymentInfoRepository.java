package com.javaproject.flightserviceexample.repository;

import com.javaproject.flightserviceexample.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String> {
}
