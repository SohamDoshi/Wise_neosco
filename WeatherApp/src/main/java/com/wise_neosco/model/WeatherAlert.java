package com.wise_neosco.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherAlert {

    private String title;
    private String description;

    // Constructors, getters, and setters
}