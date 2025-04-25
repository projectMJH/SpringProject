package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoodsController {
	@GetMapping("goods/list.do")
	/*
	 * 		<a> location.href=""
	 * 		axios.get => vue / react
	 * 					 ------------ fetch
	 * 		$.ajax({
	 * 			type:get
	 * 		})
	 * 		=> default
	 * 	
	 * 		<form> axios.post
	 * 		$.ajax({
	 * 			type:post
	 * 		})
	 */
	public String goods_list(Model model)
	{
		model.addAttribute("main_jsp","../goods/list.jsp");
		return "main/main";
	}
	@GetMapping("goods/detail.do")
	public String goods_detail(int no,Model model,HttpSession session)
	{
		String id=(String)session.getAttribute("userid");
		model.addAttribute("sessionId",id);
		model.addAttribute("no",no);
		model.addAttribute("main_jsp","../goods/detail.jsp");
		return "main/main";
	}

}
