package com.job.coverletter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.job.coverletter.model.joinUser.biz.JoinUserBiz;

@Controller
public class UserController {
	// 로그인, 회원가입, 마이페이지, 이력작성, 캘린더, 관심공고, 비번 
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private JoinUserBiz joinUserBiz;
	
	
	@RequestMapping(value="/USER/userMain.do", method=RequestMethod.GET)
	public String userMain() {
		logger.info("userMain go");
		
		
		return "USER/userMain";
	}
	
	@RequestMapping(value="/USER/userDetail.do", method=RequestMethod.GET)
	public String userDetail() {
		logger.info("userDetail go");
		
		
		return "USER/userDetail";
	}
	
	
	
	
}
