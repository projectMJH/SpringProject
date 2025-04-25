package com.sist.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.*;
import com.sist.dao.*;
@Service
public class ReserveServiceImpl implements ReserveService {
	@Autowired
	private ReserveDAO rDao;

	@Override
	public List<FoodVO> busanFoodReserveData() {
		// TODO Auto-generated method stub
		return rDao.busanFoodReserveData();
	}

	@Override
	public void reserveInsert(ReserveVO vo) {
		// TODO Auto-generated method stub
		rDao.reserveInsert(vo);
	}

	@Override
	public List<ReserveVO> reserveMyPageListData(String userid) {
		// TODO Auto-generated method stub
		return rDao.reserveMyPageListData(userid);
	}

	@Override
	public List<ReserveVO> reserveAdminListData() {
		// TODO Auto-generated method stub
		return rDao.reserveAdminListData();
	}

	@Override
	public void reserveDelete(int rno) {
		// TODO Auto-generated method stub
		rDao.reserveDelete(rno);
	}

	@Override
	public void reserveUpdate(int rno) {
		// TODO Auto-generated method stub
		rDao.reserveUpdate(rno);
	}

}
