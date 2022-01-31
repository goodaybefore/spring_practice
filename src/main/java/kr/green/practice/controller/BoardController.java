package kr.green.practice.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.practice.service.BoardService;
import kr.green.practice.vo.BoardVO;


@Controller
@RequestMapping(value = "/board")
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView boardList(ModelAndView mv) {
		List<BoardVO> boardList = new ArrayList<BoardVO>(); 
		boardList = boardService.getBoardList();
		
		mv.addObject("list", boardList);
		mv.setViewName("/board/list");
		
		return mv;
	}

}
