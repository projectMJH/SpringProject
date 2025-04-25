package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.commons.*;
import com.sist.vo.*;
import com.sist.service.*;
@RestController
public class RecipeRestController {
	@Autowired
	private RecipeService service;
	
	@GetMapping("chef/list_vue.do")
	public Map chef_list_vue(int page)
	{
		final int ROWSIZE=RecipeConfig.CHEF_SIZE;
		int start=(page*ROWSIZE)-(ROWSIZE-1);
		int end=(page*ROWSIZE);
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<ChefVO> list=service.chefListData(map);
		int totalpage=service.chefTotalPage(ROWSIZE);
		map=new HashMap();
		
		final int BLOCK=RecipeConfig.BLOCK_SIZE;
		int startPage=(page-1)/BLOCK*BLOCK+1;
		int endPage=(page-1)/BLOCK*BLOCK+BLOCK;
		if (endPage>totalpage)
			endPage=totalpage;
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		return map;
	}
}
