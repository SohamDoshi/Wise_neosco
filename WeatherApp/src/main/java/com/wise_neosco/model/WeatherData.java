package com.wise_neosco.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
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
    private Integer pressure;

    @Column(nullable = false)
    private Integer humidity;

    @Column(nullable = false)
    private String weatherDescription;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    public WeatherData() {
        // Default constructor needed for JPA
    }

    public WeatherData(String city, Double temperature, Integer pressure, Integer humidity, String weatherDescription) {
        this.city = city;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.weatherDescription = weatherDescription;
    }

    // getters and setters
}

