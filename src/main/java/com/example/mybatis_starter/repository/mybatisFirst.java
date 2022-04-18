package com.example.mybatis_starter.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.mybatis_starter.domain.entity.User;

/**
 *  이 방법을 쓰게되면 Properties에 해당 설정을 따로 하지 않아도된다
 *  하위에 메소드를 선언해주고 @Select() 안에 쿼리를 넣어줌
 *  그리고 인터페이스에 @Mapper 어노테이션을 붙여준다
 */
@Mapper
public interface mybatisFirst {

	// @Select 문인 경우
	@Select("SELECT * FROM user")
	List<User> findAll();

	@Select("SELECT * FROM user WHERE userIdx = #{userIdx") // 동적바인딩을 위한 #{} 처리
	User findByUserIdx(@Param("userIdx") int userIdx);

	//@Update()
	//@Insert()
	//@Delete()
}
