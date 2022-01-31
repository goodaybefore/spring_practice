package kr.green.practice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.practice.vo.BoardVO;

public interface BoardDAO {

	List<BoardVO> selectBoardList();

	BoardVO selectBoard(@Param("bd_num")Integer bd_num);

}
