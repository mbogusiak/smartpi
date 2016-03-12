package com.smartpi.dao;

import java.util.List;

import com.smartpi.integration.pojo.CurrentWeather;

public interface WeatherDao {
	List<CurrentWeather> getAllWeatherProbes();
}
