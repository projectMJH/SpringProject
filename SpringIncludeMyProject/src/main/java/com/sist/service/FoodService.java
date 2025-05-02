package com.sist.service;

import java.util.*;

import com.sist.vo.BoardVO;
import com.sist.vo.FoodVO;

public interface FoodService {
	public List<FoodVO> foodListData(Map map);
	public int foodTotalPage();
	public FoodVO foodDetailData(int fno);
	
	public List<FoodVO> foodFindData(Map map);
	public int foodFindTotalPage(Map map);
	
	public List<BoardVO> boardListData(Map map);
	public int boardRowCount();
	public void boardInsert(BoardVO vo);
	public BoardVO boardDetailData(int no);
	
}
