package com.sist.vo;

import java.util.*;

import lombok.Data;

/*
USERID     NOT NULL VARCHAR2(20)  
USERNAME   NOT NULL VARCHAR2(52)  
USERPWD    NOT NULL VARCHAR2(100) 
ENABLE              NUMBER(1)     
SEX                 VARCHAR2(6)   
BIRTHDAY   NOT NULL VARCHAR2(20)  
EMAIL               VARCHAR2(100) 
POST       NOT NULL VARCHAR2(10)  
ADDR1      NOT NULL VARCHAR2(500) 
ADDR2               VARCHAR2(100) 
PHONE               VARCHAR2(20)  
CONTENT             CLOB          
REGDATE             DATE          
MODIFYDATE          DATE          
LASTLOGIN           DATE   
 */
// spring security
// => userid : username
// => pwd , userpwd : password
// role => ROLE_ADMIN / ROLE_USER / ROLE_MANAGER ...
// =>
// =>
@Data
public class MemberVO {
	private int enable; // 1(활성), 0(휴먼)
	private String userid,username,userpwd,sex,birthday,email,
			post,addr1,addr2,phone,content;
	private Date regdate,modifydate,lastlogin;
	
	private String phone1,phone2,authority,msg;
}
