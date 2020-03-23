package com.job.coverletter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.job.coverletter.model.company.biz.CompanyBiz;
import com.job.coverletter.model.company.dto.CompanyDto;

@Controller
public class MainController {
	// 메인, 기업상세정보, 기업검색, 지도, 결제 
	private Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private CompanyBiz companyBiz;
	
	
	@RequestMapping(value="MAIN_main.do", method=RequestMethod.GET)
	public String selectOne(Model model) {
		logger.info("Main go");
		return "MAIN/main";
	}
	
	
	
	
	
	

}
