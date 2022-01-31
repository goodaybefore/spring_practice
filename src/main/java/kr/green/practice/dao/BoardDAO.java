package kr.green.practice.dao;

import java.util.List;

import kr.green.practice.vo.BoardVO;

public interface BoardDAO {

	List<BoardVO> selectBoardList();

}
