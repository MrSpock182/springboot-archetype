package com.example.demo.api;

import com.google.common.collect.ImmutableMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class HealthCheckApi {

	private static final Map<String, String> status = ImmutableMap.of("status", "up");

	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public void root(){

	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("health")
	public void health(){

	}
}
