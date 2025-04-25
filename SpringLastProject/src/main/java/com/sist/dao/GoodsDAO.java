package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
/*
 * 	interface DB
 *  class A implements DB
 *  class B implements DB
 *  
 *  @Autowired
 *  @Qualifier(name="a") => 중복된 경우 특정 객체 지정
 *  DB db;
 */
@Repository
public class GoodsDAO {
	// 스프링에서 구현되 ㄴMapper의 주소 읽기
	@Autowired
	private GoodsMapper mapper;
	
	public List<GoodsVO> busanGoodsListData(int start,int end)
	{
		return mapper.busanGoodsListData(start, end);
	}
	public int busanGoodsTotalPage()
	{
		return mapper.busanGoodsTotalPage();
	}
	public GoodsVO busanGoodsDetailData(int no)
	{
		return mapper.busanGoodsDetailData(no);
	}
}
