package kr.green.practice.service;

import java.util.List;

import kr.green.practice.vo.BoardVO;
import kr.green.practice.vo.MemberVO;

public interface BoardService {

	List<BoardVO> getBoardList();

	BoardVO getBoard(Integer bd_num);

	void regBoard(BoardVO board, MemberVO user);

}
