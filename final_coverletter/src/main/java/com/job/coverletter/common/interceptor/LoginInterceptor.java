package com.job.coverletter.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	// 컨트롤러가 핸들러 매핑되기 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("[Interceptor] preHandle");
		// spring 3.2 이상부터는 servlet-context.xml에서
		// <exclude-mapping-path>태그를 통해 설정할 수 있다
		
//		if(request.getSession().getAttribute("login") != null) { 
//			return true; 
//		}else {
//			response.sendRedirect("/MAIN_main.do");
//		}
//		if (
//				request.getRequestURI().contains("/MAIN_main.do") || 
//				request.getRequestURI().contains("/MAIN_mainDetail.do") ||
//				request.getRequestURI().contains("/JOB_jobSearch.do") ||
//				request.getRequestURI().contains("/USER_join.do") ||
//				request.getRequestURI().contains("/USER_joinRes.do") ||
//				request.getRequestURI().contains("/USER_emailcheckpopup.do") ||
//				request.getRequestURI().contains("/USER_mailSend.do") ||
//				request.getRequestURI().contains("/USER_emailcheck.do") ||
//				request.getRequestURI().contains("/USER_login.do") ||	
//				request.getRequestURI().contains("/USER_snslogin.do") ||	
//				request.getRequestURI().contains("/USER_emailcheckpopup_login.do") ||	
//				request.getRequestURI().contains("/USER_changepw.do")) {
//			return true; // 컨트롤러로 보내어 정상흐름 실행.
//		}

		
		
		return true; // DispatcherServlet >> preHandle()가 return false; @controller로 가는것을 막는다.
	}

	// controller가 rendering(서버에서 jsp 컴파일 되기전에)되기전에 >> view로 변환되기 전을 의미
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//logger.info("[Interceptor] postHandle");
	}

	// view rendering된 후 (서버에서 문서화 된 후)
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//logger.info("[Interceptor] afterCompletion");
	}

}
