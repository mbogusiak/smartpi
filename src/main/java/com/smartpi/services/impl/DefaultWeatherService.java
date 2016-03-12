package com.smartpi.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.smartpi.dao.WeatherDao;
import com.smartpi.integration.pojo.CurrentWeather;
import com.smartpi.services.WeatherService;

@Component
public class DefaultWeatherService implements WeatherService {

	@Resource
	private WeatherDao weatherDao;

	@Override
	public List<CurrentWeather> getAllTWeatherProbes() {
		return getWeatherDao().getAllWeatherProbes();
	}

	public WeatherDao getWeatherDao() {
		return weatherDao;
	}

	public void setWeatherDao(final WeatherDao weatherDao) {
		this.weatherDao = weatherDao;
	}
}
