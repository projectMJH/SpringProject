package com.sist.web;

import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;

@RestController
/*
 * 		ResponseEntity
 * 			결과값 / 상태코드 (200,404,400,500) / 헤더값을 모두
 * 			프론트로 전송
 * 			에러 코드를 상세하게 전송
 * 
 * 		=> 프로트에서 서버에서 받아온 데이터를 화면 표시할 때 사용
 * 		   일반 웹에서 사용 => 프로미스 
 * 		   오류를 윕게 찾아서 수정
 */
public class RecipeRestController {
	@Autowired
	private RecipeDAO rDao;
	
	
	@GetMapping("recipe/list_vue.do")
	// params => 매개변수 => formData + VO
	public ResponseEntity<Map> recipe_list(int page)
	{
		// 에러 / 정상 (status) => 실제 데이터 전송
		Map map=new HashMap();
		try
		{
			int rowSize=12;
			int start=(rowSize * page)-(rowSize-1);
			int end=(rowSize * page);
			List<RecipeVO> list=rDao.recipeListData(start, end);
			int count=rDao.recipeTotalPage();
			int totalpage=(int)(Math.ceil(count/12.0));
			
			final int BLOCK=10;
			int startPage=(page-1)/BLOCK*BLOCK + 1;
			int endPage=(page-1)/BLOCK*BLOCK + BLOCK;
			if(endPage>totalpage)
				endPage=totalpage;
			// Vue로 전송
			map.put("list", list);
			map.put("curpage", page);
			map.put("totalpage", totalpage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			map.put("count", count);
			// {}
		}catch(Exception ex)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	/*
	 *  detail.jsp 내의 vue parameter 정의		
	 *  params:{
			no:this.no
		}

	 */
	@GetMapping("recipe/detail_vue.do")
	public ResponseEntity<Map> recipe_detail(int no)
	{
		Map map=new HashMap();
		try 
		{
			RecipeDetailVO vo=rDao.recipeDetailData(no);
			List<String> mlist=new ArrayList<String>();
			List<String> ilist=new ArrayList<String>();
			String[] datas=vo.getFoodmake().split("\n");
			for(String s:datas)
			{
				StringTokenizer st=new StringTokenizer(s,"^");
				mlist.add(st.nextToken());
				ilist.add(st.nextToken());
			}
			
			map.put("vo", vo);
			map.put("mlist", mlist);
			map.put("ilist", ilist);
		} catch (Exception ex) 
		{
			// 500
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
