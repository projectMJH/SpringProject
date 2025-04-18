package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.sist.vo.*;
import com.sist.service.*;

@RestController
@RequestMapping("food/")
public class FoodRestController {
	@Autowired
	private FoodService service;
	
	@GetMapping("list_vue.do")
	public List<FoodVO> busanFoodListData(int page)
	{
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=(rowSize*page);
		List<FoodVO> list=service.busanFoodListData(start, end);
		return list;
	}

}
