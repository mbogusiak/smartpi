package com.smartpi.facades;

import java.util.List;

import com.smartpi.integration.pojo.CurrentWeather;

public interface WeatherFacade {
	List<CurrentWeather> getAllWeatherProbes();
}
