package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class DataBoardDAO {
	@Autowired 
	private DataBoardMapper mapper;
	
	public List<DataBoardVO> boardListData(int start,int end)
	{
		return mapper.boardListData(start, end);
	}
	public int boardRowCount()
	{
		return mapper.boardRowCount();
	}
	public int boardInsert(DataBoardVO vo)
	{
		mapper.boardInsert(vo);
		return mapper.boardCurrentNoData();
	}
	
	public DataBoardVO boardDetailData(int no)
	{
		mapper.hitIncrement(no);
		return mapper.boardDetailData(no);
	}
	
	public String databoardGetPassword(int no)
	{
		return mapper.databoardGetPassword(no);
	}
	
	public void databoardDelete(int no)
	{
		mapper.databoardDelete(no);
	}
	
	public int databoardFileCount(int no)
	{
		return mapper.databoardFileCount(no);
	}

	public DataBoardVO boardUpdateData(int no)
	{
		return mapper.boardDetailData(no);
	}
	
	public void databoardUpdate(DataBoardVO vo)
	{
		mapper.databoardUpdate(vo);
	}
	
}
