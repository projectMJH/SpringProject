package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.vo.*;
import com.sist.service.*;

@Controller
public class ReserveController {
	@Autowired
	private ReserveService service;
	@Autowired
	private GoodsService gService;
	
	@GetMapping("mypage/mypage_main.do")
	public String mypage_main(Model model)
	{
		model.addAttribute("main_jsp","../mypage/mypage_main.jsp");
		return "main/main";		
	}
	@GetMapping("mypage/cart_delete.do")
	public String cart_delete(int cno)
	{
		gService.goodsCartCancel(cno);
		return "redirect:../mypage/cart_list.do";
	}
	@GetMapping("mypage/cart_list.do")
	public String cart_list(HttpSession session,Model model)
	{
		String userid=(String)session.getAttribute("userid");
		List<CartVO> list=gService.goodsCartListData(userid);
		
		model.addAttribute("list",list);
		model.addAttribute("mypage_jsp","../mypage/cart_list.jsp");
		model.addAttribute("main_jsp","../mypage/mypage_main.jsp");
		return "main/main";		
	}
	@GetMapping("mypage/buy_list.do")
	public String buy_list(HttpSession session,Model model)
	{
		String userid=(String)session.getAttribute("userid");
		List<CartVO> list=gService.goodsBuyListData(userid);
		
		model.addAttribute("list",list);
		model.addAttribute("mypage_jsp","../mypage/buy_list.jsp");
		model.addAttribute("main_jsp","../mypage/mypage_main.jsp");
		return "main/main";		
	}
	@GetMapping("reserve/main.do")
	public String reserve_main(Model model)
	{
		model.addAttribute("main_jsp","../reserve/reserve_main.jsp");
		return "main/main";
	}
	@GetMapping("mypage/reserve_list.do")
	public String mypage_reserve_list(HttpSession session, Model model)
	{
		String userid=(String)session.getAttribute("userid");
		List<ReserveVO> list=service.reserveMyPageListData(userid);
		model.addAttribute("list",list);
		
		model.addAttribute("mypage_jsp","../mypage/reserve_list.jsp");
		model.addAttribute("main_jsp","../mypage/mypage_main.jsp");
		return "main/main";
	}
	@GetMapping("reserve/reserve_delete.do")
	public String mypage_reserve_delete(int rno)
	{
		service.reserveDelete(rno);
		return "redirect:../mypage/reserve_list.do";
	}
	@GetMapping("adminpage/reserve_list.do")
	public String adminpage_reserve_list(HttpSession session, Model model)
	{
		List<ReserveVO> list=service.reserveAdminListData();
		model.addAttribute("list",list);
		
		model.addAttribute("main_jsp","../adminpage/reserve_list.jsp");
		return "main/main";
	}
	@GetMapping("reserve/reserve_ok.do")
	public String reserve_ok(int rno)
	{
		service.reserveUpdate(rno);
		return "redirect:../adminpage/reserve_list.do";
	}
	
}
