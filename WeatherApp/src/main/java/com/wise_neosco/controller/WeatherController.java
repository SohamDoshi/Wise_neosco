package com.wise_neosco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wise_neosco.model.HourlyForecast;
import com.wise_neosco.model.WeatherData;
import com.wise_neosco.service.WeatherService;

@Controller
public class WeatherController {

	@Autowired
    private WeatherService weatherService;

	 @GetMapping("/")
	    public String index() {
	        return "index"; // Thymeleaf template name (index.html)
	    }

	    @GetMapping("/weather")
	    public String getWeather(@RequestParam String city, Model model) {
	        WeatherData weatherData = weatherService.getWeatherData(city);
	        model.addAttribute("weatherData", weatherData);

	        // Fetch hourly forecast data
	        HourlyForecast hourlyForecast = weatherService.getHourlyForecast(city);
	        model.addAttribute("hourlyForecast", hourlyForecast);

	        return "weather"; // Thymeleaf template name (weather.html)
	    }
	    
	    @GetMapping("/search")
	    public String searchWeather(@RequestParam String city, Model model) {
	        WeatherData weatherData = weatherService.getWeatherData(city);
	        model.addAttribute("weatherData", weatherData);

	        // Fetch hourly forecast data
	        HourlyForecast hourlyForecast = weatherService.getHourlyForecast(city);
	        model.addAttribute("hourlyForecast", hourlyForecast);

	        return "weather"; // Thymeleaf template name (weather.html)
	    }
}

