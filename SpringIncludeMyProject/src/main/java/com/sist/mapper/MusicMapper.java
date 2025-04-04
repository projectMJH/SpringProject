package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface MusicMapper {
	@Insert("INSERT INTO aopMusic values("
			+ "#{rank},#{poster},#{title},#{singer},#{album})")
	public void musicInsert(MusicVO vo);
	@Select("SELECT rank,poster,title,singer,album "
			+ "FROM (SELECT rank,poster,title,singer,album "
			+ "FROM aopMusic ORDER BY rank) "
			+ "WHERE rownum<=10")
	public List<MusicVO> musicListData();
	@Delete("DELETE FROM aopMusic")
	public void musicDelete();
}
