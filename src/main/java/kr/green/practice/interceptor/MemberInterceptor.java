package kr.green.practice.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		Object user = session.getAttribute("user");

		//로그인을 했으면
		if(user == null) {
			//home 화면으로 페이지로 이동
			//가던 url로 가지않고 위에 있는 url로 이동
			response.sendRedirect(request.getContextPath()+"/board");
			return false;
		}
		return true;
	}
}
