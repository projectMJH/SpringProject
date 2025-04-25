package com.sist.vo;
import java.util.*;

import lombok.Data;
/*
RNO       NOT NULL NUMBER       
FNO                NUMBER       
USERID             VARCHAR2(20) 
RDAY      NOT NULL VARCHAR2(30) 
RTIME     NOT NULL VARCHAR2(30) 
RINWON    NOT NULL VARCHAR2(20) 
REGDATE            DATE         
ISRESERVE          NUMBER   
 */
@Data
public class ReserveVO {
	private int rno,fno,isreserve;
	private String userid,rday,rtime,rinwon;
	private Date regdate;
	private FoodVO fvo=new FoodVO();
	private MemberVO mvo=new MemberVO();
	
	private String dbday;
}
