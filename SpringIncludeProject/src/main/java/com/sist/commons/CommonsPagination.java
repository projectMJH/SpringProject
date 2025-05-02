package com.sist.commons;

import java.util.*;

// => 메모리 할당  (X) => static 메서드
/*
 * 	공통으로 사용되는 기능 : 메서드
 *  => 자동화 처리 => AOP => 모든 메서드 적용
 *  			   --- 트랜잭션 / 보안 / footer
 *  => 원하는 위치에서 호출 => 메서드 호출
 *  =>
 *  =>
 *  =>
 */
public class CommonsPagination {
	public static Map pageConfig(String page,int rowSize)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		
		Map map=new HashMap();
		int start=(rowSize*curpage)-(rowSize-1);
		int end=(rowSize*curpage);
		map.put("start", start);
		map.put("end", end);
		map.put("curpage", curpage);
		return map;
	}	
}
