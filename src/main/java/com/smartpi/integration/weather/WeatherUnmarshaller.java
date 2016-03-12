package com.smartpi.integration.weather;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMResult;

import org.springframework.oxm.MarshallingFailureException;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.xml.xpath.XPathExpressionFactory;

import com.smartpi.integration.pojo.CurrentWeather;

import net.sf.saxon.TransformerFactoryImpl;

@SuppressWarnings("restriction")
public class WeatherUnmarshaller implements Unmarshaller {

	@Override
	public boolean supports(final Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object unmarshal(final Source source)
			throws IOException, XmlMappingException {
		final DOMResult result = getTransformedDomResult(source);
		final CurrentWeather currentWeather = buildCurrentWeatherFromXml(
				result);
		return currentWeather;
	}

	private DOMResult getTransformedDomResult(final Source source) {
		DOMResult result = null;
		try {
			final Transformer transformer = new TransformerFactoryImpl().newTransformer();
			result = new DOMResult();
			transformer.transform(source, result);
		} catch (final Exception e) {
			throw new MarshallingFailureException(
					"Failed to unmarshal Response", e);
		}
		return result;
	}

	private CurrentWeather buildCurrentWeatherFromXml(final DOMResult result) {
		final CurrentWeather currentWeather = new CurrentWeather();
		currentWeather.setStatus(getStringValue("Status", result));
		currentWeather.setRelativeHumidity(
				getStringValue("RelativeHumidity", result));
		currentWeather.setLocation(getStringValue("Location", result));
		currentWeather.setSkyConditions(
				getStringValue("SkyConditions", result));
		currentWeather.setDewPoint(getStringValue("DewPoint", result));
		currentWeather.setVisibility(getStringValue("Visibility", result));
		currentWeather.setPressure(getStringValue("Pressure", result));
		currentWeather.setWind(getStringValue("Wind", result));
		currentWeather.setTemperature(getTemperature(result));
		currentWeather.setTime(getTime(result));
		return currentWeather;
	}

	private String getStringValue(final String expression,
			final DOMResult result) {
		final String value = XPathExpressionFactory.createXPathExpression(
				expression).evaluateAsString(result.getNode().getFirstChild());
		return value;
	}

	private Date getTime(final DOMResult result) {
		final String dateStringFromXml = getStringValue("Time", result);
		try {
			return getDateFromXmlString(dateStringFromXml);
		} catch (final ParseException exc) {
			throw new IllegalArgumentException(
					"Failed to get date from xml response");
		}
	}

	private Date getDateFromXmlString(final String dateStringFromXml)
			throws ParseException {
		final String utcDateString = getUtcTimeString(dateStringFromXml);
		final SimpleDateFormat dateFormat = getUtcDateFormat();
		final Date dateToReturn = dateFormat.parse(utcDateString);
		return dateToReturn;
	}

	private String getUtcTimeString(final String twoTimeZonesDateString) {
		final String utcDateString = twoTimeZonesDateString.split(
				"/")[1].trim();
		return utcDateString;
	}

	private SimpleDateFormat getUtcDateFormat() {
		final TimeZone utc = TimeZone.getTimeZone("UTC");
		final SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy.MM.dd HHmm");
		dateFormat.setTimeZone(utc);
		return dateFormat;
	}

	private int getTemperature(final DOMResult result) {
		final String tempStringFromXml = getStringValue("Temperature", result);
		final String celciousTempString = getCelciousTemperature(
				tempStringFromXml);
		return Integer.parseInt(celciousTempString);
	}

	private String getCelciousTemperature(
			final String farenheitAndCelciousTemperature) {
		final String regex = ".+ F \\(([-0-9]+)+ C\\)";
		final Pattern pattern = Pattern.compile(regex);
		final Matcher matcher = pattern.matcher(
				farenheitAndCelciousTemperature);
		if (matcher.find()) {
			return matcher.group(1);
		} else {
			throw new IllegalArgumentException(
					"Failed to get temperature from xml response");
		}
	}
}
