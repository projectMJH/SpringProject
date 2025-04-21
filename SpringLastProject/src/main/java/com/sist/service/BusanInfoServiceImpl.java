package com.sist.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.*;
import com.sist.vo.*;

@Service
public class BusanInfoServiceImpl implements BusanInfoService{
	@Autowired
	private BusanInfoDAO bDao;

	@Override
	public List<BusanInfoVO> busanInfoListData(Map map) {
		// TODO Auto-generated method stub
		return bDao.busanInfoListData(map);
	}

	@Override
	public int busanInfoTotalPage(int cno) {
		// TODO Auto-generated method stub
		return bDao.busanInfoTotalPage(cno);
	}

	@Override
	public BusanInfoVO busanInfoDetailData(int no) {
		// TODO Auto-generated method stub
		return bDao.busanInfoDetailData(no);
	}
}
