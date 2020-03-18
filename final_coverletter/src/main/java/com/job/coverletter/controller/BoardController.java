package com.job.coverletter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.job.coverletter.model.board.biz.BoardBiz;

@Controller
public class BoardController {
	// 게시판
	
	private Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired 
	private BoardBiz boardBiz;
	
	
	
	@RequestMapping(value = "/error.do", method = RequestMethod.GET)
	public void errpage() throws Exception {
		logger.info("예외 발생");
		throw new Exception();
	}
}
