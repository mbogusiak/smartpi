package com.smartpi.integration.weather;

import org.springframework.messaging.Message;

import net.webservicex.GetWeatherResponse;

public class WeatherTransformer {

	public String transform(final Message<GetWeatherResponse> payload) {
		final GetWeatherResponse response = payload.getPayload();
		return response.getGetWeatherResult();
	}
}
