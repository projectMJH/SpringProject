package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
// 데이터 값 전송 => 자바스크립트와 통신 => 일반문자열 / JSON

import com.sist.dao.*;
import com.sist.vo.*;

import java.io.*;
import java.util.*;

@RestController
public class DataBoardRestController {
	@Autowired
	private DataBoardDAO dDao;
	@Autowired
	private FileInfoDAO fDao;
	
	/*
	 * 		<delete id="" parameterType"String">
	 * 			declare
	 * 			begin
	 * 				DELETE FROM jjim WHERE id=#{id}
	 * 				DELETE FROM like WHERE id=#{id}
	 * 				DELETE FROM reply WHERE id=#{id}
	 * 				DELETE FROM reserve WHERE id=#{id}
	 * 				DELETE FROM cart WHERE id=#{id}
	 * 				DELETE FROM buy WHERE id=#{id}
	 * 			end
	 * 		</delete>
	 */

	@GetMapping(value="databoard/delete_ok.do",produces="text/plain;charset=UTF-8")
	public String databoard_delete_ok(int no,String pwd)
	{
		String result="no";
		String db_pwd=dDao.databoardGetPassword(no);
		List<FileInfoVO> list=fDao.fileListData(no);
		int count=dDao.databoardFileCount(no);
		if(db_pwd.equals(pwd))
		{
			result="yes";
			
			if(count>0)
			{
				fDao.fileInfoDelete(no);
				try
				{
					for(FileInfoVO vo:list)
					{
						File file=new File("c:\\download\\"+vo.getFilename());
						file.delete();
					}
				}catch(Exception ex) {}
			}
			dDao.databoardDelete(no);
		}
		
		return result;
	}
	@PostMapping(value="databoard/update_ok.do",produces="text/html;charset=UTF-8")
	public String databoard_update(DataBoardVO vo)
	{
		String js="";
		String db_pwd=dDao.databoardGetPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd()))
		{
			dDao.databoardUpdate(vo);
			js="<script>location.href=\"detail.do?no="+vo.getNo()+"\";</script>";
		}
		else
		{
			js="<script>"
				+ "alert(\"비밀번호가 틀렸습니다!!\");"
				+ "history.back();"
				+ "</script>";
		}
		return js;
	}
}
