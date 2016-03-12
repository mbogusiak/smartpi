package com.smartpi.facades.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.smartpi.facades.WeatherFacade;
import com.smartpi.integration.pojo.CurrentWeather;
import com.smartpi.services.WeatherService;

@Component
public class DefaultWeatherFacade implements WeatherFacade {

	@Resource
	private WeatherService weatherService;

	@Override
	public List<CurrentWeather> getAllWeatherProbes() {
		return getWeatherService().getAllTWeatherProbes();
	}

	public WeatherService getWeatherService() {
		return weatherService;
	}

	public void setWeatherService(final WeatherService weatherService) {
		this.weatherService = weatherService;
	}

}
