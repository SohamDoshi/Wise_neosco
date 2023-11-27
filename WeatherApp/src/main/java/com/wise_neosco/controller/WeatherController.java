package com.wise_neosco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.wise_neosco.model.HourlyForecast;
import com.wise_neosco.model.WeatherData;
import com.wise_neosco.service.WeatherService;


@Controller
public class WeatherController {

    private final WeatherService weatherService;
    

    
    
    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

	 @GetMapping("/")
	    public String index() {
	        return "index"; // Thymeleaf template name (index.html)
	    }

//	 @GetMapping("/weather/{cityId}")
//	    public String getWeather(@PathVariable Long cityId, Model model) {
//	        HourlyForecast hourlyForecast = weatherService.getHourlyForecast(cityId);
//
//	        if (hourlyForecast != null) {
//	            model.addAttribute("hourlyForecast", hourlyForecast);
//	            System.out.println(hourlyForecast);
//	            return "weather";
//	        } else {
//	            // Handle appropriately if data is not available
//	            return "error"; // Create an error.html template
//	        }
//	    }
	    
	    @GetMapping("/search")
	    public String searchWeather(@RequestParam String city, Model model) {
	        WeatherData weatherData = weatherService.getWeatherData(city);
	        model.addAttribute("weatherData", weatherData);

	        // Fetch hourly forecast data
	        HourlyForecast hourlyForecast = weatherService.getHourlyForecast(weatherData.getCityId());
	        model.addAttribute("hourlyForecast", hourlyForecast);

	        //System.out.println(hourlyForecast);
	        return "weather"; // Thymeleaf template name (weather.html)
	    }
}

