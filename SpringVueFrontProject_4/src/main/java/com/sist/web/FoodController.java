package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.FoodDAO;

@Controller
public class FoodController {
	@Autowired
	private FoodDAO dao;
	
	@GetMapping("food/list.do")
	public String food_list()
	{
		return "food/list2";
	}
	@GetMapping("food/find.do")
	public String food_find()
	{
		return "food/find2";
	}
	@GetMapping("food/detail.do")
	public String food_detail()
	{
		return "food/detail";
	}
}
