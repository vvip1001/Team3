package com.job.coverletter.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.job.coverletter.all.Pagination;
import com.job.coverletter.model.board.dto.BoardDto;
import com.job.coverletter.model.coverletter.biz.CoverLetterBiz;
import com.job.coverletter.model.coverletter.dto.CoverLetterDto;
import com.job.coverletter.model.joinUser.biz.JoinUserBiz;
import com.job.coverletter.model.joinUser.dto.JoinUserDto;

@Controller
public class UserController {
	// 로그인, 회원가입, 마이페이지, 이력작성, 캘린더, 관심공고, 비번 
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private JoinUserBiz joinUserBiz;
	
	@Autowired
	private CoverLetterBiz coverletterBiz;
	
	// 로그인 기능 완성되면 로그인 세션에 있는 아이디로 바꿔야됨
	String login = "cv@email.net";
	
	//마이페이지
	@RequestMapping(value="/USER_userMain.do", method=RequestMethod.GET)
	public String userMain() {
		logger.info("userMain go");
		
		
		return "USER/userMain";
	}
	

	@RequestMapping(value="/USER_userDetail.do", method=RequestMethod.GET)
	public String userDetail() {
		logger.info("userDetail go");
		
		
		return "USER/userDetail";
	}
	
	
	@RequestMapping(value = "/MAIN_main.do")
	public String main() {
		logger.info("main page");
		
		return "MAIN/main";
	}
	
	
	// join
	@RequestMapping(value = "/USER_join.do", method = RequestMethod.GET)
	public String join() {
		logger.info("joinpage go");

		return "MAIN/join";	
	}
	
	//vaild 설정
	@GetMapping
	public String joinuser(Model model) {
		
		model.addAttribute("joinuserDto",new JoinUserDto());
		
		return "MAIN/join";
	}
	
	//email중복체크
	
		@RequestMapping(value="/USER_emailcheck.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
		@ResponseBody
		public String checkemail(@ModelAttribute("joinemail") String joinemail) {  
			logger.info("이메일중복체크");	
			String res = joinUserBiz.checkemail(joinemail);
			
			
			if(res != "중복") {
				return res; 
				
			} else {
				return res;
			}
		}
	
	@RequestMapping(value = "/USER_joinRes.do", method = RequestMethod.POST)
	public String joinRes(Model model, @ModelAttribute("joinuserDto") @Valid JoinUserDto dto, BindingResult result) {
		logger.info("회원가입");
		
		if(result.hasErrors()) {
			
//			//유효성오류 찍어보기 
//		List<ObjectError> list = result.getAllErrors();
//			for(ObjectError error : list) {
//				System.out.println(error);
//			}
			return "MAIN/join";
		}
		
		System.out.println("================JoinUserDto : " + dto);
		
		
		
		int res = joinUserBiz.insertUser(dto);
		
		if(res > 0) {
			return "MAIN/login";
			
		}else {
			return "MAIN/join";
		}
		
	}
	
	// login
	@RequestMapping(value = "/USER_login.do")
	public String login() {
		logger.info("login page");
		
		return "MAIN/login";
	}
	
	@RequestMapping(value = "/USER_loginAjax.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> loginAjax(HttpSession session, @RequestBody JoinUserDto dto){
		
		logger.info("login ajax로 넘겨주는 controller : " + dto);
		
		JoinUserDto loginDto = joinUserBiz.login(dto);
		
		boolean check = false;
		
		if(loginDto != null) {
			session.setAttribute("login", loginDto);
			check = true;
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		
		return map;
		
	}
	
	
	@RequestMapping(value = "/USER_logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.info("logout");
		
		session.invalidate();
		
		return "MAIN/main";
	}
	
	
	/*-----------------------------박하 : CV, PF 다운로드 게시판-------------------------------------*/
 	//CV(이력서)다운로드 게시판
	@RequestMapping(value = "/USER_CVList.do", method = RequestMethod.GET)
	public String CVList(@ModelAttribute("CoverLetterDto") CoverLetterDto dto, @RequestParam(defaultValue = "1") int curPage,
			HttpServletRequest request, Model model) {
 		
		// CVCATEGORY = CV
		dto.setCvcategory("CV");
		dto.setJoinemail(login);
		
		//총 게시글 수
		int listCnt = coverletterBiz.CVListCount(dto);
		
		//페이징 (시작글번호, 표시될 게시글) : 연산해서 쿼리문에 사용
		Pagination pagination = new Pagination(listCnt, curPage);
		dto.setStartIndex(pagination.getStartIndex());
		dto.setCntPerPage(pagination.getPageSize() * curPage);

		List<CoverLetterDto> list = coverletterBiz.CVList(dto);

		model.addAttribute("CVList", list);
		model.addAttribute("listCnt", listCnt);
		model.addAttribute("pagination", pagination);

 		return "USER/userCVdown";
 	}
	
	//PF(포트폴리오)다운로드 게시판
	@RequestMapping(value = "/USER_PFList.do", method = RequestMethod.GET)
	public String PFList(@ModelAttribute("CoverLetterDto") CoverLetterDto dto, @RequestParam(defaultValue = "1") int curPage,
			HttpServletRequest request, Model model) {
 		
		// CVCATEGORY = PF
		dto.setCvcategory("PF");
		dto.setJoinemail(login);
		
		//총 게시글 수
		int listCnt = coverletterBiz.CVListCount(dto);
		
		//페이징 (시작글번호, 표시될 게시글) : 연산해서 쿼리문에 사용
		Pagination pagination = new Pagination(listCnt, curPage);
		dto.setStartIndex(pagination.getStartIndex());
		dto.setCntPerPage(pagination.getPageSize() * curPage);

		List<CoverLetterDto> list = coverletterBiz.CVList(dto);

		model.addAttribute("PFList", list);
		model.addAttribute("listCnt", listCnt);
		model.addAttribute("pagination", pagination);

 		return "USER/userPFdown";
	}
	
	//다중삭제
	@RequestMapping(value = "/USER_CVMultiDelete.do", method = RequestMethod.POST)
	public String CVMultiDelete(@RequestParam(name = "chk") String[] coverletterseq) {
		coverletterBiz.CVMultiDelete(coverletterseq);
		return "redirect:/CVList.do";
	}
	
}
