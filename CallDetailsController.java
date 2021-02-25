package com.infytel.demospringrestmatrixvariable.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infytel.demospringrestmatrixvariable.dto.CallDetailsDTO;
import com.infytel.demospringrestmatrixvariable.service.CallDetailsService;

@RestController
@RequestMapping("/calldetails")
public class CallDetailsController {
	@Autowired
	private CallDetailsService callDetailsService;
	
	/*Fetching call details based on the request parameters being passed along with the URI,
    Make sure giving the current date (calledOn) on which the demo gets executed,  
    CallDetailsRepository has code to populate calledOn with the current date
    */
	@GetMapping(produces = "application/json")
	public List<CallDetailsDTO> fetchCallDetails(@RequestParam("calledBy") long calledBy,
			@RequestParam("calledOn") String calledOn){
		return callDetailsService.fetchCallDetails(calledBy, LocalDate.parse(calledOn, DateTimeFormatter.ofPattern("MM-DD-YYYY")));
	}
}
