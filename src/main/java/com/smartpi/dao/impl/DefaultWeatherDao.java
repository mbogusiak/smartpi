package com.smartpi.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import com.smartpi.dao.WeatherDao;
import com.smartpi.integration.pojo.CurrentWeather;

@Component
public class DefaultWeatherDao implements WeatherDao {

	@Resource(name = "mongoTemplate")
	private MongoOperations mongoOperation;

	@Override
	public List<CurrentWeather> getAllWeatherProbes() {
		final List<CurrentWeather> weatherProbes = mongoOperation.findAll(
				CurrentWeather.class);
		return weatherProbes;
	}

	public MongoOperations getMongoOperation() {
		return mongoOperation;
	}

	public void setMongoOperation(final MongoOperations mongoOperation) {
		this.mongoOperation = mongoOperation;
	}

}
