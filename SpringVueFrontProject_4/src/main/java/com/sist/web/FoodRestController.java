package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.vo.*;

@RestController
public class FoodRestController {
	@Autowired
	private FoodDAO dao;
	
	@GetMapping(value = "food/list_vue.do", produces = "text/plain;charset=UTF-8")
	public String food_list_vue(int page) throws Exception
	{
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=(rowSize*page);
		List<FoodVO> list=dao.foodListData(start, end);
		int totalpage=dao.foodTotalPage();
		final int BLOCK=10;
		int startPage=(page-1)/BLOCK*BLOCK+1;
		int endPage=(page-1)/BLOCK*BLOCK+BLOCK;
		if (endPage>totalpage)
			endPage=totalpage;
		
		Map map=new HashMap();
		map.put("list",list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
	@GetMapping(value = "food/find_vue.do", produces = "text/plain;charset=UTF-8")
	public String food_find_vue(int page,String gubun,String fd) throws Exception
	{
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=(rowSize*page);
		Map map=new HashedMap();
		map.put("start", start);
		map.put("end", end);
		map.put("gubun",gubun);
		map.put("fd",fd);
//		List<FoodVO> list=dao.foodFindListData(map);
//		int totalpage=dao.foodFindTotalPage(fd);
		List<FoodVO> list=dao.foodGubunListData(map);
		int totalpage=dao.foodGubunTotalPage(map);
		final int BLOCK=10;
		int startPage=(page-1)/BLOCK*BLOCK+1;
		int endPage=(page-1)/BLOCK*BLOCK+BLOCK;
		if (endPage>totalpage)
			endPage=totalpage;

		map=new HashedMap();
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("gubun", gubun);
		map.put("fd", fd);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
	
	@GetMapping(value = "food/detail_vue.do", produces = "text/plain;charset=UTF-8")
	public String food_detail_vue(int fno) throws Exception
	{
		FoodVO vo=dao.foodDetailData(fno);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		return json;
	}

}
