package com.smartpi.integration.weather;

import org.springframework.integration.annotation.MessagingGateway;

import com.smartpi.integration.pojo.CurrentWeather;

import net.webservicex.GetWeather;

@MessagingGateway(name = "weatherSender", defaultRequestChannel = "weatherInputChannel", defaultReplyChannel = "outputWeatherChannel", defaultReplyTimeout = "3000")
public interface WeatherSender {
	CurrentWeather send(GetWeather request);
}
