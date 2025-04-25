package com.sist.service;

import java.util.*;

import com.sist.vo.*;

public interface RecipeService {
	public List<ChefVO> chefListData(Map map);
	public int chefTotalPage(int rowSize);
}
