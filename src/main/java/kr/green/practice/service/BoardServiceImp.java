package kr.green.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.practice.dao.BoardDAO;
import kr.green.practice.vo.BoardVO;

@Service
public class BoardServiceImp implements BoardService{
	@Autowired
	BoardDAO boardDao;
	
	@Override
	public List<BoardVO> getBoardList() {
		return boardDao.selectBoardList();
	}

}
