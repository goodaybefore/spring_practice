package kr.green.practice.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.green.practice.vo.BoardVO;
import kr.green.practice.vo.MemberVO;

public interface BoardService {

	List<BoardVO> getBoardList();

	BoardVO getBoard(Integer bd_num);
	
	//게시글 등록
	void regBoard(BoardVO board, MemberVO user, List<MultipartFile> file);

	void modifyBoard(MemberVO loginUser, BoardVO board);

	void deleteBoard(MemberVO loginUser, Integer bd_num);

}
