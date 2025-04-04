package com.sist.dao;

/*
 * 	<bean id="dao" class="com.sist.dao.EmpDAO"
		p:mapper-ref="mapper"
	/>
 */
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository()
public class EmpDAO {
	@Autowired
	private EmpMapper mapper;

	public List<EmpVO> empListData()
	{
		return mapper.empListData();
	}
	public EmpVO empDetailData(int empno)
	{
		return mapper.empDetailData(empno);
	}
}
