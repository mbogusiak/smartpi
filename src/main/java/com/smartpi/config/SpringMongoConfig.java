package com.smartpi.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration {

	@Resource
	private ConnectionSettings mongoConnectionSettings;

	public ConnectionSettings getMongoConnectionSettings() {
		return mongoConnectionSettings;
	}

	public void setMongoConnectionSettings(
			final ConnectionSettings mongoConnectionSettings) {
		this.mongoConnectionSettings = mongoConnectionSettings;
	}

	@Override
	public String getDatabaseName() {
		return "pihomedb";
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		System.out.println(
				"we have " + getMongoConnectionSettings().getRemoteAddress());
		return new MongoClient(getMongoConnectionSettings()	.getRemoteAddress()
															.getHostAddress());
	}

	@Override
	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(mongo(), getDatabaseName());
	}
}