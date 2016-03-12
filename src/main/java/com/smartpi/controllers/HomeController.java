package com.smartpi.controllers;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smartpi.services.LedService;

@Controller
public class HomeController {

	@Resource(name = "defaultLedService")
	private LedService ledService;

	@RequestMapping("/turnRedOn")
	public ResponseEntity<Void> turnRedLedOn() {
		ledService.turnLedOn("red");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping("/turnRedOff")
	public ResponseEntity<Void> turnRedLedOff() throws InterruptedException {
		ledService.turnLedOff("red");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping("/turnGreenOn")
	public ResponseEntity<Void> turnGreenLedOn() throws InterruptedException {
		ledService.turnLedOn("green");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping("/turnGreenOff")
	public ResponseEntity<Void> turnGreenLedOff() throws InterruptedException {
		ledService.turnLedOff("green");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping("/turnOrangeOn")
	public ResponseEntity<Void> turnOrangeLedOn() throws InterruptedException {
		ledService.turnLedOn("orange");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping("/turnOrangeOff")
	public ResponseEntity<Void> turnOrangeLedOff() throws InterruptedException {
		ledService.turnLedOff("orange");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping("/marcin")
	public @ResponseBody TestMarcin marcin(@ModelAttribute final TestMarcin m)
			throws InterruptedException {
		System.out.println(m.getFirstName() + "  " + m.getLastName());
		final TestMarcin d = new TestMarcin();
		d.setFirstName("111");
		d.setLastName("22");
		return d;
	}

}