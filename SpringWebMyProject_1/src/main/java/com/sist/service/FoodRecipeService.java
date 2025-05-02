package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.sist.vo.*;

public interface FoodRecipeService {
	public FoodVO foodDetailData(int fno);
	public List<FoodVO> foodListData(Map map);
	public int foodTotalPage();


}
