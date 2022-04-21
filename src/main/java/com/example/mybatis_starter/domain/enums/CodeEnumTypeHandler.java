package com.example.mybatis_starter.domain.enums;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeException;
import org.apache.ibatis.type.TypeHandler;
//https://www.holaxprogramming.com/2015/11/12/spring-boot-mybatis-typehandler/
//코드 값을 호출하여 해덩 enum 값을 호출하길 기대하였지만, 그냥 코드값으로 호출 됨(숫자형)
//따라서 이를 방지하고자 preparedstatement에 파라미터를 설정하고, resultset을 설정
// 즉 CREDIT("00") 이라는 Enum이 있다면 00이라는 값이 삽입되길 원함(CREDIT)이 아니고
public class CodeEnumTypeHandler <E extends Enum<E>> implements TypeHandler<CodeEnum> {

	private Class<E> type;

	public CodeEnumTypeHandler(Class <E> type) {
		this.type = type;
	}

	//preparedStatement : 컴파일 된 상태에서 ? 에 동적 값 바인딩,
	@Override
	public void setParameter(PreparedStatement preparedStatement, int i, CodeEnum codeEnum, JdbcType jdbcType) throws
		SQLException {
		preparedStatement.setInt(i, codeEnum.getCode());
	}

	@Override
	public CodeEnum getResult(ResultSet resultSet, String s) throws SQLException {

		int code = resultSet.getInt(s);
		return getCodeEnum(code);
	}

	@Override
	public CodeEnum getResult(ResultSet resultSet, int i) throws SQLException {

		int code = resultSet.getInt(i);
		return getCodeEnum(code);
	}

	@Override
	public CodeEnum getResult(CallableStatement callableStatement, int i) throws SQLException {
		int code = callableStatement.getInt(i);
		return getCodeEnum(code);
	}

	private CodeEnum getCodeEnum(int code) {
		try {
			//enum class 값을 받아와서 enum의 원소값 or null을 반환
			CodeEnum[] enumConstants = (CodeEnum[]) type.getEnumConstants();
			for (CodeEnum codeNum: enumConstants) {
				if (codeNum.getCode() == code) {
					return codeNum;
				}
			}
			return null;
		} catch (Exception e) {
			throw new TypeException("cant make enum" + type + " " + e);
		}
	}
}
