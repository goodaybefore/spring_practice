package kr.green.practice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.practice.vo.BoardVO;
import kr.green.practice.vo.MemberVO;

public interface BoardDAO {

	List<BoardVO> selectBoardList();

	BoardVO selectBoard(@Param("bd_num")Integer bd_num);

	void insertBoard(@Param("board")BoardVO board, @Param("user")MemberVO user);

	void updateBoard(@Param("board")BoardVO board);

}
