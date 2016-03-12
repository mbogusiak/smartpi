package com.smartpi;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@Controller
public class SmartPi extends WebMvcConfigurerAdapter
		implements ErrorController {

	public static void main(final String[] args) {
		SpringApplication.run(SmartPi.class, args);
	}

	@RequestMapping("/user")
	public Principal user(final Model model, final Principal user) {
		System.out.println(model.asMap().get("_csrf"));
		System.out.println("is user auth");
		return user;
	}

	@RequestMapping("/resource")
	public Map<String, Object> home() {
		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}

	private static final String PATH = "/error";

	@RequestMapping(value = PATH)
	public String goToMainPage() {
		return "forward:/";
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
}
