package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.vo.*;
import com.sist.service.*;

@RestController
public class ReserveRestController {
	@Autowired
	private ReserveService service;

	
	@GetMapping("reserve/main_vue.do")
	public Map reserve_main()
	{
		Map map=new HashMap();
		List<FoodVO> list=service.busanFoodReserveData();
		map.put("list", list);
		// => 시간
		List<String> tList=new ArrayList<String>();
		tList.add("17:00");
		tList.add("18:00");
		tList.add("19:00");
		tList.add("20:00");
		tList.add("21:00");
		tList.add("22:00");
		tList.add("23:00");
		tList.add("24:00");
		map.put("time",tList);
		// => 인원
		List<String> iList=new ArrayList<String>();
		for(int i=1;i<=10;i++)
		{
			iList.add(String.valueOf(i));
		}
		iList.add("단체");
		map.put("inwon", iList);
		return map;
	}
	@PostMapping("reserve/reserve_vue_ok.do")
	public String reserve_vue_ok(ReserveVO vo, HttpSession session)
	{
		String result="";
		try
		{
			String userid=(String)session.getAttribute("userid");
			vo.setUserid(userid);
			service.reserveInsert(vo);
			result="yes";
		}catch(Exception ex)
		{
			result=ex.getMessage();
		}
		return result;
	}

}
