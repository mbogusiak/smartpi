package com.smartpi.services.impl;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.smartpi.services.LedService;

@Component("defaultLedService")
@Profile("development")
public class DefaultLedServiceDev implements LedService {

	private final Logger log = Logger.getLogger(
			DefaultLedServiceDev.class.getName());

	public void turnLedOff(final String name) {
		System.out.println("Turn " + name + "led off");
	}

	public void turnLedOn(final String name) {
		System.out.println("Turn " + name + "led on");
	}

	public void blinkLed(final String name) {
		System.out.println("Blink " + name + "led");
	}

	public void blinkLedOff(final String name) {
		System.out.println("Blink " + name + "off");
	}
}
