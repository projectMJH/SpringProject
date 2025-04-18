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
public class FoodController {
	@Autowired
	private FoodService service;
	
	@GetMapping("list.do")
	public String food_list(Model model)
	{
		model.addAttribute("main_jsp","../food/list.jsp");
		return "main/main";
	}
}
