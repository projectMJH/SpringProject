package com.sist.service;
import java.util.*;

import com.sist.vo.*;

public interface BusanInfoService {
	public List<BusanInfoVO> busanInfoListData(Map map);
	public int busanInfoTotalPage(int cno);
	public BusanInfoVO busanInfoDetailData(int no);
}
