package kr.green.practice.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.practice.service.MemberService;
import kr.green.practice.vo.MemberVO;

@Controller
public class HomeController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv, HttpServletRequest request) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		System.out.println(user);
		mv.setViewName("/main/home");
		return mv;
	}
	
	
	//회원가입 get
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv) {
		mv.setViewName("/member/signup");
		return mv;
	}
	//회원가입 post
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, MemberVO user) {
		System.out.println("Ate Controller user : "+user);
		if(!memberService.signupMember(user)) {
			mv.addObject(user);
			mv.setViewName("/member/signup");
		}else {
			memberService.signupMember(user);
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	
	//로그인 get
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv) {
		mv.setViewName("/member/login");
		return mv;
	}
	//로그인 post
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, MemberVO user) {
		//login되면 true, 안되면 false
		MemberVO loginMember = memberService.loginMember(user);
		System.out.println(loginMember);
		if(loginMember == null) {
			System.out.println("로그인실패");
			mv.setViewName("redirect:/login");
		}else {
			System.out.println("로그인 성공");
			mv.addObject("user", loginMember);
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	
}
