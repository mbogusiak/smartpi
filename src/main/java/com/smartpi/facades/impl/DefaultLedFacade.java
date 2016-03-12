package com.smartpi.facades.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.smartpi.facades.LedFacade;
import com.smartpi.services.LedService;

@Component
public class DefaultLedFacade implements LedFacade {

	@Resource(name = "defaultLedService")
	private LedService ledDriver;

	@Override
	public void setErrorLed() throws InterruptedException {

		ledDriver.blinkLed("red");
		ledDriver.blinkLedOff("green");
		ledDriver.blinkLedOff("orange");
		ledDriver.turnLedOff("green");
		ledDriver.turnLedOff("orange");
	}

	@Override
	public void setOkLed() throws InterruptedException {
		ledDriver.blinkLed("green");
		ledDriver.blinkLedOff("red");
		ledDriver.blinkLedOff("orange");
		ledDriver.turnLedOff("red");
		ledDriver.turnLedOff("orange");
	}

	@Override
	public void setWarningLed() throws InterruptedException {
		ledDriver.blinkLed("orange");
		ledDriver.blinkLedOff("green");
		ledDriver.blinkLedOff("red");
		ledDriver.turnLedOff("green");
		ledDriver.turnLedOff("red");
	}

	@Override
	public void blinkLed() {
		// TODO Auto-generated method stub

	}
}
