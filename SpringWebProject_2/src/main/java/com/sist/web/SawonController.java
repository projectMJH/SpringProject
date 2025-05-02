package com.sist.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.vo.SawonVO;

// Spring => ����� ���� => ~Controller
// Struts => ~Action
// ����� => ~Model
@Controller
public class SawonController {
	@RequestMapping("sawon/insert.do")
	public String sawon_insert(HttpServletRequest request,HttpServletResponse response)
	{
		return "sawon/insert";
	}
	@RequestMapping("sawon/insert_ok.do")
	public String sawon_insert_ok(HttpServletRequest request,HttpServletResponse response)
	{
		String sabun=request.getParameter("sabun");
		String name=request.getParameter("name");
		String loc=request.getParameter("loc");
		String job=request.getParameter("job");
		String pay=request.getParameter("pay");
		String dept=request.getParameter("dept");
		
		SawonVO vo=new SawonVO();
		vo.setDept(dept);
		vo.setJob(job);
		vo.setLoc(loc);
		vo.setName(name);
		vo.setSabun(Integer.parseInt(sabun));
		vo.setPay(Integer.parseInt(pay));
		
		request.setAttribute("vo", vo);
		return "sawon/output";
	}
	// board/list.do?page=10
	// => (String page) (int page) => 모든 데이터를 String
	// => 해당 데이터형으로 받을 수 있다
	// 매개변수를 이용해서 데이터를 받는다
	// ------ DispatcherServlet
	// => 순서는 관계없다 ?page=10&no=10&id=admin
	// => VO 단위로 값을 받을 수 있다
	//    ------ name 속성 => 반드시 VO의 변수명과 일치되어야 한다. 
	@RequestMapping("sawon/insert_ok2.do")
	public String sawon_insert_ok2(HttpServletRequest request,SawonVO vo)
	{
		// 커맨드 객체
		request.setAttribute("vo",vo);
		return "sawon/output";
	}
	@RequestMapping("sawon/insert_ok3.do")
	public String sawon_insert_ok3(HttpServletRequest request,
								int sabun,String name,String dept, String loc, String job, int pay, HttpSession session)
	{
		SawonVO vo=new SawonVO();
		vo.setDept(dept);
		vo.setJob(job);
		vo.setLoc(loc);
		vo.setName(name);
		vo.setSabun(sabun);
		vo.setPay(pay);
		
		request.setAttribute("vo", vo);

		return "sawon/output";
	}
	/*
	 * 		class Model
	 * 		{
	 * 			HttpServletRequest request;
	 * 			public void addAttribute(String key, Object obj)
	 * 			{
	 * 				request.setAttribute(key, obj);
	 * 			}
	 * 		}
	 */
	@RequestMapping("sawon/insert_ok4.do")
	public String sawon_insert_ok4(Model model,SawonVO vo)
	{
		// command 객체
		// Model => 전송 객체 (JSP로 값을 전송할 때 사용)
		model.addAttribute("vo",vo);
		return "sawon/output";
	}
	

}
