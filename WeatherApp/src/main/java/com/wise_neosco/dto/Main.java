package com.wise_neosco.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {
    private Double temp;
    private Double feels_like;
    private Double temp_min;
    private Double temp_max;
    private Integer pressure;
    private Integer humidity;
    private Integer sea_level;
    private Integer grnd_level;

    // getters and setters
}

