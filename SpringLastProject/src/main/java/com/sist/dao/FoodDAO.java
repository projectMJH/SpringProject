package com.sist.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
	public List<FoodVO> busanFoodListData(int start,int end)
	{
		return mapper.busanFoodListData(start, end);
	}
	
	public int busanFoodTotalPage()
	{
		return mapper.busanFoodTotalPage();
	}

	public FoodVO busanFoodDetailData(int fno)
	{
		return mapper.foodDetailData(fno);
	}
/*	
	public List<FoodVO> foodFindListData(Map map)
	{
		return mapper.foodFindListData(map);
	}
	
	public int foodFindTotalPage(String fd)
	{
		return mapper.foodFindTotalPage(fd);
	}
	
	public List<FoodVO> foodGubunListData(Map map)
	{
		return mapper.foodGubunListData(map);
	}
	
	public int foodGubunTotalPage(Map map)
	{
		return mapper.foodGubunTotalPage(map);
	}
	
*/	
}
