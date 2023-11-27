package com.wise_neosco.model;

import java.util.List;

import com.wise_neosco.dto.OpenWeatherApiResponse.OpenWeatherApiHourlyData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HourlyForecast {
    private String city;
    private List<HourlyData> hourlyData;

    @Data
    @NoArgsConstructor
    public static class HourlyData {
        private String dttxt;  // Corrected property name
        private Double temperature;
        private String weatherDescription;


        public HourlyData(String dttxt, Double temperature, String weatherDescription) {
            this.dttxt = dttxt;
            this.temperature = temperature;
            this.weatherDescription = weatherDescription;
        }
    }
}
