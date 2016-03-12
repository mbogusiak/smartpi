package com.smartpi.pojo;

import com.pi4j.io.gpio.GpioPinDigitalOutput;

public class PiLed {

	private String name;
	private int pinNr;
	private GpioPinDigitalOutput gpio;

	public PiLed(final String name, final int pinNr) {
		this.setName(name);
		this.setPinNr(pinNr);
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public int getPinNr() {
		return pinNr;
	}

	public void setPinNr(final int pinNr) {
		this.pinNr = pinNr;
	}

	public GpioPinDigitalOutput getGpio() {
		return gpio;
	}

	public void setGpio(final GpioPinDigitalOutput gpio) {
		this.gpio = gpio;
	}

}
