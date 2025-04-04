package com.sist.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.sist.vo.*;
import com.sist.dao.*;
@Service
public class GoodsServiceImplement implements GoodsService{
	@Autowired
	private GoodsDAO gDao;
	@Override
	public GoodsVO goodsDetailData(int no) {
		// TODO Auto-generated method stub
		return gDao.goodsDetailData(no);
	}

	@Override
	public List<GoodsVO> goodsListData(Map map) {
		// TODO Auto-generated method stub
		return gDao.goodsListData(map);
	}

	@Override
	public int goodsTotalPage() {
		// TODO Auto-generated method stub
		return gDao.goodsTotalPage();
	}

}
