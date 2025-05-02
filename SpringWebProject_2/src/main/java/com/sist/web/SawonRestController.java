package com.sist.web;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.vo.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SawonRestController {
	
	@RequestMapping(value = "sawon/list.do", produces = "text/play;charset=UTF-8")
	public String sawon_list() throws Exception
	{
		List<SawonVO> list=new ArrayList<SawonVO>();
		SawonVO vo=new SawonVO();
		
		vo.setSabun(1);
		vo.setName("홍길동");
		vo.setDept("개발부");
		vo.setJob("사원");
		vo.setLoc("부산");
		vo.setPay(3000);
		list.add(vo);
		ObjectMapper mapper=new ObjectMapper();
		String s=mapper.writeValueAsString(list);
		return s;
	}
	
}
