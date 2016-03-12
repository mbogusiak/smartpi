package com.smartpi.config;

import java.net.InetAddress;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mongodb")
public class ConnectionSettings {
	private InetAddress remoteAddress;

	public InetAddress getRemoteAddress() {
		return remoteAddress;
	}

	public void setRemoteAddress(final InetAddress remoteAddress) {
		this.remoteAddress = remoteAddress;
	}
}
