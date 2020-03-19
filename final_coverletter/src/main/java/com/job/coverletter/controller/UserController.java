package com.job.coverletter.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.job.coverletter.model.joinUser.biz.JoinUserBiz;
import com.job.coverletter.model.joinUser.dto.JoinUserDto;

@Controller
public class UserController {
	// 로그인, 회원가입, 마이페이지, 이력작성, 캘린더, 관심공고, 비번 
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private JoinUserBiz joinUserBiz;
	
	//마이페이지
	@RequestMapping(value="/USER/userMain.do", method=RequestMethod.GET)
	public String userMain() {
		logger.info("userMain go");
		
		
		return "USER/userMain";
	}
	
	@RequestMapping(value = "/MAIN/main.do")
	public String main() {
		logger.info("main page");
		
		return "MAIN/main";
	}
	
	
	// join
	@RequestMapping(value = "/MAIN/join.do", method = RequestMethod.GET)
	public String join() {
		logger.info("joinpage go");

		return "MAIN/join";	
	}
	
	@RequestMapping(value = "/MAIN/joinRes.do", method = RequestMethod.POST)
	public String joinRes(Model model, JoinUserDto dto) {
		logger.info("회원가입");
		
		int res = joinUserBiz.insertUser(dto);
		
		if(res > 0) {
			return "MAIN/login";
			
		}else {
			return "MAIN/join";
		}
		
	}
	
	
	// login
	@RequestMapping(value = "/MAIN/login.do")
	public String login() {
		logger.info("login page");
		
		return "MAIN/login";
	}
	
	@RequestMapping(value = "/loginAjax.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> loginAjax(HttpSession session, @RequestBody JoinUserDto dto){
		
		logger.info("login ajax로 넘겨주는 controller : " + dto);
		
		JoinUserDto res = joinUserBiz.login(dto);
		
		boolean check = false;
		
		if(res != null) {
			session.setAttribute("login", res);
			check = true;
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		
		return map;
	}
	
	
	@RequestMapping(value = "/MAIN/logout.do")
	public String logout(HttpSession session) {
		logger.info("logout");
		
		session.invalidate();
		
		return "MAIN/main";
	}
	
 	
}
