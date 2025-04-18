package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sist.vo.*;
import java.util.*;
import com.sist.dao.*;
@RestController
public class BoardRestController {
	@Autowired
	private BoardDAO dao;
	
	@GetMapping("/board/list_vue/{page}")
	public ResponseEntity<Map> board_list(@PathVariable("page") int page)
	{
		Map map=new HashMap();
		try {
			int rowSize=10;
			int start=(rowSize * page)-(rowSize-1);
			int end=(rowSize * page);
			map.put("start", start);
			map.put("end", end);
			List<BoardVO> list=dao.boardListDate(map);
			int totalpage=dao.boardTotalPage();
			
			map=new HashMap();

			// Vue로 전송
			map.put("list", list);
			map.put("curpage", page);
			map.put("totalpage", totalpage);
			map.put("msg", "PathVariable을 이용한 게시판");
			
		} catch (Exception ex) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	@PostMapping("/board/insert_vue")
	public ResponseEntity<Map> board_insert(@RequestBody BoardVO vo)
	{
		Map map=new HashMap();
		try {
			dao.boardInsert(vo);
			map.put("msg", "yes");
		} catch (Exception ex) {
			map.put("msg", "no");
			return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
		
	}
	@GetMapping("/board/detail_vue/{no}")
	public ResponseEntity<BoardVO> board_deatil(@PathVariable("no") int no)
	{
		BoardVO vo=new BoardVO();	
		try {
			vo=dao.boardDetailData(no);
		} catch (Exception ex) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(vo,HttpStatus.OK);
	}
	@GetMapping("/board/update_vue/{no}")
	public ResponseEntity<BoardVO> board_update(@PathVariable("no") int no)
	{
		BoardVO vo=new BoardVO();	
		try {
			vo=dao.boardUpdateData(no);
		} catch (Exception ex) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(vo,HttpStatus.OK);
	}
	@PutMapping("/board/update_ok_vue")
	public ResponseEntity<Map> board_update_ok(@RequestBody BoardVO vo)
	{
		Map map=new HashMap();
		try {
			String msg=dao.boardUpdate(vo);
			map.put("msg", msg);
		} catch (Exception ex) {
			return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
		
	}
	@DeleteMapping("/board/delete_vue/{no}/{pwd}")
	public ResponseEntity<Map> board_delete_ok(@PathVariable("no") int no,
											@PathVariable("pwd") String pwd)
	{
		Map map=new HashMap();
		try {
			String msg=dao.boardDelete(no,pwd);
			map.put("msg", msg);
		} catch (Exception ex) {
			return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
		
	}
}
