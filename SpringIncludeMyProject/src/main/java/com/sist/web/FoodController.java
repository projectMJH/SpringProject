package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.vo.*;
import com.sist.service.*;
import com.sist.commons.*;

@Controller
public class FoodController {
	@Autowired
	private FoodService service;
	
	@GetMapping("food/detail.do")
	public String food_detail(int fno,Model model)
	{
		FoodVO vo=service.foodDetailData(fno);
		model.addAttribute("vo",vo);
		
		model.addAttribute("main_jsp","../food/detail.jsp");
		return "main/main";
	}
	@RequestMapping("food/find.do")
	public String food_find(String page,String fd,Model model)
	{
		if(fd==null)
			fd="";
		Map map=CommonsPagination.pageConfig(page, 12);
		int curpage=(int)map.get("curpage");
		map.put("fd", fd);
		List<FoodVO> list=service.foodFindData(map);
		int totalpage=service.foodFindTotalPage(map);
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("fd",fd);
		
		model.addAttribute("main_jsp","../food/find.jsp");
		return "main/main";
	}

}
