package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;

import java.util.*;
@RestController
public class FoodRestController {
	@Autowired
	private FoodDAO dao;
/*	
	@PostMapping("food/vue_check2_vue.do")
	public Map vue_check(String f)
	{
		Map map=new HashedMap();
		map.put("f", f);
		return map;
	}
*/	
	@PostMapping("food/list_vue.do")
	public List<FoodVO> food_list(int page, String[] ss,String fd)
	{
		Map map=new HashedMap();
		map.put("fdArr", ss);
		map.put("ss", fd);
		map.put("start", page*12-11);
		map.put("end", page*12);
		
		return dao.foodFindData(map);
	}
}
