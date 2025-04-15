package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.*;

import com.sist.vo.*;
import com.sist.dao.*;

@Controller
public class FoodController {
	@Autowired
	private FoodDAO dao;
	
	@GetMapping("food/list.do")
	public String food_list()
	{
		return "food/list";
	}
	@RequestMapping("food/food_list.do")
	public String food_list2(String page,String ss,String[] fd,
							Model model)
	{
		List<String> safeColumns = Arrays.asList("name", "address", "type", "theme");
		
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		List<String> inputColumns = Arrays.stream(fd)
		    .filter(safeColumns::contains)
		    .collect(Collectors.toList());
		
		Map map=new HashedMap();
		map.put("ss", ss);
		map.put("fdArr", inputColumns);
		map.put("start", 12*curpage-11);
		map.put("end", 12*curpage);
		List<FoodVO> list=dao.foodFindData(map);
		model.addAttribute("list",list);
		
		return "food/food_list";
	}
}
