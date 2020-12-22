package com.javaproject.flightserviceexample.repository;

import com.javaproject.flightserviceexample.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, Long> {
}
