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
	
	//게시글 리스트 GET
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
	
	//게시글 상세
	@RequestMapping(value="/detail",method = RequestMethod.GET)
	public ModelAndView boardDetail(ModelAndView mv, Integer bd_num) {
		BoardVO board = boardService.getBoard(bd_num);
		mv.addObject("board", board);
		mv.setViewName("/board/detail");
		return mv;
	}
	
	//게시글 등록 GET
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
	
	//게시글 등록 POST
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public ModelAndView boardRegPost(ModelAndView mv, BoardVO board, HttpServletRequest request) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		System.out.println(board);
		System.out.println(user);
		
		mv.setViewName("redirect:/board");
		boardService.regBoard(board, user);
		return mv;
	}
	
	//게시글 수정 GET
	@RequestMapping(value="/modify",method = RequestMethod.GET)
	public ModelAndView boardModifyGet(ModelAndView mv, Integer bd_num, HttpServletRequest request) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		System.out.println("bd_num"+bd_num);
		
		BoardVO dbBoard = boardService.getBoard(bd_num);
		if(user==null || dbBoard == null || !dbBoard.getBd_me_id().equals(user.getMe_id())) {
			mv.setViewName("redirect:/board/detail?bd_num="+bd_num);
		}else {
			mv.addObject("board", dbBoard);
			mv.setViewName("/board/modify");
		}
		
		return mv;
	}
	
	//게시글 수정 POST
	@RequestMapping(value="/modify",method = RequestMethod.POST)
	public ModelAndView boardModifyPost(ModelAndView mv, BoardVO board, HttpServletRequest request) {
		MemberVO loginUser = (MemberVO)request.getSession().getAttribute("user");
		boardService.modifyBoard(loginUser, board);
		mv.setViewName("redirect:/board/detail?bd_num="+board.getBd_num());
		return mv;
	}
	
	
	//게시글 삭제
	@RequestMapping(value="/delete",method = RequestMethod.GET)
	public ModelAndView boardDeleteGet(ModelAndView mv, Integer bd_num, HttpServletRequest request) {
		MemberVO loginUser = (MemberVO)request.getSession().getAttribute("user");
		System.out.println("bd_num : "+bd_num);
		boardService.deleteBoard(loginUser, bd_num);
		mv.setViewName("redirect:/board/");
		return mv;
	}
}
