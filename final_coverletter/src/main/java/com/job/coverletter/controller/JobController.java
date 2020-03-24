package com.job.coverletter.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.job.coverletter.all.util.MyUtil;
import com.job.coverletter.model.company.biz.CompanyBiz;
import com.job.coverletter.model.company.dto.CompanyDto;
import com.job.coverletter.model.coverletter.biz.CoverLetterBiz;

@Controller
public class JobController {
	// 취업센터 : 자기소개서 작성, 포폴작성, 스피치
	private Logger logger = LoggerFactory.getLogger(JobController.class);	
	
	@Autowired
	private CoverLetterBiz coverletterBiz;
	
	@Autowired
	private CompanyBiz companyBiz;
	
	

	@RequestMapping(value="JOB_jobSearch.do", method=RequestMethod.GET) 
	public String jobSearch(Model model) {
		logger.info("go jobSearch");
		
		// 전체리스트
		List<CompanyDto> companyList = companyBiz.selectList();
		// 새로담을 리스트
		List<CompanyDto> newCompanyList = new ArrayList<CompanyDto>();
		
		for(CompanyDto dto : companyList) {
			String business = MyUtil.StringCut(50, dto.getBusiness());
			String oneintro = MyUtil.StringCut(50, dto.getOneintro());
			String languages = MyUtil.StringCut(50, dto.getLanguages());
			String location = MyUtil.StringCut(17, dto.getLocation());
			dto.setBusiness(business);
			dto.setOneintro(oneintro);
			dto.setLanguages(languages);
			dto.setLocation(location);
			
			newCompanyList.add(dto);
		}
		model.addAttribute("newCompanyList", newCompanyList);
		return "JOB/jobSearch";
	}
}
