package com.wise_neosco.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wise_neosco.dto.OpenWeatherApiResponse;
import com.wise_neosco.exception.WeatherServiceException;
import com.wise_neosco.model.HourlyForecast;
import com.wise_neosco.model.WeatherAlert;
import com.wise_neosco.model.WeatherData;
import com.wise_neosco.repo.WeatherDataRepository;

@Service
public class WeatherService {

    @Value("${openweather.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;
    private final WeatherDataRepository weatherDataRepository;

    public WeatherService(RestTemplate restTemplate, WeatherDataRepository weatherDataRepository) {
        this.restTemplate = restTemplate;
        this.weatherDataRepository = weatherDataRepository;
    }

    
    public HourlyForecast getHourlyForecast(String city) {
        String apiUrl = "https://api.openweathermap.org/data/2.5/forecast";
        String url = String.format("%s?q=%s&appid=%s", apiUrl, city, apiKey);

        OpenWeatherApiResponse response = restTemplate.getForObject(url, OpenWeatherApiResponse.class);

        if (response != null && response.getList() != null) {
            List<HourlyForecast.HourlyData> hourlyDataList = response.getList().stream()
                    .map(hourly -> new HourlyForecast.HourlyData(
                            hourly.getDt_txt(),
                            hourly.getMain().getTemp(),
                            hourly.getWeather().get(0).getDescription()))
                    .collect(Collectors.toList());

            return new HourlyForecast(city, hourlyDataList);
        }

        return null; // Handle appropriately if data is not available
    }
    
    
    
    public WeatherData getWeatherData(String city) {
        try {
            Optional<WeatherData> cachedData = weatherDataRepository.findByCityAndTimestampAfter(city, LocalDateTime.now().minusMinutes(30));

            if (cachedData.isPresent()) {
                return cachedData.get();
            } else {
                WeatherData newWeatherData = getCurrentWeather(city);
                newWeatherData.setTimestamp(LocalDateTime.now());
                weatherDataRepository.save(newWeatherData);
                return newWeatherData;
            }
        } catch (Exception e) {
            // Log the exception
            throw new WeatherServiceException("Error getting weather data", e);
        }
    }
    
    public List<WeatherAlert> getWeatherAlerts(String city) {
        try {
            // Make API call to get weather alerts
            // ...

            // For demonstration purposes, we'll create dummy alerts
            return List.of(
                    new WeatherAlert("Severe Thunderstorm Warning", "Take shelter immediately."),
                    new WeatherAlert("Flood Advisory", "Be cautious of flooding in your area.")
            );
        } catch (Exception e) {
            // Log the exception
            throw new WeatherServiceException("Error getting weather alerts", e);
        }
    }

    private WeatherData getCurrentWeather(String city) {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather";
        String url = String.format("%s?q=%s&appid=%s", apiUrl, city, apiKey);

        return restTemplate.getForObject(url, WeatherData.class);
    }
}

