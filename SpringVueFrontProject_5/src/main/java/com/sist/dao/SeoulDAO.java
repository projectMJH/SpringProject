package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;

// 1. 메모리 관리(싱글턴) 2. 객체 생성 ~ 객체 소멸
// 3. 필요시마다 객체 주소 요청이 가능(@Autowired)
// => 클래스 관리자
//    ---- 컴포넌트 => 컴포넌트 여러개 관리 (컨테이너) => 스프링 컨테이너
// MVC => 스프링의 라이브러리
// => 복잡한 클래스 / 메모리 할당이 많은 클래스 : 게임 프로그램
@Repository	
public class SeoulDAO {
	// 구현된 클래스를 읽어온다
	@Autowired
	private SeoulMapper mapper;
	
	public List<SeoulVO> seoulListData(Map map)
	{
		return mapper.seoulListData(map);
	}
	
	public int seoulTotalPage(Map map)
	{
		return mapper.seoulTotalPage(map);
	}
	
	public SeoulVO seoulDetailData(Map map)
	{
		return mapper.seoulDetailData(map);
	}
}
