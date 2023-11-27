package com.wise_neosco.model;

import java.time.LocalDateTime;
import java.util.List;

import com.wise_neosco.dto.OpenWeatherApiResponse.OpenWeatherApiHourlyData;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "weather_data")
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Double temperature;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    // Constructors, getters, and setters
}

