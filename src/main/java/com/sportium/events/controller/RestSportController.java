package com.sportium.events.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportium.events.service.SportService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class RestSportController {
	
	@Autowired
	private final SportService sportService;
	
	@GetMapping(value = "/event")
	public ResponseEntity<HashMap<String, Object>> getInterpret(@RequestParam("input") String input){
		
		return ResponseEntity.ok(sportService.getInterpretString(input));
	}
	
}
