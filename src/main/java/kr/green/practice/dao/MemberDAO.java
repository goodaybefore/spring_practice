package kr.green.practice.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.practice.vo.MemberVO;

public interface MemberDAO {

	MemberVO selectMember(@Param("me_id")String me_id);

	void insertMember(@Param("user")MemberVO user);


}
