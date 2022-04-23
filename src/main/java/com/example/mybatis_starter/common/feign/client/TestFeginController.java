package com.example.mybatis_starter.common.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "naver", url ="https://jsonplaceholder.typicode.com/todos/1")
public interface TestFeginController {

	@GetMapping("/feign/test" )
	TestFeignResponse sampleTestResponse();
}
