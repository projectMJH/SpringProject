package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface MemberMapper {
	@Insert("INSERT INTO member(id,name,pwd,"
			+ "sex,birthday,email,post,addr1,addr2,phone,content) "
			+ "VALUES(#{id},#{username},#{userpwd},"
			+ "#{sex},#{birthday},#{email},#{post},#{addr1},#{addr2},#{phone},#{content})")
	public void memberInsert(MemberVO vo);
	
	@Insert("INSERT INTO authority VALUES("
			+ "#{id},'ROLE_USER')")
	public void memberAuthorityInsert(String id);
	
	@Select("SELECT id,name,sex,email,phone,post,addr1,addr2 "
			+ "FROM member "
			+ "WHERE id=#{id}")
	public MemberVO memberSessionData(String id);
	
}
