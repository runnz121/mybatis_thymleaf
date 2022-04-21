package com.example.mybatis_starter.domain.enums;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeException;
import org.apache.ibatis.type.TypeHandler;

public class EnumMapperTypeHandler <E extends Enum<E>> implements TypeHandler<EnumMapperType> {

	private Class<E> type;

	public EnumMapperTypeHandler(Class<E> type) {
		this.type = type;
	}

	@Override
	public void setParameter(PreparedStatement preparedStatement, int i, EnumMapperType enumMapperType,
		JdbcType jdbcType) throws SQLException {
		preparedStatement.setInt(i, enumMapperType.getCode());
	}

	@Override
	public EnumMapperType getResult(ResultSet resultSet, String s) throws SQLException {
		int code = resultSet.getInt(s);
		return getCodeEnum(code);
	}

	@Override
	public EnumMapperType getResult(ResultSet resultSet, int i) throws SQLException {
		int code = resultSet.getInt(i);
		return getCodeEnum(code);
	}

	@Override
	public EnumMapperType getResult(CallableStatement callableStatement, int i) throws SQLException {
		int code = callableStatement.getInt(i);
		return getCodeEnum(code);
	}

	private EnumMapperType getCodeEnum(int code) {
		try {
			EnumMapperType[] enumConstants = (EnumMapperType[]) type.getEnumConstants();
			for (EnumMapperType codeNum : enumConstants) {
				if (codeNum.getCode() == code) {
					return codeNum;
				}
			}
			return null;
		} catch(Exception e) {
			throw new TypeException("cant make enum " + type + "," + e);
		}
	}
}
