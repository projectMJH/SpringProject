package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
public interface BoardMapper {
	@Select("SELECT no,subject,name,hit,regdate,num "
			+ "FROM (SELECT no,subject,name,hit,regdate,rownum as num "
			+ "FROM (SELECT no,subject,name,hit,regdate "
			+ "FROM springReplyBoard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(Map map);
	@Select("SELECT COUNT(*) FROM springReplyBoard")
	public int boardRowCount();
	@Insert("INSERT INTO springReplyBoard("
			+ "no,name,subject,content,pwd,group_id) "
			+ "VALUES(sfb_no_seq.nextval,#{name},#{subject},#{content},#{pwd},"
			+ "(SELECT NVL(MAX(group_id)+1,1) FROM springReplyBoard))")
	public void boardInsert(BoardVO vo);
	@Select("SELECT no,name,subject,content,hit,regdate "
			+ "FROM springReplyBoard "
			+ "WHERE no=#{no}")
	public BoardVO boardDetailData(int no);
	@Update("UPDATE INTO springReplyBoard SET "
			+ "hit=hit+1"
			+ "WHERE no=#{no}")
	public void boardHitIncrement(int no);
}
