package kr.green.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.practice.Utils.UploadFileUtils;
import kr.green.practice.dao.BoardDAO;
import kr.green.practice.vo.BoardVO;
import kr.green.practice.vo.FileVO;
import kr.green.practice.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{
	@Autowired
	BoardDAO boardDao;
	
	String uploadPath = "C:\\Users\\tsj02\\Documents\\practice_upload";
	
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
	public void regBoard(BoardVO board, MemberVO user, List<MultipartFile> file) {
		if(board == null || user== null) return;
		board.setBd_me_id(user.getMe_id());
		if(board.getBd_title()==null || board.getBd_contents()==null||
				board.getBd_me_id()==null) return;
		board.setBd_type("일반");
		
		//게시글 업로드
		boardDao.insertBoard(board, user);
		
		//파일 업로드
		uploadFile(file, board.getBd_num());
	}

	//첨부파일 업로드 함수
	private void uploadFile(List<MultipartFile> files, Integer bd_num) {
		if(files == null) return;
		for(MultipartFile tmpFile : files) {
			//첨부파일이 있고, 점푸 파일 이름이 1글자 이상인 경우에만 업로드
			if(tmpFile !=null && tmpFile.getOriginalFilename().length() != 0) {
				//첨부파일 업로드
				String path;
				try {
					path = UploadFileUtils.uploadFile(uploadPath, tmpFile.getOriginalFilename(), tmpFile.getBytes() );
					//DB에 저장
					FileVO fileVo =  new FileVO(tmpFile.getOriginalFilename(), path, bd_num);
					boardDao.insertFile(fileVo);
				} catch (Exception e) {
					e.printStackTrace();
				}
//					System.out.println("fileVo : "+fileVo);
				
			}
		}
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

	@Override
	public void deleteBoard(MemberVO loginUser, Integer bd_num) {
		if(loginUser == null || bd_num == null || bd_num <= 0) return ;
		BoardVO dbBoard = boardDao.selectBoard(bd_num);
		if(!dbBoard.getBd_me_id().equals(loginUser.getMe_id())) return ;
		
		boardDao.deleteBoard(bd_num);
	}

}
