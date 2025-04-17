package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.sist.vo.*;

public interface FoodMapper {
	/*
	 * 	<select id="foodTotalPage" resultType="int">
			SELECT CEIL(COUNT(*)/12.0) FROM project_food
		</select>
	 */
	public int foodTotalPage();
	
	/*
	 * create or replace procedure foodListData(
		    pStart number,
		    pEnd number,
		    pResult out SYS_REFCURSOR
		)
		IS
		BEGIN
		    open pResult for
		    select fno,poster,name,num
		    from (select fno,poster,name,rownum as num
		    from (select fno,poster,name
		    from project_food order by fno asc))
		    where num between pStart and pEnd;
		END;
	 */
	@Select(value="{CALL foodListData(#{pStart,mode=IN,javaType=java.lang.Integer},"
									+ "#{pEnd,mode=IN,javaType=java.lang.Integer},"
									+ "#{pResult,mode=OUT,jdbcType=CURSOR,resultMap=foodMap})}")
	@Options(statementType = StatementType.CALLABLE)
	public List<FoodVO> foodListData(Map map);
	
}
