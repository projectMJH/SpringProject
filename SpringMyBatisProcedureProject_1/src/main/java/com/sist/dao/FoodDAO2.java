package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class FoodDAO2 {
	@Autowired
	private FoodMapper mapper;
	
	public int foodTotalPage()
	{
		return mapper.foodTotalPage();
	}
	/*
	 * 	@Select(value="{CALL foodListData(#{pStart,mode=IN,javaType=java.lang.Integer},"
									+ "#{pEnd,mode=IN,javaType=java.lang.Integer},"
									+ "#{pResult,mode=OUT,jdbcType=CURSOR,resultMap=foodMap})}")

	 */
	public List<FoodVO> foodListData(Map map)
	{
		mapper.foodListData(map);
		return (List<FoodVO>)map.get("pResult");
	}
}
