package com.sist.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
// 스프링이 관리하는 클래스 => 기능을 가지고 있는 클래스
// ~DAO, ~Manager, ~Service
@Repository
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper; 
	
	public List<RecipeVO> recipeListDate(int start,int end)
	{
		return mapper.recipeListDate(start, end);
	}
	
	public int recipeTotalPage()
	{
		return mapper.recipeTotalPage();
	}
	
	public List<RecipeVO> recipeFindListDate(Map map)
	{
		return mapper.recipeFindListDate(map);
	}
	
	public int recipeFindTotalPage(String fd)
	{
		return mapper.recipeFindTotalPage(fd);
	}
	
	public RecipeDetailVO recipeDetailData(int no)
	{
		return mapper.recipeDetailData(no);
	}
	
	
}
