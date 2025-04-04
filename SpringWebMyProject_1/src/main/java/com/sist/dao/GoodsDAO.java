package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class GoodsDAO {
	@Autowired
	private GoodsMapper mapper;
	
	public GoodsVO goodsDetailData(int no)
	{
		return mapper.goodsDetailData(no);
	}
	public List<GoodsVO> goodsListData(Map map)
	{
		return mapper.goodsListData(map);
	}
	public int goodsTotalPage()
	{
		return mapper.goodsTotalPage();
	}

}
