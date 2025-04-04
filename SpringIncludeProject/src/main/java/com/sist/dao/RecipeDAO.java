package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.RecipeMapper;
import com.sist.vo.ChefVO;
import com.sist.vo.RecipeVO;
/*
 * 	.do<a> => Model => Mapper(SQL) = DAO = Service 
 * 		=> Model => JSP 출력	
 * 		|		  | ViewResolver
 * 	   동작 순서
 */
@Repository
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;
	
	public List<RecipeVO> recipeListData(Map map)
	{
		return mapper.recipeListData(map);
	}
	
	public int recipeTotalPage()
	{
		return mapper.recipeTotalPage();
	}
	
	public List<RecipeVO> recipeFindData(Map map)
	{
		return mapper.recipeFindData(map);
	}
	public int recipeFindTotalPage(Map map)
	{
		return mapper.recipeFindTotalPage(map);
	}
	public List<ChefVO> chefListData(Map map)
	{
		return mapper.chefListData(map);
	}
	public int chefTotalPage()
	{
		return mapper.chefTotalPage();
	}
}
