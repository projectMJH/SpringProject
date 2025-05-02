package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.ui.Model;

import com.sist.vo.*;
public interface GoodsMapper {
	@Select("SELECT * FROM goods_all WHERE no=#{no}")
	public GoodsVO goodsDetailData(int no);
	@Select("SELECT no,goods_name,goods_poster,num "
			+ "FROM (SELECT no,goods_name,goods_poster,rownum as num "
			+ "FROM (SELECT no,goods_name,goods_poster "
			+ "FROM goods_all)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsListData(Map map);
	@Select("SELECT CEIL(COUNT(*)/12.0) from goods_all")
	public int goodsTotalPage();

}
