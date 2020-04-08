package com.job.coverletter.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.job.coverletter.model.jobcalendar.biz.JobCalendarBiz;
import com.job.coverletter.model.jobcalendar.dto.JobCalendarDto;
import com.job.coverletter.model.joinUser.dto.JoinUserDto;
import com.job.coverletter.model.qnaboard.biz.QnaBoardBiz;
import com.job.coverletter.model.qnaboard.dto.QnaBoardDto;

@Controller
public class JobController {
	// 취업센터 : 자기소개서 작성, 포폴작성, 스피치
	private Logger logger = LoggerFactory.getLogger(JobController.class);

	@Autowired
	private CoverLetterBiz coverletterBiz;

	@Autowired
	private CompanyBiz companyBiz;

	@Autowired
	private JobCalendarBiz jobcalendarBiz;

	@Autowired
	private QnaBoardBiz qnaboardbiz;

	// 글목록(페이징기능)
	@RequestMapping(value = "/JOB_jobSearch.do", method = RequestMethod.GET)
	public String jobSearchP(Model model, @RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range) {

		logger.info("go jobSearch");

		// 총 게시글 수
		int listCnt = companyBiz.companyListCount();

		// pagination 객체생성
		MariaPagination pagination = new MariaPagination();
		// 현재페이지, 각페이지 범위 시작번호, 전체 게시물 수
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
	@RequestMapping(value = "/JOB_jobSearchRes.do", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = "application/text;charset=utf8")
	public @ResponseBody String jobSearchRes(@ModelAttribute CompanyDto jsonKey) {
		logger.info("jobSearch");

		ElasicHighLeverTemplat elastic = new ElasicHighLeverTemplat();

		String res = elastic.callSearchQuery(jsonKey);

		return res;
	}

	@RequestMapping(value = "/JOB_jobDetail.do", method = RequestMethod.GET)
	public String jobDetail(Model model, int companyseq) {
		logger.info("jobDetail");
		model.addAttribute("companydto", companyBiz.selectOne(companyseq));

		return "JOB/jobDetail";
	}

	// 즐겨찾기 등록 여부
	@RequestMapping(value = "/JOB_isJobBookmark.do", method = RequestMethod.POST)
	@ResponseBody
	public String isBookmark(@ModelAttribute("companyseq") int companyseq, HttpSession session) {
		logger.info("isJobBookmark");

		JoinUserDto userDto = (JoinUserDto) session.getAttribute("login");

		JobCalendarDto dto = new JobCalendarDto();
		dto.setCompanyseq(companyseq);
		dto.setJoinemail(userDto.getJoinemail());

		boolean isbookmark = jobcalendarBiz.isJobBookmark(dto);

		if (isbookmark) {
			return "true";
		} else {
			return "false";
		}
	}

	// 즐게찾기 추가 삭제
	@RequestMapping(value = "/JOB_jobBookmark.do", method = RequestMethod.POST)
	@ResponseBody
	public String jobBookmark(@ModelAttribute("companyseq") int companyseq, HttpSession session) {
		logger.info("jobBookmark");
		System.out.println("확인 : " + companyseq);

		CompanyDto companyDto = companyBiz.selectOne(companyseq);
		JoinUserDto userDto = (JoinUserDto) session.getAttribute("login");

		// 즐겨찾기 등록여부
		JobCalendarDto inputDto = new JobCalendarDto();
		inputDto.setCompanyseq(companyseq);
		inputDto.setJoinemail(userDto.getJoinemail());

		boolean isbookmark = jobcalendarBiz.isJobBookmark(inputDto);

		if (isbookmark) {
			JobCalendarDto dto = new JobCalendarDto();
			dto.setJoinemail(userDto.getJoinemail());
			dto.setCompanyseq(companyseq);
			dto.setCompanyname(companyDto.getCompanyname());
			dto.setBusiness(companyDto.getBusiness());
			dto.setEnddate(companyDto.getEnddate());

			int res = jobcalendarBiz.boardJobInsert(dto);
			if (res > 0) {
				return "insertSuccess";
			} else {
				return "insertFail";
			}
		} else {
			JobCalendarDto deleteDto = new JobCalendarDto();
			deleteDto.setCompanyseq(companyseq);
			deleteDto.setJoinemail(userDto.getJoinemail());

			int res = jobcalendarBiz.bookmarkDelete(deleteDto);
			if (res > 0) {
				return "deleteSuccess";
			} else {
				return "deleteFail";
			}
		}
	}

	@RequestMapping(value = "/JOB_jobCenter.do")
	public String jobCenter() {
		return "JOB/jobCenter";
	}

	@RequestMapping(value = "USER_speechForm.do")
	public String jobSpeech(Model model) {
		
		int count = qnaboardbiz.boardQnaListCount();
		System.out.println(count);
		
		model.addAttribute("count",count);
		return "USER/userSpeech";
	}

}
