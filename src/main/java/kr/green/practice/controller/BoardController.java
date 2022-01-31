package kr.green.practice.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.practice.service.BoardService;
import kr.green.practice.vo.BoardVO;
import kr.green.practice.vo.MemberVO;


@Controller
@RequestMapping(value = "/board")
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView boardList(ModelAndView mv, HttpServletRequest request) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		
		List<BoardVO> boardList = new ArrayList<BoardVO>(); 
		boardList = boardService.getBoardList();
		
		mv.addObject("user", user);
		mv.addObject("list", boardList);
		mv.setViewName("/board/list");
		
		return mv;
	}
	
	@RequestMapping(value="/detail",method = RequestMethod.GET)
	public ModelAndView boardDetail(ModelAndView mv, Integer bd_num) {
		BoardVO board = boardService.getBoard(bd_num);
		mv.addObject("board", board);
		mv.setViewName("/board/detail");
		return mv;
	}
	
	@RequestMapping(value="/register",method = RequestMethod.GET)
	public ModelAndView boardRegGet(ModelAndView mv, HttpServletRequest request) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		if(user==null) {
			mv.setViewName("redirect:/");
		}else {
			mv.setViewName("/board/register");
		}
		
		return mv;
	}
	
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public ModelAndView boardRegPost(ModelAndView mv, BoardVO board, HttpServletRequest request, MemberVO user) {
		System.out.println(board);
		System.out.println(user);
		
		mv.setViewName("/board/register");
		return mv;
	}

}
