package com.sist.service;

import java.util.*;

import com.sist.vo.*;

public interface RecipeService {
	public List<RecipeVO> recipeListData(Map map);
	public int recipeTotalPage();
	public RecipeDetailVO recipeDetailData(int no);
	
	public List<RecipeVO> recipeFindData(Map map);
	public int recipeFindTotalPage(Map map);
	
	public List<ChefVO> chefListData(Map map);
	public int chefTotalPage();
	
	public List<BoardVO> boardListData(Map map);
	public int boardRowCount();
	public void boardInsert(BoardVO vo);
	public BoardVO boardDetailData(int no);

}
