package kr.green.practice.service;

import java.util.List;

import kr.green.practice.vo.BoardVO;

public interface BoardService {

	List<BoardVO> getBoardList();

	BoardVO getBoard(Integer bd_num);

}
