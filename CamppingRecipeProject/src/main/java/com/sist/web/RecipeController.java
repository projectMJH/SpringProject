package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class RecipeController {
	@GetMapping("recipe/chef_list.do")
	public String chef_list(String page,Model model)
	{
		if(page==null)
			page="1";
		model.addAttribute("page",Integer.parseInt(page));
		model.addAttribute("main_jsp","../recipe/chef_list.jsp");
		return "main/main";
	}
}
