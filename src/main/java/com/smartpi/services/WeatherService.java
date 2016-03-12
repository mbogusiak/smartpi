package com.smartpi.services;

import java.util.List;

import com.smartpi.integration.pojo.CurrentWeather;

public interface WeatherService {
	List<CurrentWeather> getAllTWeatherProbes();
}
