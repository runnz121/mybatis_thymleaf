package com.example.mybatis_starter.domain.enums;

//codeEnum 인터페이스와 마찬가지로 enum이 map 형식인 경우
//typehandler 예외처리 해주기 위해 작성
public interface EnumMapperType {

	Integer getCode();

	String getName();

	String getDesc();
}
