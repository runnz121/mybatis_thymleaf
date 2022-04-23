package com.example.mybatis_starter.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class TestController {

	@GetMapping("/heatlh")
	public ResponseEntity healthCheck() {
		return new ResponseEntity(HttpStatus.OK);
	}

}
