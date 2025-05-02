package com.sist.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 * 		���ۼ��� => ���� http://localhost:8080/web/board/list.do
 * 		-----
 * 
 * 							Controller			
 * 		����� ��û(.do) == DispatcherServlet
 * 								|	
 * 							Model ã��(@RequestMapping)
 * 								| request
 * 							Model ó�� => �޼��� ȣ��
 * 								|	
 * 							JSP ã�� : ViewResolver 	=> ��θ� / Ȯ����
 * 									 p:prefix="/"
 * 									 p:suffix=".jsp"
 * 								| => request ����
 * 							   JSP : 
 * 					HandlerMapping => DispatcherServlet		
 * 							
 * 							
 * 								|	
 * 								|	
 * 								|	
 */
@Controller
public class BoardModel {
	@RequestMapping("board/list.do")
	public String board_list(HttpServletRequest request,HttpServletResponse response)
	{
		String msg="Hello Spring MVC!!";
		request.setAttribute("msg", msg);
		return "board/list";
	}
}
