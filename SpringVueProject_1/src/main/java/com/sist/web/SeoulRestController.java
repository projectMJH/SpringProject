package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.vo.*;
import com.sist.dao.*;
@RestController
public class SeoulRestController {
	@Autowired
	private SeoulDAO sDao;
	
	@GetMapping("seoul/location_vue.do")
	public ResponseEntity<Map> seoul_location(int page)
	{
		Map map=new HashMap();
		try
		{
			int rowSize=12;
			int start=(rowSize * page)-(rowSize-1);
			int end=(rowSize * page);
			map.put("start", start);
			map.put("end", end);
			map.put("table_name", "seoul_location");
			List<SeoulVO> list=sDao.seoulListData(map);
			int totalpage=sDao.seoulTotalPage(map);
			
			final int BLOCK=10;
			int startPage=(page-1)/BLOCK*BLOCK + 1;
			int endPage=(page-1)/BLOCK*BLOCK + BLOCK;
			if(endPage>totalpage)
				endPage=totalpage;
			// Vue로 전송
			map=new HashMap();
			map.put("list", list);
			map.put("curpage", page);
			map.put("totalpage", totalpage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			// {}
		}catch(Exception ex)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);		
	}
	@GetMapping("seoul/shop_vue.do")
	public ResponseEntity<Map> seoul_shop(int page)
	{
		Map map=new HashMap();
		try
		{
			int rowSize=12;
			int start=(rowSize * page)-(rowSize-1);
			int end=(rowSize * page);
			map.put("start", start);
			map.put("end", end);
			map.put("table_name", "seoul_shop");
			List<SeoulVO> list=sDao.seoulListData(map);
			int totalpage=sDao.seoulTotalPage(map);
			
			final int BLOCK=10;
			int startPage=(page-1)/BLOCK*BLOCK + 1;
			int endPage=(page-1)/BLOCK*BLOCK + BLOCK;
			if(endPage>totalpage)
				endPage=totalpage;
			// Vue로 전송
			map=new HashMap();
			map.put("list", list);
			map.put("curpage", page);
			map.put("totalpage", totalpage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			// {}
		}catch(Exception ex)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);		
	}
	@GetMapping("seoul/loc_detail_vue.do")
	public ResponseEntity<Map> seoul_loc_detail(int no)
	{
		Map map=new HashMap();
		try
		{
			SeoulVO vo=sDao.seoulLocationDetailData(no);
			String address=vo.getAddress();
			int index=address.indexOf("서울");
			if(index>0)
			{
				String addr1=address.substring(index);
				String addr2=addr1.trim();
				addr2=addr2.substring(addr2.indexOf(" "));
				String addr3=addr2.trim();
				addr3=addr3.substring(0,addr3.indexOf(" "));
				System.out.println(addr3);
				List<FoodVO> list=sDao.foodRecommandData(addr3);
				map.put("list", list);
				map.put("count", list.size());
			}
			else
			{
				map.put("count", 0);
			}
			map.put("vo", vo);
		}catch(Exception ex)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);				
	}
}
