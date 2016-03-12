package com.smartpi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
// @ImportResource("classpath:integration.xml")
public class IntegrationConfig extends WebSecurityConfigurerAdapter {

	// @Bean
	// public MessageChannel weatherInputChannel() {
	// return new DirectChannel();
	// }
	// @Bean
	// public MessageChannel weatherOutputSoapChannel() {
	// return new DirectChannel();
	// }
	// @Bean
	// public MessageChannel outChannel() {
	// return new DirectChannel();
	// }
	// @Bean
	// public MessageChannel outputWeatherChannel() {
	// return new DirectChannel();
	// }
	// @Bean
	// public ScheduledSender myBean() {
	// return new ScheduledSender();
	// }
	// @Transformer(inputChannel = "weatherInputChannel", outputChannel =
	// "weatherSoapChannel")
	// public HeaderEnricher soapActionEnricher() {
	// Map<String, ? extends HeaderValueMessageProcessor<?>> headersToAdd =
	// Collections.singletonMap("emailUrl",
	// new
	// StaticHeaderValueMessageProcessor<String>("http://www.webserviceX.NET/GetWeather"));
	// HeaderEnricher enricher = new HeaderEnricher(headersToAdd);
	// MarshallingWebServiceInboundGateway sd = null;
	// sd.setMessageBuilderFactory(messageFactory);
	// return enricher;
	// }
	//
	// @Bean
	// public SaajSoapMessageFactory messageFactory() {
	// return new SaajSoapMessageFactory();
	// }
	//// <int-ws:outbound-gateway id="wsOutboundGateway"
	//// request-channel="weatherSoapChannel"
	// uri="http://www.webservicex.net/globalweather.asmx"
	//// marshaller="weatherMarshaller" unmarshaller="weatherUnmarshaller"
	// reply-channel="weatherOutputSoapChannel"
	//// message-factory="messageFactory" />
	////
	//// <bean id="weatherMarshaller"
	// class="org.springframework.oxm.jaxb.Jaxb2Marshaller">
	//// <property name="packagesToScan" value="net.webservicex.**" />
	//// </bean>
	//// <bean id="weatherUnmarshaller"
	// class="org.springframework.oxm.jaxb.Jaxb2Marshaller">
	//// <property name="packagesToScan" value="net.webservicex.**" />
	//// </bean>
	////
	//// <bean id="messageFactory"
	// class="org.springframework.ws.soap.saaj.SaajSoapMessageFactory" />
	////
	//// <int:transformer id="testTransformer"
	// input-channel="weatherOutputSoapChannel"
	//// method="transform" output-channel="outChannel"
	// ref="weatherResponseStringTransformer" />
	////
	//// <bean id="weatherResponseStringTransformer"
	// class="com.marcin.weather.transfomer.WeatherTransformer"
	// scope="prototype" />
	////
	////
	//// <int-xml:unmarshalling-transformer
	//// id="defaultUnmarshaller" input-channel="outChannel"
	// output-channel="outputWeatherChannel"
	//// unmarshaller="unmarshallingTransformer" />
	////
	////
	//// <bean id="unmarshallingTransformer"
	// class="org.springframework.oxm.jaxb.Jaxb2Marshaller">
	//// <property name="packagesToScan" value="com.marcin.weather.pojo.**" />
	//// </bean>

}