package kr.green.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.practice.dao.MemberDAO;
import kr.green.practice.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{
	@Autowired
	MemberDAO memberDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public boolean signupMember(MemberVO user) {
		//전달된 user가 비어있는지, pw, id가 제대로 있는지, id와 일치하는 아이디가 있는지 확인
		MemberVO dbuser = memberDao.selectMember(user.getMe_id());
		if(user.getMe_id()==null || user==null || user.getMe_pw() == null
				|| dbuser != null) return false;
		
		String encPassword = passwordEncoder.encode(user.getMe_pw());
		user.setMe_pw(encPassword);
		memberDao.insertMember(user);
		System.out.println("회원가입 완료");
		return true;
		
		
	}

	@Override
	public MemberVO loginMember(MemberVO user) {
		//user == null인 경우 생각하기
		if(user == null || user.getMe_id()== null) return null;
		
		MemberVO dbuser = memberDao.selectMember(user.getMe_id());
		if(dbuser == null) return null;
		if(dbuser.getMe_id().equals(user.getMe_id()) 
				&& passwordEncoder.matches(user.getMe_pw(), dbuser.getMe_pw())) {
			return dbuser;
		}
		return null;
	}
	

}
