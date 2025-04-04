package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class BoardDAO2 {
	@Autowired
	private BoardMapper mapper;
	
	public List<BoardVO> boardListData(Map map)
	{
		return mapper.boardListData(map);
	}
	public int boardRowCount()
	{
		return mapper.boardRowCount();
	}
	public void boardInsert(BoardVO vo)
	{
		mapper.boardInsert(vo);
	}
	@Transactional
	public BoardVO boardDetailData(int no)
	{
		mapper.boardHitIncrement(no);
		return mapper.boardDetailData(no);
	}

}
