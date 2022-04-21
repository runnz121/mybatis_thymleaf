package com.example.mybatis_starter.domain.enums;

import java.util.Arrays;

import org.apache.ibatis.type.MappedTypes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum LogType implements EnumMapperType {

	USER_TYPE(1, "회원구성"),
	USER_STATUS(2, "회원구분")
	;

	private Integer code;

	private String desc;

	public static LogType ofCode(Integer code) throws Exception {
		return Arrays.stream(LogType.values())
			.filter(v -> v.getCode() == code)
			.findAny()
			.orElseThrow(()->new Exception("error"));
	}


	@Override
	public Integer getCode() {
		return code;
	}

	@Override
	public String getName() {
		return name();
	}

	@Override
	public String getDesc() {
		return desc;
	}



	@MappedTypes(LogType.class)
	public static class TypeHandler extends EnumMapperTypeHandler<LogType> {
		public TypeHandler() {
			super(LogType.class);
		}
	}

}
