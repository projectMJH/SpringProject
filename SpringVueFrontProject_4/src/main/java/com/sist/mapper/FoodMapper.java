package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface FoodMapper {
	
	@Select("SELECT fno,poster,name,num "
			+ "FROM (SELECT fno,poster,name,rownum as num "
			+ "FROM (SELECT fno,poster,name "
			+ "FROM project_food ORDER BY fno ASC))"
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start") int start,
									@Param("end") int end);
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM project_food")
	public int foodTotalPage();
	@Select("SELECT fno,poster,name,num "
			+ "FROM (SELECT fno,poster,name,rownum as num "
			+ "FROM (SELECT fno,poster,name "
			+ "FROM project_food "
			+ "WHERE name LIKE '%'||#{fd}||'%' "
			+ "ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodFindListData(Map map);
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM project_food "
			+ "WHERE name LIKE '%'||#{fd}||'%'")
	public int foodFindTotalPage(String fd);
	
	@Select("SELECT fno,poster,name,num "
			+ "FROM (SELECT fno,poster,name,rownum as num "
			+ "FROM (SELECT fno,poster,name "
			+ "FROM project_food "
			+ "WHERE ${gubun} LIKE '%'||#{fd}||'%' "
			+ "ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodGubunListData(Map map);
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM project_food "
			+ "WHERE ${gubun} LIKE '%'||#{fd}||'%'")
	public int foodGubunTotalPage(Map map);
	
	@Select("SELECT * FROM project_food WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
}
