package com.sist.dao;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dDao")
public class DeptDAO {
	@Autowired
	private DeptMapper mapper;
	
	public List<DeptVO> deptListData()
	{
		return mapper.deptListData();
	}
}
