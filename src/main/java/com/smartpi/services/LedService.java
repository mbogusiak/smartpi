package com.smartpi.services;

public interface LedService {
	void turnLedOff(String name);

	void turnLedOn(String name);

	void blinkLed(String name);

	void blinkLedOff(String name);
}
