package com.job.coverletter.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

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
import com.job.coverletter.model.coverletter.dto.CoverLetterDto;

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
		logger.info("검색 테스트 : " + jsonKey);

		ElasicHighLeverTemplat elastic = new ElasicHighLeverTemplat();

		String res = elastic.callSearchQuery(jsonKey);

		return res;
	}

	// 로그인 기능 완성되면 로그인 세션에 있는 아이디로 바꿔야됨
	String login = "mint@email.com";

	@RequestMapping(value = "JOB_jobCenter.do")
	public String jobCenter() {
		return "JOB/jobCenter";
	}

	@RequestMapping(value = "USER_speechForm.do")
	public String jobSpeech() {
		return "USER/userSpeech";
	}

	// 포폴작성
	@RequestMapping(value = "/PFinsert.do", method = RequestMethod.POST)
	@ResponseBody
	public String PFinsert(@ModelAttribute("coverLetterDto") CoverLetterDto dto, HttpServletRequest request) {
		logger.info("PFinsert_ajax");

		MultipartFile file = dto.getUploadFile();
		if (file.getSize() != 0) {
			String name = file.getOriginalFilename();
			System.out.println("----------------------------------------");

			System.out.println("file = " + file.getSize());
			try {
				System.out.println("file = " + file.getInputStream());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("name = " + name);

//			이름과 설명을 넘김.

			InputStream inputStream = null;
			OutputStream outputStream = null;

			try {
				inputStream = file.getInputStream();
				// 경로
				String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");
				System.out.println("upload real path : " + path);

				File storage = new File(path);
				if (!storage.exists()) {
					storage.mkdir();
				} // 해당 파일이 있으면 넘어간다.

				File newFile = new File(path + "/" + name);
				if (!newFile.exists()) {
					newFile.createNewFile();
				} // 새로운 파일이 없으면

				outputStream = new FileOutputStream(newFile); // 업로드 되는 파일

				int read = 0;
				byte[] b = new byte[(int) file.getSize()];
				while ((read = inputStream.read(b)) != -1) {
					outputStream.write(b, 0, read);
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("if문 들어왔다");
			dto.setFilepath(name);
			dto.setJoinemail(login);

			int res = coverletterBiz.PFwrite(dto);
			if (res > 0) {
				return "redirect:/USER_userPFwrite.do";
			} else {
				return "redirect:/PFinsert.do";
			}
		} else {
			System.out.println("else문 들어왔다");
			String name = "";
			dto.setFilepath(name);
			dto.setJoinemail(login);

			int res = coverletterBiz.PFwrite(dto);
			if (res > 0) {
				return "redirect:/USER_userPFwrite.do";
			} else {
				return "redirect:/PFinsert.do";
			}

		}
	}

}
