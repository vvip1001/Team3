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
   // 로그인, 회원가입, 마이페이지, 이력작성, 캘린더, 관심공고, 비번 
   private Logger logger = LoggerFactory.getLogger(UserController.class);
   
   @Autowired
   private JoinUserBiz joinUserBiz;
   
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
         
//         //유효성오류 찍어보기 
//      List<ObjectError> list = result.getAllErrors();
//         for(ObjectError error : list) {
//            System.out.println(error);
//         }
         return "MAIN/join";
      }
      
      System.out.println("================JoinUserDto : " + dto);
     
      int res = joinUserBiz.insertUser(dto);
      
      if(res > 0) {
         logger.info("회원가입 성공");
         return "MAIN/login";
         
      }else {
         logger.info("회원가입 실패");
         model.addAttribute("joinuserDto", dto);
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
   
   //아이디비밀번호찾기(비밀번호 수정)
   @RequestMapping(value = "/USER_changepw.do", method = RequestMethod.POST, headers = "content-type=application/x-www-form-urlencoded")
   public String findidpw(Model model, JoinUserDto dto) {
	   logger.info("아이디 비밀번호 찾기"+ dto);
	   int res = joinUserBiz.updateJoinuser(dto);
	   
	   if(res >0) {
		   logger.info("비밀번호 변경 성공");
	         return "MAIN/login";
	   }else {
		   logger.info("비밀번호 변경 실패");
		   model.addAttribute("joinuserDto", dto);
		   return "MAIN/login";
	   }
	   
	   
   }
   
   
   //로그아웃
   @RequestMapping(value = "/USER_logout.do", method = RequestMethod.GET)
   public String logout(HttpSession session) {
      logger.info("logout");
      
      session.invalidate();
      
      return "MAIN/main";
   }
   
   
   @RequestMapping(value = "/USER_emailcheckpopup.do", method = RequestMethod.GET)
   public String emailpopup() {
      logger.info("회원가입 이메일 인증 팝업!");
      return "MAIN/emailChk";
   }
   
   @RequestMapping(value = "/USER_emailcheckpopup_login.do", method = RequestMethod.GET)
   public String emailpopup_login() {
      logger.info("아이디찾기 이메일 인증 팝업!");
      return "MAIN/emailChk_login";
   }
   
   
   //이메일 전송 화면으로
   @RequestMapping(value="/USER_mailSend.do", method=RequestMethod.POST)
   public String mailSend(Model model, String EmailName) {
      logger.info("mailSend");
    
      model.addAttribute("EmailName",EmailName);
      return "MAIN/mailSend";
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
}
