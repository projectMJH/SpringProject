package com.sist.service;

import java.util.*;

import com.sist.vo.*;

public interface DataBoardService {
	public List<DataBoardVO> boardListData(int start,int end);
	public int boardRowCount();
	public int boardInsert(DataBoardVO vo);
	public void boardFileInsert(FileInfoVO vo);
}
