package com.sist.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;

import lombok.Setter;
import oracle.jdbc.OracleTypes;
/*
 * 		class A
 * 
 * 		map.put("a",new A()) => spring default singleton
 */
public class FoodDAO {
	private Connection conn;
	private CallableStatement cs;
	private static FoodDAO dao;
	// => Default : PreparedStatement
	// @Options(statementType=StatementType.CALLABLE)
	@Setter
	private String url;
	@Setter
	private String username;
	@Setter
	private String password;
	private FoodDAO(String driver)
	{
		try {
			Class.forName(driver);
		} catch (Exception ex) {}
	}
	
	public void getConnection()
	{
		try {
			conn=DriverManager.getConnection(url,username,password);
		}catch(Exception ex) {}
	}

	public void disConnection()
	{
		try {
			if(cs!=null) cs.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {}
	}
	//////////////////////// MyBatis는 자동 설정
	
	public List<FoodVO> foodListData(int page)
	{
		List<FoodVO> list=new ArrayList<FoodVO>();
		try {
			getConnection();
			int rowSize=12;
			int start=rowSize*page-(rowSize-1);
			int end=rowSize*page;
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
			String sql="{CALL foodListData(?,?,?)}";
			/*
			 * 	@Select(value="{CALL foodListData(pStart,mode=IN,javaType=java.lang.Integer...})"
			 */
			cs=conn.prepareCall(sql);
			cs.setInt(1, start);
			cs.setInt(2, end);
			cs.registerOutParameter(3, OracleTypes.CURSOR);
			// ? 값 채우기
			cs.executeQuery();
			ResultSet rs=(ResultSet)cs.getObject(3);
			while(rs.next())
			{
				FoodVO vo=new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setPoster(rs.getString(2));
				vo.setName(rs.getString(3));
				list.add(vo);
			}
			rs.close();
			// 모든 값이 => Map
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return list;
	}
	/*
	 * create or replace procedure foodTotalPage(
		    pTotal out number
		)
		IS
		BEGIN
		    SELECT CEIL(COUNT(*)/12.0) INTO pTotal
		    FROM project_food;
		END;
	 */
	public int foodTotalPage()
	{
		int total=0;
		try {
			getConnection();
			String sql="{CALL foodTotalPage(?)}";
			cs=conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.INTEGER);
			cs.executeQuery();
			total=cs.getInt(1);
			cs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return total;
	}
	/*
	 * create or replace procedure foodDetailData(
		    pFno number,
		    pResult out sys_refcursor
		)
		IS
		BEGIN
		    OPEN pResult for
		    SELECT * FROM project_food
		    WHERE fno=pFno;
		END;
	 */
	
}
