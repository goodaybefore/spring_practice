package kr.green.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.practice.dao.BoardDAO;
import kr.green.practice.vo.BoardVO;
import kr.green.practice.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{
	@Autowired
	BoardDAO boardDao;
	
	//게시글 전체 리스트(/board)
	@Override
	public List<BoardVO> getBoardList() {
		return boardDao.selectBoardList();
	}

	//bd_num으로 게시글 불러오기(/board/detail)
	@Override
	public BoardVO getBoard(Integer bd_num) {
		if(bd_num == null || bd_num <= 0) return null;
		return boardDao.selectBoard(bd_num);
	}

	@Override
	public void regBoard(BoardVO board, MemberVO user) {
		if(board == null || user== null) return;
		boardDao.insertBoard(board, user);
	}

}
