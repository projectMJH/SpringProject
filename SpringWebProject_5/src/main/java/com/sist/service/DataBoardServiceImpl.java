package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.sist.vo.*;
import com.sist.dao.*;

@Service
public class DataBoardServiceImpl implements DataBoardService {
	@Autowired
	private DataBoardDAO dDao;
	@Autowired
	private FileInfoDAO fDao;
	@Override
	public List<DataBoardVO> boardListData(int start, int end) {
		// TODO Auto-generated method stub
		return dDao.boardListData(start, end);
	}
	@Override
	public int boardRowCount() {
		// TODO Auto-generated method stub
		return dDao.boardRowCount();
	}
	@Override
	public int boardInsert(DataBoardVO vo) {
		// TODO Auto-generated method stub
		return dDao.boardInsert(vo);
	}
	@Override
	public void boardFileInsert(FileInfoVO vo) {
		// TODO Auto-generated method stub
		fDao.boardFileInsert(vo);
	}
	


}
