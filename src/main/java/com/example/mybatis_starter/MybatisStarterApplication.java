package com.example.mybatis_starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.mybatis_starter.common.feign.client")
public class MybatisStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisStarterApplication.class, args);
	}

}
