package com.smartpi.integration.weather;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.smartpi.facades.LedFacade;
import com.smartpi.integration.pojo.CurrentWeather;

import net.webservicex.GetWeather;

public class ScheduledSender {
	@Autowired
	private LedFacade ledFacade;
	@Autowired
	private WeatherSender weatherSender;
	@Resource(name = "mongoTemplate")
	private MongoOperations mongoOperation;

	public void ask() throws InterruptedException, ParseException {

		final GetWeather getWeatherRequest = new GetWeather();
		getWeatherRequest.setCountryName("Poland");
		getWeatherRequest.setCityName("Wroclaw");
		final CurrentWeather currentWeather = weatherSender.send(
				getWeatherRequest);
		final Integer temperature = currentWeather.getTemperature();
		if (temperature < -5) {
			ledFacade.setErrorLed();

		} else if (temperature < 1) {
			ledFacade.setWarningLed();
		}

		else {
			ledFacade.setOkLed();
		}
		System.out.println(currentWeather);
		mongoOperation.save(currentWeather);
		final List<CurrentWeather> listUser = mongoOperation.findAll(
				CurrentWeather.class);
		System.out.println(" Number of probes = " + listUser.size());
		final DateFormat format = new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
		final Query q = new Query(Criteria.where("Temperature").gt(-10));
		System.out.println(q);
		final List<CurrentWeather> q2s = mongoOperation.find(q,
				CurrentWeather.class);
		System.out.println(q2s.size());

	}
}
