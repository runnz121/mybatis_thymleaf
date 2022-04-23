package com.example.mybatis_starter.domain.enums;

import java.util.Map;

public interface EnumInterface {

	String getCode();

	String getName();

	Map<String, Object> getResult();


	//code enum map을 커스텀 빌드하는 default method(custom class 로 구현)
	default Map<String, Object> getResult(String code, String name) {
		return MapBuilder.builder().add("code", code).add("name", name).build();
	}
}
