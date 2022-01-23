package kr.green.practice.service;

import kr.green.practice.vo.MemberVO;

public interface MemberService {

	boolean signupMember(MemberVO user);

	MemberVO loginMember(MemberVO user);

}
