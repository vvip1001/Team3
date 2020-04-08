package com.job.coverletter.controller;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.aspectj.org.eclipse.jdt.internal.compiler.batch.Main;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.google.gson.JsonObject;
import com.job.coverletter.all.Pagination;
import com.job.coverletter.all.util.MultiRowTarget;
import com.job.coverletter.model.coverletter.biz.CoverLetterBiz;
import com.job.coverletter.model.coverletter.dto.CoverLetterDto;
import com.job.coverletter.model.jobcalendar.biz.JobCalendarBiz;
import com.job.coverletter.model.jobcalendar.dto.JobCalendarDto;
import com.job.coverletter.model.joinUser.biz.JoinUserBiz;
import com.job.coverletter.model.joinUser.biz.JoinUserBizImpl;
import com.job.coverletter.model.joinUser.dto.JoinUserDto;
import com.job.coverletter.model.qnaboard.biz.QnaBoardBiz;
import com.job.coverletter.model.qnaboard.dto.QnaBoardDto;
import com.job.coverletter.model.school.dto.SchoolDto;
import com.job.coverletter.model.total.biz.TotalBiz;
import com.job.coverletter.model.total.biz.TotalBizImpl;
import com.job.coverletter.model.total.dto.TotalDto;
import com.job.coverletter.model.skill.biz.SkillBiz;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class UserController {
	// 로그인, 회원가입, 마이페이지, 이력작성, 캘린더, 관심공고, 비번
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private JoinUserBiz joinUserBiz;

	@Autowired
	private TotalBiz totalBiz;

	@Autowired
	private JobCalendarBiz jobCalendarBiz;

	String cvcategory = "";
	String joinemail = "USER@GMAIL.COM";

	@Autowired
	private CoverLetterBiz coverletterBiz;

	@Autowired
	private SkillBiz skillBiz;
	
	@Autowired
	private QnaBoardBiz qnaboardbiz;

	// ==================================================================================

	// join go
	@RequestMapping(value = "/USER_join.do", method = RequestMethod.GET)
	public String join(Model model) {
		logger.info("joinpage go");
		model.addAttribute("JoinUserDto", new JoinUserDto());
		return "MAIN/join";
	}

	// 회원가입 res
	@RequestMapping(value = "/USER_joinRes.do", method = RequestMethod.POST)
	public String joinRes(Model model, @ModelAttribute("JoinUserDto") @Valid JoinUserDto dto, BindingResult result, Map<String,BindingResult> model2) throws Exception {
		logger.info("joinRes.do");

		model.addAttribute("joinuserDto", dto);
		model2.put(BindingResult.class.getName()+"JoinuserDto",result);
		System.out.println("===============joinuserDto" + dto);

		if (result.hasErrors()) {

			logger.info("유효성검사실행");
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				System.out.println(error);
			}
			return "MAIN/join";

		} else {
			logger.info("유효성검사통과");
			int res = joinUserBiz.insertUser(dto);

			if (res > 0) {

				// 가입한 유저정보 불러오기
				JoinUserDto userDto = joinUserBiz.login(dto);

				TotalDto totalDto = new TotalDto();
				totalDto.setJoinseq(userDto.getJoinseq());
				totalDto.setJoinemail(userDto.getJoinemail());
				totalDto.setJoinname(userDto.getJoinname());
				totalDto.setJoinpw(userDto.getJoinpw());
				totalDto.setJoinbirth(userDto.getJoinbirth());
				totalDto.setJoinsex(userDto.getJoinsex());
				totalDto.setPhoto("");
				totalDto.setMililtary("");
				totalDto.setPhone("");
				totalDto.setAddress("");
				totalDto.setKakao("");
				totalDto.setSingup(dto.getSingup());
				// totalDto.setSkillseq(0);
				totalDto.setCategory("");
				totalDto.setItskill1("");
				totalDto.setItskill2("");
				totalDto.setItskill3("");
				totalDto.setItskill4("");
				totalDto.setItskill5("");
				totalDto.setItscore1("");
				totalDto.setItscore2("");
				totalDto.setItscore3("");
				totalDto.setItscore4("");
				totalDto.setItscore5("");
				totalDto.setCertificate("");
				totalDto.setLanguagename("");
				totalDto.setLanguagescore("");
				totalDto.setLanguageregdate("");
				totalDto.setContest("");
				totalDto.setPrize("");
				totalDto.setOrganization("");
				totalDto.setStartorganization("");
				totalDto.setRegdate("");
				// totalDto.setSchoolseq(0);
				totalDto.setCareer("");
				totalDto.setSchoolname("");
				totalDto.setAdmission("");
				totalDto.setGraduate("");
				totalDto.setMajor("");
				totalDto.setGrade("");

				int totalRes = totalBiz.ToTalInsert(totalDto);

				if (totalRes > 0) {
					logger.info("Total 테이블 추가 성공");
					return "MAIN/login";
				} else {
					logger.info("Total 테이블 추가 실패");
					return "MAIN/login";
				}
			} else {
				return "MAIN/join";
			}
		}
	}

	// 회원가입용 이메일 인증 팝업
	@RequestMapping(value = "/USER_emailcheckpopup.do", method = RequestMethod.GET)
	public String emailpopup() {
		logger.info("회원가입 이메일 인증 팝업!");
		return "MAIN/emailChk";
	}

	// 이메일 전송 화면으로
	@RequestMapping(value = "/USER_mailSend.do", method = RequestMethod.POST)
	public String mailSend(Model model, String EmailName) {
		logger.info("mailSend");
		model.addAttribute("EmailName", EmailName);
		return "MAIN/mailSend";
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

	// sns로그인
	@RequestMapping(value = "/USER_snslogin.do", method = RequestMethod.POST)
	public String snslogin(HttpSession session, JoinUserDto dto) {
		logger.info("sns로그인");
		logger.info("=========dto: " + dto.getJoinemail());

		JoinUserDto onelogin = joinUserBiz.selectOne(dto.getJoinemail());
		logger.info("******onelogin: " + onelogin);

		JoinUserDto snslogin = joinUserBiz.login(dto);
		logger.info("login:" + snslogin);

		if (onelogin != null) {
			session.setAttribute("snslogin", snslogin);
			return "MAIN/main";

		} else {
			int snsjoin = joinUserBiz.insertUser(dto);
			if (snsjoin > 0) {
				session.setAttribute("snslogin", snslogin);
				return "MAIN/main";
			} else {
				return "MAIN/login";
			}
		}
	}

	// 아이디 찾기 이메일 인증 팝업
	@RequestMapping(value = "/USER_emailcheckpopup_login.do", method = RequestMethod.GET)
	public String emailpopup_login() {
		logger.info("아이디찾기 이메일 인증 팝업!");
		return "MAIN/emailChk_login";
	}

	// 아이디비밀번호찾기(비밀번호 수정)
	@RequestMapping(value = "/USER_changepw.do", method = RequestMethod.POST, headers = "content-type=application/x-www-form-urlencoded")
	public String findidpw(Model model, JoinUserDto dto) {
		logger.info("아이디 비밀번호 찾기" + dto);
		int res = joinUserBiz.updateJoinuser(dto);

		if (res > 0) {
			logger.info("비밀번호 변경 성공");
			return "MAIN/login";
		} else {
			logger.info("비밀번호 변경 실패");
			model.addAttribute("joinuserDto", dto);
			return "MAIN/login";
		}
	}

	// 로그아웃
	@RequestMapping(value = "/USER_logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.info("logout");

		session.invalidate();

		return "MAIN/main";
	}

	/*-----------------------비밀번호 변경----------------------*/
	@RequestMapping(value = "USER_PwChange.do", method = RequestMethod.POST)
	@ResponseBody
	public String Pwchange(HttpServletRequest request) {
		String pw = request.getParameter("pw");
		String pwConfirm = request.getParameter("pwConfirm");
		String email = request.getParameter("email");
		JoinUserDto dto = new JoinUserDto(email, pw);

		int res = 0;
		if (pw.equals(pwConfirm)) {

			res = joinUserBiz.updateJoinuser(dto);
			if (res > 0) {
				return "true";
			} else {
				return "false";
			}
		} else {
			return "cancle";
		}
	}

	/*----------------------회원탈퇴--------------------*/
	@RequestMapping(value = "USER_withdraw.do")
	public String withdraw(HttpServletRequest request) {
		String email = request.getParameter("email");
		logger.info(email);
		int res = joinUserBiz.deletejoinuser(email);
		if (res > 0) {
			return "redirect:index.jsp";
		} else {
			return "USER_userMain.do";
		}
	}

//==============================재현 회원가입 수정함=========================================

	// 마이페이지
	@RequestMapping(value = "/USER_userMain.do", method = RequestMethod.GET)
	public String userMain(Model model, HttpSession session) {
		logger.info("userMain go");

		JoinUserDto userDto = (JoinUserDto) session.getAttribute("login");
		
		CoverLetterDto cvdto = new CoverLetterDto();
		cvdto.setCvcategory("자소서");
		cvdto.setJoinemail(userDto.getJoinemail());
		int cvlist = coverletterBiz.boardCVListCount(cvdto);
		System.out.println("cvlist : " + cvlist);
		CoverLetterDto pfdto = new CoverLetterDto();
		pfdto.setCvcategory("포폴");
		pfdto.setJoinemail(userDto.getJoinemail());
		int pflist = coverletterBiz.boardPFListCount(pfdto);
		System.out.println("pflist : " + pflist);

		JobCalendarDto jbdto = new JobCalendarDto();
		jbdto.setJoinemail(userDto.getJoinemail());
		int jblist = jobCalendarBiz.boardJobListCount(jbdto);
		System.out.println("jblist : " + jblist);

		model.addAttribute("cvlist", cvlist);
		model.addAttribute("pflist", pflist);
		model.addAttribute("jblist", jblist);

		// IT역량 차트
		JSONArray itSkill = totalBiz.selectItSkill();
		model.addAttribute("itSkill", itSkill);

		// 스펙 차트
		JSONArray mySkill = totalBiz.selectMySkill();
		model.addAttribute("mySkill", mySkill);

		return "USER/userMain";
	}

	// fullCalendar 데이터 불러오기
	@RequestMapping(value = "/USER_getFullCalendarData.do", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Map<String, List<Map<String, String>>> getFullCalendarData(HttpSession session) {
		logger.info("getFullCalendarData");

		JoinUserDto userDto = (JoinUserDto) session.getAttribute("login");

		// 마감일이 수시채용이 아닌 dto 리스트
		List<JobCalendarDto> list = jobCalendarBiz.getFullCalendarData(userDto.getJoinemail());

		// [{title : 'All Day Event', start : '2020-02-01'}]

		List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();

		for (JobCalendarDto dto : list) {
			Map<String, String> tem = new HashMap<String, String>();
			String enddate = dto.getEnddate();
			String[] mmdd = enddate.split("/");
			String day = mmdd[1].substring(0, 2);
			enddate = "2020-" + mmdd[0] + "-" + day;

			tem.put("title", dto.getBusiness());
			tem.put("start", enddate);
			tem.put("end", enddate);
			tem.put("companyseq", dto.getCompanyseq() + "");

			dataList.add(tem);
		}

		Map<String, List<Map<String, String>>> res = new HashMap<String, List<Map<String, String>>>();
		res.put("data", dataList);

		return res;
	}

	// 유저 인적사항
	@RequestMapping(value = "/USER_userDetail.do", method = RequestMethod.GET)
	public String userDetail(Model model, HttpSession session) {
		logger.info("userDetail go");

		JoinUserDto userDto = (JoinUserDto) session.getAttribute("login");

		TotalDto totalDto = totalBiz.selectOne(userDto.getJoinemail());
		model.addAttribute("totalDto", totalDto);

		// model.addAttribute("totalDto", new TotalDto());

		return "USER/userDetail";
	}

	// 도로명 주소 API
	@RequestMapping(value = "/Address.do")
	public String address() {
		return "USER/userDetail_Address";
	}

	// 인적사항 수정
	@RequestMapping(value = "/USER_detailRes.do", method = RequestMethod.POST)
	public String personal_insert(Model model, @ModelAttribute("totalDto") @Valid TotalDto dto, BindingResult result) {
		if (result.hasErrors()) {
			logger.info("유효성검사 실패");
			logger.info(dto.getJoinname());
			logger.info(dto.getCertificate());
			logger.info(dto.getRegdate());
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				System.out.println(error);
			}
			return "USER/userDetail";
		} else {
			logger.info("유효성 검사 통과");
			logger.info(dto.getCertificate());
			logger.info(dto.getRegdate());
			int res = totalBiz.updateOne(dto);
			System.out.println(res);
			if (res > 0) {

				return "redirect:USER_userMain.do";
			} else {
				return "USER/userDetail";
			}
		}
	}

	/*--------------------------------- 이력서 자기소개서 채용공고 게시판 ----------------------------------------------------------------------------------------------------*/
	// 이력서(자기소개서) 게시판
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

	// 이력서(자기소개서) 파일 다운로드
	@RequestMapping(value = "/CVdownload.do", method = RequestMethod.POST)
	@ResponseBody
	public byte[] CVfileDownload(HttpServletRequest request, HttpServletResponse response, String name) {
		// 연속적인 바이트들의 흐름 : byte[]
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
	
	
	@RequestMapping(value="/USER_boardCVDetail.do", method = RequestMethod.GET)
	public String boardCVDetail() {
		logger.info("boardCVDetail");
		
		return "USER/userCVDetail";
	}
	
	
	// 자기소개서 삭제
	@RequestMapping(value = "/USER_userCVdelete.do", method = RequestMethod.POST)
	public String boardCVDelete(@RequestParam(name = "chk") String[] seq) {
		coverletterBiz.CVdelete(seq);
		return "redirect:/USER_userCVList.do";
	}

	// 포트폴리오 게시판
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

	// 포트폴리오 파일 다운로드
	@RequestMapping(value = "/PFdownload.do", method = RequestMethod.POST)
	@ResponseBody
	public byte[] PFfileDownload(HttpServletRequest request, HttpServletResponse response, String name) {
		// 연속적인 바이트들의 흐름 : byte[]
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

	// 포토폴리오 삭제
	@RequestMapping(value = "/USER_userPFdelete.do", method = RequestMethod.POST)
	public String boardPFDelete(@RequestParam(name = "chk") String[] seq) {

		coverletterBiz.PFdelete(seq);

		return "redirect:/USER_userPFList.do";
	}

	// 채용즐겨찾기 게시판
	@RequestMapping(value = "/USER_userJobList.do")
	public String BoardJobList(@ModelAttribute("JobCalendarDto") JobCalendarDto jobcalendarDto,
			@RequestParam(defaultValue = "1") int curPage, HttpSession session, Model model) {
		logger.info("JobBoardList");

		JoinUserDto userDto = (JoinUserDto) session.getAttribute("login");

		jobcalendarDto.setJoinemail(userDto.getJoinemail());

		int listCnt = jobCalendarBiz.boardJobListCount(jobcalendarDto);

		// 페이징 (시작글번호, 표시될 게시글) : 연산해서 쿼리문에 사용
		Pagination pagination = new Pagination(listCnt, curPage);
		jobcalendarDto.setStartIndex(pagination.getStartIndex());
		jobcalendarDto.setCntPerPage(pagination.getPageSize() * curPage);
		List<JobCalendarDto> list = jobCalendarBiz.boardJobList(jobcalendarDto);

		model.addAttribute("boardList", list);
		model.addAttribute("listCnt", listCnt);
		model.addAttribute("pagination", pagination);

		return "USER/userJob";
	}

	/*------------------------ 박하 : 자기소개서 작성 --------------------------*/
	// 자기소개서 작성 페이지
	@RequestMapping(value = "/USER_userCVwriteForm.do")
	public String CVWriteForm(Model model) {
		// CoverLetterDto dto = new CoverLetterDto();
		// model.addAttribute("CoverLetterDto", dto);
		// MultiRowTarget targets = new MultiRowTarget();
		// model.addAttribute("MultiRowTarget", targets);
		return "USER/userCVwrite";
	}

	// 자기소개서 INSERT
	@RequestMapping(value = "/USER_userCVinsert.do", method = RequestMethod.POST)
	public String CVWriteInsert(Model model, @ModelAttribute("MultiRowTarget") MultiRowTarget targets) {

		if (targets.getTargets().size() != 1) {
			for (int i = 0; i < targets.getTargets().size(); i++) {
				// 첫번째 값
				String title = targets.getTargets().get(0).getTitle();

				// 나머지 list(dto)에다 설정 set
				targets.getTargets().get(i).setTitle(title);
				targets.getTargets().get(i).setJoinemail(joinemail);
				int res = coverletterBiz.CVinsert(targets.getTargets().get(i));
			}
		}

		return "redirect:/JOB_jobCenter.do";
	}
	/*------------------------ 형권 : 스피치 작성 --------------------------*/
	@RequestMapping(value = "USER_question.do", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public String question(@RequestBody QnaBoardDto dto) {

		String res = "";

		QnaBoardDto list = qnaboardbiz.boardQnaListOne(dto.getqnaboardseq());

		res = String.valueOf(list.getQuestion());
		return res;
	}

	/*---------------------정답 확인--------------------- */
	@RequestMapping(value = "USER_answer.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> answer(@RequestBody QnaBoardDto dto) {

		Map<String, String> map = new HashMap<String, String>();

		String result = "";

		int num = dto.getqnaboardseq();

		String userAnswer[] = dto.getAnswer().split(" ");
		QnaBoardDto AnswerDto = qnaboardbiz.QnaAnswer(num);

		String Answer[] = String.valueOf(AnswerDto.getAnswer()).split(" ");
		Arrays.sort(userAnswer);
		Arrays.sort(Answer);

		int answerCnt = 0; // 정답 개수
		int WronganswerCnt = 0; // 오답 개수
		if (userAnswer.length == Answer.length) {

			for (int i = 0; i < Answer.length; i++) {

				if (userAnswer[i].equals(Answer[i])) {
					answerCnt++;
				} else {
					WronganswerCnt++;
				}
			}
			result = (answerCnt == Answer.length ? "정답" : "오답");
		} else {
			result = "오답";
		}
		map.put("result", result);
		map.put("answer", String.valueOf(AnswerDto.getAnswer()));

		return map;
	}
}
