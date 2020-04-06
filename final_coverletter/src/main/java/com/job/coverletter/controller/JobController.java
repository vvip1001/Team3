package com.job.coverletter.controller;


import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.job.coverletter.Elastic.ElasicrowAPI;
import com.job.coverletter.Elastic.ElasicHighLeverTemplat;
import com.job.coverletter.Elastic.ElasticSpringExampleApplication;
import com.job.coverletter.all.Pagination;
import com.job.coverletter.all.pagination.MariaPagination;
import com.job.coverletter.all.util.MyUtil;
import com.job.coverletter.model.board.dto.BoardDto;
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
	

	
	// 글목록(페이징기능)
	@RequestMapping(value = "/JOB_jobSearch.do", method = RequestMethod.GET)
	public String jobSearchP(Model model, 
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range) {
		
		logger.info("go jobSearch");
		
		// 총 게시글 수
		int listCnt = companyBiz.companyListCount();
		
		//pagination 객체생성
		MariaPagination pagination = new MariaPagination();
							 //현재페이지, 각페이지 범위 시작번호, 전체 게시물 수
		pagination.pageInfo(page, range, listCnt); 
	

		List<CompanyDto> companyList = companyBiz.selectList(pagination);
		
		List<CompanyDto> newCompanyList = new ArrayList<CompanyDto>();
		
		for (CompanyDto dto : companyList) {
			System.out.println(dto);
			String business = MyUtil.StringCut(45, dto.getBusiness());
			String oneintro = MyUtil.StringCut(50, dto.getOneintro());
			String mainfield = MyUtil.StringCut(50, dto.getMainfield());
			String languages = MyUtil.StringCut(50, dto.getLanguages());
			String location = MyUtil.StringCut(17, dto.getLocation());
			dto.setBusiness(business);
			dto.setOneintro(oneintro);
			dto.setMainfield(mainfield);
			dto.setLanguages(languages);
			dto.setLocation(location);

			newCompanyList.add(dto);
		}
		

		model.addAttribute("newCompanyList", newCompanyList);
		model.addAttribute("listCnt", listCnt);
		model.addAttribute("pagination", pagination);

		return "JOB/jobSearch";
	}

	
	
	// ajax 검색기능
	@RequestMapping(value="/JOB_jobSearchRes.do", method= RequestMethod.POST, 
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
		    produces = "application/text;charset=utf8")
	public @ResponseBody String jobSearchRes(@ModelAttribute CompanyDto jsonKey) {
		logger.info("검색 테스트 : " + jsonKey);
		
		ElasicHighLeverTemplat elastic = new ElasicHighLeverTemplat();
		
		String res = elastic.callSearchQuery(jsonKey);
		
		return res;
	}
	
	
	//로그인 기능 완성되면 로그인 세션에 있는 아이디로 바꿔야됨
	String login = "mint@email.com";
	

	@RequestMapping(value = "/JOB_jobCenter.do")
	public String jobCenter() {
		return "JOB/jobCenter";
	}
	
	@RequestMapping(value = "/USER_speechForm.do")
	public String jobSpeech() {
		return "USER/userSpeech";
	}
	
}
