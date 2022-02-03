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
		board.setBd_type("일반");
		boardDao.insertBoard(board, user);
	}

	@Override
	public void modifyBoard(MemberVO loginUser, BoardVO board) {
		if(board == null || loginUser == null) return ;
		System.out.println("board"+board);
		//가져온 board의 bd_num을 이용해서 기존 board정보를 가져온다.
		BoardVO dbBoard = boardDao.selectBoard(board.getBd_num());
		System.out.println("dbBoard : "+dbBoard);
		//db에서 가져온 board의 id가 현재 로그인되어있는 id와 다르다면 return;
		if(!dbBoard.getBd_me_id().equals(loginUser.getMe_id())) return ;
		System.out.println("dbBoard : ");
		
		boardDao.updateBoard(board);
		
	}

}
