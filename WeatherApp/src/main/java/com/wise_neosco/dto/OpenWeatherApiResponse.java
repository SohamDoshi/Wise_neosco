package com.wise_neosco.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenWeatherApiResponse {

    private List<OpenWeatherApiHourlyData> list;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OpenWeatherApiHourlyData {
        private String dt_txt;
        private OpenWeatherApiMain main;
        private List<OpenWeatherApiWeather> weather;

        // Constructors, getters, and setters
    }
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OpenWeatherApiMain {
        private Double temp;

        // Constructors, getters, and setters
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OpenWeatherApiWeather {
        private String description;

        // Constructors, getters, and setters
    }
}

