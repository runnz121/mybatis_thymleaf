package com.example.mybatis_starter.domain.enums;

import java.util.*;

public class MapBuilder {

	private Map<String, Object> map;

	private MapBuilder() {
		this.map = new HashMap<>();
	}

	public static MapBuilder builder() {
		return new MapBuilder();
	}

	public MapBuilder add(String key, Object value) {
		this.map.put(key, value);
		return this;
	}

	public Map<String, Object> build() {
		return this.map;
	}
}
