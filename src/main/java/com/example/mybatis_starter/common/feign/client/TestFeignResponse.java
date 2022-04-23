package com.example.mybatis_starter.common.feign.client;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestFeignResponse {

	private Integer userId;
	private Integer id;
	private String title;
	private boolean completed;
}
