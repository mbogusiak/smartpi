package com.smartpi.facades;

public interface LedFacade {
	void setErrorLed() throws InterruptedException;

	void setOkLed() throws InterruptedException;;

	void setWarningLed() throws InterruptedException;;

	void blinkLed();
}
