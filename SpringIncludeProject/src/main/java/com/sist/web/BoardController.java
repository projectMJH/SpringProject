package com.sist.web;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.vo.*;
import com.sist.dao.*;
import com.sist.commons.*;
import com.sist.service.RecipeService;
@Controller
// sendRedirect / forward => void
// request를 초기화  request에 값을 넘겨줄 때
public class BoardController {
   @Autowired
   private BoardDAO dao;
   @Autowired
   private RecipeService service;
   
   @GetMapping("board/list.do")
   public String board_list(String page,Model model)
   {
//	   if(page==null)
//		   page="1";
//	   int curpage=Integer.parseInt(page);
//	   List<BoardVO> list=dao.boardListData(curpage);
//	   int count=dao.boardRowCount();
	   Map map=CommonsPagination.pageConfig(page, 10);
	   int curpage=(int)map.get("curpage");
	   List<BoardVO> list=service.boardListData(map);
	   int count=service.boardRowCount();

	   int totalpage=(int)(Math.ceil(count/10.0));
	   count=count-((curpage*10)-10);
	   
	   model.addAttribute("list", list);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
       model.addAttribute("count", count);	   
       
	   String msg="관리자가 삭제한 게시물입니다";
	   String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	   model.addAttribute("msg", msg);
	   model.addAttribute("today", today);
	   
 	   model.addAttribute("main_jsp", "../replyboard/list.jsp");
	   return "main/main";
   }
   @GetMapping("board/insert.do")
   public String board_insert(Model model)
   {
	   model.addAttribute("main_jsp", "../replyboard/insert.jsp");
	   return "main/main";
   }
   @PostMapping("board/insert_ok.do")
   public String board_insert_ok(BoardVO vo)
   {
//	   dao.boardInsert(vo);
	   service.boardInsert(vo);
	   return "redirect:../board/list.do";
	   // _ok => location.href
   }
   @GetMapping("board/detail.do")
   public String board_detail(int no,Model model)
   {
//	   BoardVO vo=dao.boardDetailData(no);
	   BoardVO vo=service.boardDetailData(no);
	   model.addAttribute("vo", vo);
	   model.addAttribute("main_jsp", "../replyboard/detail.jsp");
	   return "main/main";
   }
   @GetMapping("board/update.do")
   public String board_update(int no,Model model)
   {
	   BoardVO vo=dao.boardUpdateData(no);
	   model.addAttribute("vo", vo);
	   model.addAttribute("main_jsp", "../replyboard/update.jsp");
	   return "main/main";
   }
   @GetMapping("board/reply.do")
   public String board_reply(int no,Model model)
   {
	   model.addAttribute("no",no);
	   
	   model.addAttribute("main_jsp","../replyboard/reply.jsp");
	   return "main/main";
   }
   @PostMapping("board/reply_ok.do")
   public String board_reply_ok(int pno,BoardVO vo)
   {
	   dao.replyInsert(pno, vo);
	   return "redirect:../board/list.do";
   }
   @GetMapping("board/delete.do")
   public String board_delete(int no,Model model)
   {
	   model.addAttribute("no",no);
	   
	   model.addAttribute("main_jsp","../replyboard/delete.jsp");
	   return "main/main";
   }
   // .do => java(model) => jsp
}
