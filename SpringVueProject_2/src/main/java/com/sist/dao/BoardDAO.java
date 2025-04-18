package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
/*
 * 		DI => XML(p:~ c:~) @Autowired
 * 		AOP
 * 		MVC
 * 		ORM : MyBatis
 * 		Front 추가
 * 		=================================
 * 		WebSocket / Security
 * 		URL = 일반 주소 *.do / PathVariable
 * 		=========================================
 * 		Spring - Boot
 */
@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
	
	public List<BoardVO> boardListDate(Map map)
	{
		return mapper.boardListDate(map);
	}
	public int boardTotalPage()
	{
		return mapper.boardTotalPage();
	}
	public void boardInsert(BoardVO vo)
	{
		mapper.boardInsert(vo);
	}

	public BoardVO boardDetailData(int no)
	{
		mapper.hitIncrement(no);
		return mapper.boardDetailData(no);
	}
	public BoardVO boardUpdateData(int no)
	{
		return mapper.boardDetailData(no);
	}
	public String boardUpdate(BoardVO vo)
	{
		String result="no";
		String db_pwd=mapper.boardGetPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd()))
		{
			result="yes";
			mapper.boardUpdate(vo);
		}
		return result;
	}
	public String boardDelete(int no,String pwd)
	{
		String result="no";
		String db_pwd=mapper.boardGetPassword(no);
		if(db_pwd.equals(pwd))
		{
			result="yes";
			mapper.boardDelete(no);
		}
		return result;
	}
			
}
