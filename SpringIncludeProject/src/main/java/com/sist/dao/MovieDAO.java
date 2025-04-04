package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class MovieDAO {
	@Autowired
	private MovieMapper mapper;
	
	public void movieInsert(MovieVO vo)
	{
		mapper.movieInsert(vo);
	}
	public void movieDelete()
	{
		mapper.movieDelete();
	}
	public List<MovieVO> movieListData()
	{
		return mapper.movieListData();
	}
}
