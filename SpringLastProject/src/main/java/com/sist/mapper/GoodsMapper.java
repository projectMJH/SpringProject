package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.*;

import com.sist.vo.*;

public interface GoodsMapper {
	@Select("SELECT no,goods_poster,goods_name,goods_price,num "
			+ "FROM (SELECT no,goods_poster,goods_name,goods_price,rownum as num "
			+ "FROM (SELECT no,goods_poster,goods_name,goods_price "
			+ "FROM goods_all ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> busanGoodsListData(@Param("start") int start,
											@Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM goods_all")
	public int busanGoodsTotalPage();
	
	@Select("SELECT * FROM goods_all WHERE no=#{no}")
	public GoodsVO busanGoodsDetailData(int no);
	
	// 구매내역
}
