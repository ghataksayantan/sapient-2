package com.sapient.sayantan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.sayantan.footballApi.FootBallApiCall;
import com.sapient.sayantan.jsonModel.Country;

@RestController
public class FootballController {	
	
	@RequestMapping(value="/reqTrace", method = RequestMethod.GET, headers="Accept=application/json")
	public String getCountry(@RequestParam String crNum) {	
		
		FootBallApiCall foot = new FootBallApiCall();
		Country[] coun = foot.getCountry().getBody();
		return coun[0].getCountryName();
	}
}
