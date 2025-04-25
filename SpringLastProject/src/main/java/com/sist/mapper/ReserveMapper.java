package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.*;

import com.sist.vo.*;

public interface ReserveMapper {
	@Select("SELECT fno,poster,name "
			+ "FROM busan_food ORDER BY fno ASC")
	public List<FoodVO> busanFoodReserveData();
	
	@Insert("INSERT INTO busanReserve(rno,fno,userid,rday,rtime,rinwon) "
			+ "VALUES(br_rno_seq.nextval,#{fno},#{userid},#{rday},#{rtime},#{rinwon})")
	public void reserveInsert(ReserveVO vo);
	// <resultMap>
	@Results({
		@Result(property = "fvo.poster",column = "poster"),
		@Result(property = "fvo.name",column = "name")
	})
	@Select("SELECT rno,br.fno,poster,name,rday,rtime,rinwon,"
			+ "TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday, "
			+ "isReserve "
			+ "FROM busanReserve br, busan_food bf "
			+ "WHERE br.fno=bf.fno "
			+ "AND userid=#{userid} "
			+ "ORDER BY rno DESC")
	public List<ReserveVO> reserveMyPageListData(String userid);
	
	// <resultMap>
	@Results({
		@Result(property = "fvo.poster",column = "poster"),
		@Result(property = "fvo.name",column = "name")
	})
	@Select("SELECT rno,br.fno,userid,poster,name,rday,rtime,rinwon,"
			+ "TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday, "
			+ "isReserve "
			+ "FROM busanReserve br, busan_food bf "
			+ "WHERE br.fno=bf.fno "
			+ "ORDER BY rno DESC")
	public List<ReserveVO> reserveAdminListData();
	@Delete("DELETE FROM busanReserve "
			+ "WHERE rno=#{rno}")
	public void reserveDelete(int rno);
	@Update("UPDATE busanReserve SET "
			+ "isreserve=1 "
			+ "WHERE rno=#{rno}")
	public void reserveUpdate(int rno);
	
}
