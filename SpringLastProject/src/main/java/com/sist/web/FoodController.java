package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import com.sist.vo.*;
import com.sist.service.*;

@Controller
@RequestMapping("food/")
/*
 * 		@Controller
 * 			=> 리턴형
 * 			   String / void
 * 			=> 매개변수
 * 			   내장 객체 / getParameter		
 * 						 => 커맨드 객체 사용, List, String[]
 * 							-------- VO
 * 				  | HttpSession, HttpServletRequest, HttpServletResponse,
 * 					RedirectAttributes
 * 					-> Cookie는 필요시마다 생성
 * 					-> 전송 객체 : Model
 * 		@RestController
 * 			=> 리턴형 : Map, List, VO, String
 * 			=> 매개변수 : getparameter, String[]
 * 			=> 브라우저에 출력만 담당 => 출력된 내용을 Vue, React, Ajax
 * 
 */
public class FoodController {
	@Autowired
	private FoodService service;
	
	@GetMapping("list.do")
	public String food_list(Model model)
	{
		model.addAttribute("main_jsp","../food/list.jsp");
		return "main/main";
	}
	
	@GetMapping("detail.do")
	public String food_detail(int fno,Model model)
	{
		FoodVO vo=service.busanFoodDetailData(fno);
		List<String> list=new ArrayList<String>();
		String[] images=vo.getImages().split(",");
		list=Arrays.asList(images);
		model.addAttribute("vo",vo);
		model.addAttribute("list",list);
		model.addAttribute("main_jsp","../food/detail.jsp");
		return "main/main";
	}
}
