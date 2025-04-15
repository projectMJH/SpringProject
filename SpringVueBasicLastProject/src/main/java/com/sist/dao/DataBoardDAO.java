package com.sist.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class DataBoardDAO {
	@Autowired
	private DataBoardMapper mapper;
	
	public List<DataBoardVO> databoardListData(Map map)
	{
		return mapper.databoardListData(map);
	}
	public int databoardTotalPage()
	{
		return mapper.databoardTotalPage();
	}
	public void databoardInsert(DataBoardVO vo)
	{
		mapper.databoardInsert(vo);
	}
	public DataBoardVO databoardDetailData(int no)
	{
		mapper.hitIncrement(no);
		return mapper.databoardDetailData(no);
	}
}
