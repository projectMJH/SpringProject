package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface EmpMapper {

	@Select("SELECT * FROM emp")
	public List<EmpVO> empListData();
}
