package com.sist.mapper;

import org.apache.ibatis.annotations.*;

import java.util.*;
import com.sist.vo.*;
public interface FoodMapper {
	
	@Select("SELECT fno,poster,name,replycount,likecount,hit,num "
			+ "FROM (SELECT fno,poster,name,replycount,likecount,hit,rownum as num "
			+ "FROM (SELECT fno,poster,name,replycount,likecount,hit "
			+ "FROM busan_food ORDER BY fno ASC))"
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> busanFoodListData(@Param("start") int start,
									@Param("end") int end);
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM busan_food")
	public int busanFoodTotalPage();
	@Select("SELECT fno,poster,name,num "
			+ "FROM (SELECT fno,poster,name,rownum as num "
			+ "FROM (SELECT fno,poster,name "
			+ "FROM busan_food "
			+ "WHERE name LIKE '%'||#{fd}||'%' "
			+ "ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodFindListData(Map map);
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM busan_food "
			+ "WHERE name LIKE '%'||#{fd}||'%'")
	public int foodFindTotalPage(String fd);
	
	@Select("SELECT fno,poster,name,num "
			+ "FROM (SELECT fno,poster,name,rownum as num "
			+ "FROM (SELECT fno,poster,name "
			+ "FROM busan_food "
			+ "WHERE ${gubun} LIKE '%'||#{fd}||'%' "
			+ "ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodGubunListData(Map map);
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM busan_food "
			+ "WHERE ${gubun} LIKE '%'||#{fd}||'%'")
	public int foodGubunTotalPage(Map map);
	
	@Select("SELECT * FROM busan_food WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
}
