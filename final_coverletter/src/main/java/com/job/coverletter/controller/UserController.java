package com.job.coverletter.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.job.coverletter.all.Pagination;
import com.job.coverletter.model.coverletter.biz.CoverLetterBiz;
import com.job.coverletter.model.coverletter.dto.CoverLetterDto;
import com.job.coverletter.model.jobcalendar.biz.JobCalendarBiz;
import com.job.coverletter.model.jobcalendar.dto.JobCalendarDto;
import com.job.coverletter.model.joinUser.biz.JoinUserBiz;
import com.job.coverletter.model.joinUser.dto.JoinUserDto;
import com.job.coverletter.model.skill.biz.SkillBiz;

import net.sf.json.JSONArray;

@Controller
public class UserController {
	// 로그인, 회원가입, 마이페이지, 이력작성, 캘린더, 관심공고, 비번 , 이력서 게시판 , 포트폴리오 게시판
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private JoinUserBiz joinUserBiz;

	@Autowired
	private JobCalendarBiz jobCalendarBiz;
	

	String cvcategory = "";
	String joinemail = "UESR@GMAIL.COMM";

	
	@Autowired
	private CoverLetterBiz coverletterBiz;
	
	@Autowired
	private SkillBiz skillBiz;
	
	// 로그인 기능 완성되면 로그인 세션에 있는 아이디로 바꿔야됨
	String login = "cv@email.net";
	
	//마이페이지
	@RequestMapping(value="/USER_userMain.do", method=RequestMethod.GET)
	public String userMain(Model model) {
		logger.info("userMain go");
		
		// IT역량 차트
		JSONArray itSkill = skillBiz.selectItSkill();
		model.addAttribute("itSkill", itSkill);
		
		// 스펙 차트
		JSONArray mySkill = skillBiz.selectMySkill();
		model.addAttribute("mySkill", mySkill);
		
		return "USER/userMain";
	}

	@RequestMapping(value = "/USER_userDetail.do", method = RequestMethod.GET)
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

	// vaild 설정
	@GetMapping
	public String joinuser(Model model) {

		model.addAttribute("joinuserDto", new JoinUserDto());

		return "MAIN/join";
	}

	// email중복체크

	@RequestMapping(value = "/USER_emailcheck.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String checkemail(@ModelAttribute("joinemail") String joinemail) {
		logger.info("이메일중복체크");
		String res = joinUserBiz.checkemail(joinemail);

		if (res != "중복") {
			return res;

		} else {
			return res;
		}
	}

	@RequestMapping(value = "/USER_joinRes.do", method = RequestMethod.POST)
	public String joinRes(Model model, @ModelAttribute("joinuserDto") @Valid JoinUserDto dto, BindingResult result) {
		logger.info("회원가입");

		if (result.hasErrors()) {

//			//유효성오류 찍어보기 
//		List<ObjectError> list = result.getAllErrors();
//			for(ObjectError error : list) {
//				System.out.println(error);
//			}
			return "MAIN/join";
		}

		System.out.println("================JoinUserDto : " + dto);

		int res = joinUserBiz.insertUser(dto);

		if (res > 0) {
			return "MAIN/login";

		} else {
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
	public Map<String, Boolean> loginAjax(HttpSession session, @RequestBody JoinUserDto dto) {

		logger.info("login ajax로 넘겨주는 controller : " + dto);

		JoinUserDto loginDto = joinUserBiz.login(dto);

		boolean check = false;

		if (loginDto != null) {
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

	// 글목록(페이징기능) , 이력서(자기소개서) 게시판
	@RequestMapping(value = "/USER_userCVList.do")
	public String boardListCV(@ModelAttribute("CoverLetterDto") CoverLetterDto dto,
			@RequestParam(defaultValue = "1") int curPage, HttpServletRequest request, Model model) {
		cvcategory = "자소서";

		dto.setCvcategory(cvcategory);
		dto.setJoinemail(joinemail);

		// 총 게시글 수
		int listCnt = coverletterBiz.boardCVListCount(dto);

		// 페이징 (시작글번호, 표시될 게시글) : 연산해서 쿼리문에 사용
		Pagination pagination = new Pagination(listCnt, curPage);
		dto.setStartIndex(pagination.getStartIndex());
		dto.setCntPerPage(pagination.getPageSize() * curPage);

		List<CoverLetterDto> list = coverletterBiz.boardCVList(dto);

		model.addAttribute("boardList", list);
		model.addAttribute("listCnt", listCnt);
		model.addAttribute("pagination", pagination);

		return "USER/userCVdown";
	}

	// 글목록(페이징기능) , 포트폴리오 게시판
	@RequestMapping(value = "/USER_userPFList.do")
	public String boardListPF(@ModelAttribute("CoverLetterDto") CoverLetterDto dto,
			@RequestParam(defaultValue = "1") int curPage, HttpServletRequest request, Model model) {
		cvcategory = "포폴";

		dto.setCvcategory(cvcategory);
		dto.setJoinemail(joinemail);

		// 총 게시글 수
		int listCnt = coverletterBiz.boardPFListCount(dto);

		// 페이징 (시작글번호, 표시될 게시글) : 연산해서 쿼리문에 사용
		Pagination pagination = new Pagination(listCnt, curPage);
		dto.setStartIndex(pagination.getStartIndex());
		dto.setCntPerPage(pagination.getPageSize() * curPage);
		List<CoverLetterDto> list = coverletterBiz.boardPFList(dto);

		model.addAttribute("boardList", list);
		model.addAttribute("listCnt", listCnt);
		model.addAttribute("pagination", pagination);

		return "USER/userPFdown";
	}

	@RequestMapping(value = "/USER_userCVdelete.do", method = RequestMethod.POST)
	public String boardCVDelete(@RequestParam(name = "chk") String[] seq) {

		coverletterBiz.CVdelete(seq);

		return "redirect:/USER_userCVList.do";
	}

	@RequestMapping(value = "/USER_userPFdelete.do", method = RequestMethod.POST)
	public String boardPFDelete(@RequestParam(name = "chk") String[] seq) {

		coverletterBiz.PFdelete(seq);

		return "redirect:/USER_userPFList.do";
	}

	@RequestMapping(value = "/USER_userJobList.do")
	public String BoardJobList(@ModelAttribute("JobCalendarDto") JobCalendarDto dto,
			@RequestParam(defaultValue = "1") int curPage, HttpServletRequest request, Model model) {
		joinemail = "USER@GMAIL.COM";
		dto.setJoinemail(joinemail);
		int listCnt = jobCalendarBiz.boardJobListCount(dto);

		// 페이징 (시작글번호, 표시될 게시글) : 연산해서 쿼리문에 사용
		Pagination pagination = new Pagination(listCnt, curPage);
		dto.setStartIndex(pagination.getStartIndex());
		dto.setCntPerPage(pagination.getPageSize() * curPage);
		List<JobCalendarDto> list = jobCalendarBiz.boardJobList(dto);

		model.addAttribute("boardList", list);
		model.addAttribute("listCnt", listCnt);
		model.addAttribute("pagination", pagination);

		return "USER/userJob";
	}
	
	// 이력서(자기소개서) 파일 다운로드
		@RequestMapping(value = "/CVdownload.do", method = RequestMethod.POST)
		@ResponseBody
		public byte[] CVfileDownload(HttpServletRequest request, HttpServletResponse response, String name) {
	//연속적인 바이트들의 흐름 : byte[] 
			byte[] down = null;
			String path;

			try {
				path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");

				File file = new File(path + "/" + name);

				down = FileCopyUtils.copyToByteArray(file);
				String filename = new String(file.getName().getBytes(), "8859_1");

				response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
				response.setContentLength(down.length);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return down;
		}
		
		// 포트폴리오 파일 다운로드
		@RequestMapping(value = "/PFdownload.do", method = RequestMethod.POST)
		@ResponseBody
		public byte[] PFfileDownload(HttpServletRequest request, HttpServletResponse response, String name) {
	//연속적인 바이트들의 흐름 : byte[] 
			byte[] down = null;
			String path;

			try {
				path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");

				File file = new File(path + "/" + name);

				down = FileCopyUtils.copyToByteArray(file);
				String filename = new String(file.getName().getBytes(), "8859_1");

				response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
				response.setContentLength(down.length);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return down;
		}
		
		/*------------------------박하 : 취업센터--------------------------------------------*/
		@RequestMapping(value = "USER_userCVwriteForm.do")
		public String CVWriteForm() {
			return "USER/userCVwrite";
		}
}
