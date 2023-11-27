package com.wise_neosco.repo;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wise_neosco.model.WeatherData;

public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {

    Optional<WeatherData> findByCityAndTimestampAfter(String city, LocalDateTime timestamp);
}

