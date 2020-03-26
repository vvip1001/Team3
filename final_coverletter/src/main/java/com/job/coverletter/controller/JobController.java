package com.job.coverletter.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.job.coverletter.all.Pagination;
import com.job.coverletter.model.board.dto.BoardDto;
import com.job.coverletter.model.coverletter.biz.CoverLetterBiz;

@Controller
public class JobController {
	// 취업센터 : 자기소개서 작성, 포폴작성, 스피치
	private Logger logger = LoggerFactory.getLogger(JobController.class);	
	
	@Autowired
	private CoverLetterBiz coverletterBiz;
	
	//로그인 기능 완성되면 로그인 세션에 있는 아이디로 바꿔야됨
	String login = "mint@email.com";
	

	
}
