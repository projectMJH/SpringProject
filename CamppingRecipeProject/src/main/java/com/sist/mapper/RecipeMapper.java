package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.*;

import com.sist.vo.*;

public interface RecipeMapper {
	@Select("SELECT no,chef,poster,rcount,scount,wcount,fcount,num"
			+ "FROM (SELECT no,chef,poster,rcount,scount,wcount,fcount,rownum as num  "
			+ "FROM (SELECT /* INDEX_ASC(recipeDetail rd_no_pk)*/no,chef,poster,rcount,scount,wcount,fcount "
			+ "FROM recipeDetail)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> recipeListData(String page);
}
