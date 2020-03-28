package com.job.coverletter.controller;


import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.job.coverletter.all.Pagination;
import com.job.coverletter.all.pagination.MariaPagination;
import com.job.coverletter.all.util.MyUtil;
import com.job.coverletter.model.board.dto.BoardDto;
import com.job.coverletter.model.company.biz.CompanyBiz;
import com.job.coverletter.model.company.dto.CompanyDto;
import org.springframework.web.bind.annotation.RequestMapping;
import com.job.coverletter.all.Pagination;
import com.job.coverletter.model.board.dto.BoardDto;
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

	//@ResponseStatus(value=HttpStatus.OK)
	@RequestMapping(value="/JOB_jobSearchRes.do", method= {RequestMethod.GET, RequestMethod.POST}, produces = "application/text; charset=utf8")
	@ResponseBody
	public String jobSearchRes(@ModelAttribute("a") String a) {
		logger.info("검색 테스트 : " + a);
		String res = "{\"took\":1,\"timed_out\":false,\"_shards\":{\"total\":2,\"successful\":2,\"skipped\":0,\"failed\":0},\"hits\":{\"total\":{\"value\":2,\"relation\":\"eq\"},\"max_score\":6.4246607,\"hits\":[{\"_index\":\"nlpdb-2020.80.20.temp\",\"_type\":\"_doc\",\"_id\":\"932\",\"_score\":6.4246607,\"_source\":{\"incorporation\":\"2018-10-26\",\"business\":\"(주)미디움 블록체인 플랫폼 개발자 공개채용\",\"target\":\"신입, 경력\",\"selfgrowth\":\"도서구입 권장, 세미나 참가비 지원\",\"oneintro\":\"Chain the faith, 믿음을 연결하다. 사람과 세상의 가치를 연결하는 가장 빠르고 안전한 블록체인 생태계를 연구합니다.\\n\",\"groupno\":306,\"imgurl\":\"https://image.rocketpunch.com/company/86811/medium_logo_1583227698.png?s=400x400&t=inside\",\"workinghour\":\"자유로운 출근복장, 유연 근무, AM 10 - PM 07, 자율 출근\",\"companyseq\":932,\"intro\":\"미디움은 독자적 하드웨어 블록체인 기술로 상용 엔터프라이즈 시장에 대응하기 위한 블록체인 솔루션을 개발하고 있는 블록체인 전문기업으로, 블록체인 기술의 도입을 저해하는 기술적 한계를 극복하고 현실적으로 사용 가능한 블록체인 솔루션의 상용화를 목표로 합니다. 현재의 블록체인 시장은 개념검증(POC), R&D 수준에 정체되어 상용화단계에 이르지 …\",\"givetool\":\"최고 사양 장비, 듀얼 모니터\",\"jobdetail\":\"[Blockchain Platform 설계 / 개발]•\\t주요 담당 업무- 차세대 고성능 블록체인 플랫폼 설계 / 개발- 근무부서 : 플랫폼 개발팀•\\t모집 인원 : O명•\\t자격 요건- 블록체인 네트워크/플랫폼 설계/개발 경험-  분산시스템 / P2P네트워크 설계 / 개발 경험- 대용량 / 고성능 시스템 설계 / 개발 경험- 암호 / PKI 프로그램 설…\",\"mainbusiness\":\"(주)미디움 2020 하반기 신입/경력 블록체인 개발자를 공개채용 합니다.미디움은 독자적 하드웨어 블록체인 기술로 상용 엔터프라이즈 시장에 대응하기 위한 블록체인 솔루션을 개발하고 있는 블록체인 전문기업으로, 블록체인 기술의 도입을 저해하는 기술적 한계를 극복하고 현실적으로 사용 가능한 블록체인 솔루션의 상용화를 목표로 합니다. 미디움의 Blockc…\",\"homepage\":\"http://www.themedium.io\",\"mainfield\":\"IT, 블록체인, 블록체인/소프트웨어, 암호화폐, 정보보안, 보안솔루션, 블록체인/비트코인/소프트웨어, 블럭체인/블록체인, 생체인식, 백신, 랜섬웨어복구, 안티바이러스, 암호화폐하드웨어지갑\",\"languages\":\"Java ∙ C++ ∙ Go ∙ 블록체인 ∙ JavaScript ∙ jQuery ∙ TDD ∙ etcd ∙ dapp ∙ java framework ∙ SMART CONTRACT ∙ Docker\",\"@timestamp\":\"2020-03-20T15:43:01.696Z\",\"holiday\":\"자율 휴가제\",\"location\":\"2층\\n서울특별시 강남구 학동로 서울시 강남구 학동로 211\",\"insurance\":\"4대 보험\",\"salary\":\"협상후 책정\",\"companyname\":\"미디움\",\"enddate\":\"03/17 마감\",\"mealtime\":\"야근 식대 지원, 고급 커피 제공, 간식 무한 제공\",\"totalmember\":\"51-200명\",\"@version\":\"1\"}},{\"_index\":\"nlpdb-2020.80.20.temp\",\"_type\":\"_doc\",\"_id\":\"1445\",\"_score\":4.288458,\"_source\":{\"incorporation\":\"2016-04-12\",\"business\":\"[미니창고 다락] 풀스택 웹개발자 모집! (Web Management)\",\"target\":\"경력\",\"selfgrowth\":\"세미나 참가비 지원, 교육 지원 무제한, Culture Week, Book Club\",\"oneintro\":\"프롭테크 마켓을 만들어 가는 기업 X 미니창고 다락\\n\",\"groupno\":516,\"imgurl\":\"https://image.rocketpunch.com/company/28512/secondsyndrome-1_logo_1501327880.jpg?s=400x400&t=inside\",\"workinghour\":\"코피 터지게\",\"companyseq\":1445,\"intro\":\"(주)세컨신드롬은 환경을 재해석해서 새로운 가치를 창출하고, 첫번째보다 가치 있는 두번째 라이프를 영위할 수 있도록 하는 목표를 가진 기업입니다. 이를 위한 첫번째 프로젝트로 2016년 도시의 부족한 공간 문제를 해결하기 위해 프롭테크 솔루션 미니창고 다락을 런칭하였습니다. (http://dalock.kr) 저희는 프롭테크를 발전시켜 공간 활용의 극…\",\"givetool\":\"맥북 프로 15\\\", 듀얼 모니터, 원하시는 걸 말씀하시면 드립니다.\",\"jobdetail\":\"★ 미니창고 다락 소개 ★미니창고 다락은 프롭테크를 통해 물품을 보관하는 창고 시설입니다. (http://dalock.kr)해외에서는 셀프스토리지라는 이름으로도 알려져 있습니다. 1인 가구의 증가 및 주거 면적의 소형화와 더불어, 주거공간에 플러스될 수 있는 공간옵션이기도 합니다. 미니창고 다락은 국내에서 유일하게 카카오벤처스, SBI인베스트먼트 등…\",\"mainbusiness\":\"★ 세컨신드롬 웹개발자 ★세컨신드롬 웹개발자는 '미니창고 다락' 사업부에서 웹개발 업무를 담당합니다. 현재 홈페이지는 http://dalock.kr 이나 리뉴얼된 홈페이지(반응형)가 곧 오픈됩니다. 웹개발 업무는 크게 다음과 같습니다.1) 리뉴얼 홈페이지 유지보수 2) 리뉴얼 홈페이지 개선 3) 신규 웹애플리케이션 개발 업무에 요구되는 사항은 다음과…\",\"homepage\":\"http://dalock.kr\",\"mainfield\":\"마케팅, 플랫폼, O2O, IoT, 부동산, 커뮤니티, 물류, 공간, 프롭테크, 물류시스템, 창고, 고객상담, 셀프스토리지\",\"languages\":\"웹개발자 ∙ 풀스택개발자 ∙ Java ∙ 프론트엔드개발자 ∙ 백엔드개발자 ∙ JSP ∙ MySQL ∙ jQuery ∙ JavaScript ∙ Spring ∙ Ajax ∙ 반응형 웹 ∙ Language : java, javascript, jsp & servlet ∙ Amazon AWS ∙ devops\",\"@timestamp\":\"2020-03-20T15:43:28.141Z\",\"holiday\":\"자율 휴가제\",\"location\":\"명일동점\\n서울특별시 강동구 명일동 223-5 \\n\\n\\n코엑스점\\n서울특별시 강남구 삼성동 159 \\n\\n\\n청담점\\n서울특별시 강남구 청담동 132-17 \\n\\n\\n오목교점\\n서울특별시 영등포구 양평동2가 37-2 \\n\\n\\n잠실점\\n서울특별시 송파구 삼전동 삼학사로 47 \\n\\n\\n용산점\\n서울특별시 용산구 신계동 48 \\n\\n\\n대학로점\\n서울특별시 종로구 명륜2가 \\n\\n\\n서울숲2호점\\n서울특별시 성동구 성수동1가 서울숲2길 32-14 갤러리아포레\\n\\n\\n학동역점\\n서울특별시 강남구 논현2동 학동로 203 J빌딩\\n\\n\\n본사\\n서울특별시 강남구 역삼동 828-28 AIP빌딩 1층\\n\\n\\n공덕점\\n서울특별시 마포구 도화동 565 SNU 장학빌딩\\n\\n\\n대치점\\n서울특별시 강남구 대치동 1009-5 \\n\\n\\n서울숲점\\n서울특별시 성동구 성수1가1동 왕십리로 85 \\n\\n\\n서초점\\n서울특별시 서초구 반포대로 59 선흥빌딩\\n\\n\\n휘문고점\\n대한민국 서울특별시 강남구 역삼로 542 신사에스앤지빌딩\\n\\n\\n강남역점\\n대한민국 서울특별시 강남구 테헤란로8길 NSB빌딩\",\"insurance\":\"종합 검진 제공, 4대보험, 오예!\",\"salary\":\"4,000 - 7,000만원\",\"companyname\":\"(주)세컨신드롬\",\"enddate\":\"수시채용\",\"mealtime\":\"식비 전액 지원, 간식 무한 제공, 중식 제공, 마음껏 드세요. 우리도 먹기 위해 일해요!\",\"totalmember\":\"None\",\"@version\":\"1\"}}]}}";
		
		return res;
	}
	
	
	
	//로그인 기능 완성되면 로그인 세션에 있는 아이디로 바꿔야됨
	String login = "mint@email.com";
	

	@RequestMapping(value = "JOB_jobCenter.do")
	public String jobCenter() {
		return "JOB/jobCenter";
	}
	
}
