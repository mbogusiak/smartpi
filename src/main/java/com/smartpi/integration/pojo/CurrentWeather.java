package com.smartpi.integration.pojo;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@XmlRootElement(name = "CurrentWeather")
@XmlAccessorType(XmlAccessType.FIELD)
@Document(collection = "currentWeather")
public class CurrentWeather {

	@Id
	private String id;
	@XmlElement(name = "Status")
	@Field("status")
	private String status;
	@Field("time")
	@XmlElement(name = "Time")
	@XmlSchemaType(name = "date")
	private Date time;
	@XmlElement(name = "RelativeHumidity")
	private String relativeHumidity;
	@XmlElement(name = "Temperature")
	private int temperature;
	@XmlElement(name = "Location")
	private String location;
	@XmlElement(name = "SkyConditions")
	private String skyConditions;
	@XmlElement(name = "DewPoint")
	private String dewPoint;
	@XmlElement(name = "Visibility")
	private String visibility;
	@XmlElement(name = "Pressure")
	private String pressure;
	@XmlElement(name = "Wind")
	private String wind;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(final String Status) {
		this.status = Status;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(final Date Time) {
		this.time = Time;
	}

	public String getRelativeHumidity() {
		return relativeHumidity;
	}

	public void setRelativeHumidity(final String RelativeHumidity) {
		this.relativeHumidity = RelativeHumidity;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(final int Temperature) {
		this.temperature = Temperature;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(final String Location) {
		this.location = Location;
	}

	public String getSkyConditions() {
		return skyConditions;
	}

	public void setSkyConditions(final String SkyConditions) {
		this.skyConditions = SkyConditions;
	}

	public String getDewPoint() {
		return dewPoint;
	}

	public void setDewPoint(final String DewPoint) {
		this.dewPoint = DewPoint;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(final String Visibility) {
		this.visibility = Visibility;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(final String Pressure) {
		this.pressure = Pressure;
	}

	public String getWind() {
		return wind;
	}

	public void setWind(final String Wind) {
		this.wind = Wind;
	}

	@Override
	public String toString() {
		return "ClassPojo [Status = " + status + ", Time = " + time
				+ ", RelativeHumidity = " + relativeHumidity
				+ ", Temperature = " + temperature + ", Location = " + location
				+ ", SkyConditions = " + skyConditions + ", DewPoint = "
				+ dewPoint + ", Visibility = " + visibility + ", Pressure = "
				+ pressure + ", Wind = " + wind + "]";
	}
}