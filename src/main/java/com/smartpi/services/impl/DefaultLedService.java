package com.smartpi.services.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.Pin;
import com.smartpi.pojo.PiLed;
import com.smartpi.services.LedService;

@Component("defaultLedService")
@Profile("production")
public class DefaultLedService implements LedService {

	@Resource
	private final GpioController gpioController = null;

	@Resource(name = "piLeds")
	private Map<String, PiLed> piLeds;

	@Resource(name = "piMap")
	private Map<Integer, Pin> pinsMap;

	private final Logger log = Logger.getLogger(
			DefaultLedService.class.getName());

	public void turnLedOff(final String name) {
		final PiLed piLed = piLeds.get(name);
		tryTurnLedOff(piLed);
	}

	private void tryTurnLedOff(final PiLed piLed) {
		try {
			piLed.getGpio().low();
		} catch (final Exception exc) {
			log.error("There was problem turning led off " + piLed.getName()
					+ " " + exc);
		}
	}

	public void turnLedOn(final String name) {
		final PiLed piLed = piLeds.get(name);
		tryTurnLedOn(piLed);
	}

	private void tryTurnLedOn(final PiLed piLed) {
		try {
			piLed.getGpio().high();
		} catch (final Exception exc) {
			log.error("There was problem turning led on " + piLed.getName()
					+ " " + exc);
		}
	}

	public void blinkLed(final String name) {
		final PiLed piLed = piLeds.get(name);
		tryBlinkLed(piLed);
	}

	private void tryBlinkLed(final PiLed piLed) {
		try {
			piLed.getGpio().blink(1000);
		} catch (final Exception exc) {
			log.error("There was problem blinking led" + piLed.getName() + " "
					+ exc);
		}
	}

	public void blinkLedOff(final String name) {
		final PiLed piLed = piLeds.get(name);
		tryBlinkLedOff(piLed);
	}

	private void tryBlinkLedOff(final PiLed piLed) {
		try {
			piLed.getGpio().blink(0);
		} catch (final Exception exc) {
			log.error("There was problem blinking led" + piLed.getName() + " "
					+ exc);
		}
	}

	public Map<String, PiLed> getPiLeds() {
		return piLeds;
	}

	public void setPiLeds(final Map<String, PiLed> piLeds) {
		this.piLeds = piLeds;
	}

	public Map<Integer, Pin> getPinsMap() {
		return pinsMap;
	}

	public void setPinsMap(final Map<Integer, Pin> pinsMap) {
		this.pinsMap = pinsMap;
	}
}
