package com.sist.service;
import java.util.*;

import org.springframework.ui.Model;

import com.sist.vo.*;
import com.sist.dao.*;

public interface GoodsService {
	public GoodsVO goodsDetailData(int no);
	public List<GoodsVO> goodsListData(Map map);
	public int goodsTotalPage();
}
