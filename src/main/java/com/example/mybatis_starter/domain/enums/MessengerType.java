package com.example.mybatis_starter.domain.enums;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.ibatis.type.EnumTypeHandler;
import org.apache.ibatis.type.MappedTypes;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MessengerType implements EnumInterface {
	KAKAO("kakao", "카카오톡"),
	LINE("line", "라인"),
	TELEGRAM("telegram", "텔레그렘")
	;

	private String code;

	private String name;

	private static Map<String, String> messengerTypeMap;

	//stream으로 코드 테임과, 이름 매칭
	static {
		messengerTypeMap = Stream.of(MessengerType.values())
			.collect(Collectors.toMap(MessengerType::getCode, MessengerType::getName));
	}

	MessengerType(String code, String name) {
		this.code = code;
		this.name = name;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getName() {
		return name;
	}

	//json object 형식 혹은 db에서 해당 코드값을 사용 할 수 있다.
	@Override
	@JsonValue
	public Map<String, Object> getResult() {
		return this.getResult(code, name);
	}


	//java config으로 typehandler 설정
	@MappedTypes(MessengerType.class)
	public static class TypeHandler extends EnumTypeHandler<MessengerType> {
		public TypeHandler() {
			super(MessengerType.class);
		}
	}

}
