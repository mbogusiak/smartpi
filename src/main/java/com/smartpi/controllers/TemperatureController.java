package com.smartpi.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smartpi.facades.WeatherFacade;
import com.smartpi.integration.pojo.CurrentWeather;

@Controller
public class TemperatureController {

	@Resource
	private WeatherFacade weatherFacade;

	@RequestMapping("/getTemperatures")
	@ResponseBody
	public Map<Object, Object> getAllTemperatures() {
		final Map<Object, Object> temperatureData = populateTemperaturesData();
		return temperatureData;
	}

	// TODO refactor asap
	private Map<Object, Object> populateTemperaturesData() {
		final List<CurrentWeather> weatherProbes = getWeatherFacade().getAllWeatherProbes();
		final HashMap<Object, Object> data = new HashMap<>();

		final List<String> lab = new ArrayList<>();
		final List<Integer> dat = new ArrayList<>();
		for (final CurrentWeather currentWeather : weatherProbes) {
			final SimpleDateFormat sf = new SimpleDateFormat("EEE d MMM ");
			lab.add(sf.format(currentWeather.getTime()));
			dat.add(currentWeather.getTemperature());
		}
		final Integer[][] temps1 = new Integer[1][1];
		temps1[0] = dat.toArray(new Integer[dat.size()]);
		data.put("labels", lab.toArray());
		data.put("data", temps1);
		return data;
	}

	public WeatherFacade getWeatherFacade() {
		return weatherFacade;
	}

	public void setWeatherFacade(final WeatherFacade weatherFacade) {
		this.weatherFacade = weatherFacade;
	}

}