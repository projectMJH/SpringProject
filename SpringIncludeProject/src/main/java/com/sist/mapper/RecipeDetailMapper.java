package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface RecipeDetailMapper {
	@Select("SELECT * FROM recipeDetail "
			+ "WHERE no=#{no}" )
	public RecipeDetailVO recipeDetailData(int no);
}
