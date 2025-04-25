package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.sist.vo.*;

public interface ChefMapper {
	
	@Select("SELECT no,chef,poster,rcount,scount,wcount,fcount,num"
			+ "FROM (SELECT no,chef,poster,rcount,scount,wcount,fcount,rownum as num  "
			+ "FROM (SELECT /* INDEX_ASC(chef chef_no_pk)*/no,chef,poster,rcount,scount,wcount,fcount "
			+ "FROM chef)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<ChefVO> chefListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/#{rowSize}) FROM chef")
	public int chefTotalPage(@Param("rowSize") int rowSize);
	
}
