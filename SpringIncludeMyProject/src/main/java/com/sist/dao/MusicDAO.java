package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class MusicDAO {
	@Autowired
	private MusicMapper mapper;
	
	public void musicInsert(MusicVO vo)
	{
		mapper.musicInsert(vo);
	}
	public List<MusicVO> musicListData()
	{
		return mapper.musicListData();
	}
	public void musicDelete()
	{
		mapper.musicDelete();
	}
}
