package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.sist.vo.*;
import com.sist.service.*;

@Controller
@RequestMapping("goods/")
public class GoodsController{
	@Autowired
	private GoodsService service;

	@GetMapping("goods_detail_before.do")
	public String goods_detail(String no,HttpServletResponse response,
								RedirectAttributes ra)
	{
		Cookie cookie=new Cookie("spring"+no, no);
		cookie.setPath("/");
		cookie.setMaxAge(24*60*60);
		response.addCookie(cookie);
		
		ra.addAttribute("no",no);
		return "redirect:goods_detail.do";
	}
	@GetMapping("goods_detail.do")
	public String goods_detail(int no,Model model)
	{
		GoodsVO vo=service.goodsDetailData(no);
		String price=vo.getGoods_price();
		price=price.replaceAll("[^0-9]", "");
		vo.setPrice(Integer.parseInt(price));
		
		model.addAttribute("vo",vo);
		return "goods/goods_detail";
	}
	@GetMapping("goods_list.do")
	public String goods_list(String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int start=(curpage*12)-11;
		int end=(curpage*12);
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<GoodsVO> list=service.goodsListData(map);
		int totalpage=service.goodsTotalPage();
		int startPage=((curpage-1)/10*10)+1;
		int endPage=((curpage-1)/10*10)+10;
		
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		
		return "goods/goods_list";
	}
	
}
