package com.job.coverletter.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.job.coverletter.all.Pagination;
import com.job.coverletter.model.board.biz.BoardBiz;
import com.job.coverletter.model.board.dto.BoardDto;

@Controller
public class BoardController {
	// 게시판
	private Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardBiz boardBiz;
	
	//로그인 기능 완성되면 로그인 세션에 있는 아이디로 바꿔야됨
	String login = "mint@email.com";

	// 글목록(페이징기능)
	@RequestMapping(value = "/BOARD_boardList.do", method = RequestMethod.GET)
	public String boardListP(@ModelAttribute("BoardDto") BoardDto dto, @RequestParam(defaultValue="1") int curPage, HttpServletRequest request, Model model) {
		
		// 총 게시글 수
		int listCnt = boardBiz.boardListCount();
		
		// 페이징 (시작글번호, 표시될 게시글) : 연산해서 쿼리문에 사용
		Pagination pagination = new Pagination(listCnt, curPage);
		dto.setStartIndex(pagination.getStartIndex());				
        dto.setCntPerPage(pagination.getPageSize() * curPage);

		List<BoardDto> list = boardBiz.boardList(dto);
		
		model.addAttribute("boardList", list);
		model.addAttribute("listCnt", listCnt);
		model.addAttribute("pagination", pagination);
		
		return "BOARD/boardList";
	}

	// 글작성 페이지
	@RequestMapping(value = "/BOARD_boardWriteForm.do", method = RequestMethod.GET)
	public String boardWriteForm() {
		return "BOARD/boardWrite";
	}

	// 글작성
	@RequestMapping(value = "/BOARD_boardWrite.do", method = RequestMethod.POST)
	public String boardWrite(@ModelAttribute("BoardDto") BoardDto dto) {
		// 글작성자 : 로그인 완성되면 로그인 세션 아이디로 바꿔야됨
		dto.setJoinemail(login);

		int res = boardBiz.boardInsert(dto);
		if (res > 0) {
			return "redirect:/BOARD_boardList.do";
		} else {
			return "redirect:/BOARD_boardWriteForm.do";
		}
	}

	// 글상세 + 댓글상세
	@RequestMapping(value = "/BOARD_boardDetail.do", method = RequestMethod.GET)
	public String boardDetail(Model model, @ModelAttribute("BoardDto") BoardDto dto, int curPage) {
		// 글
		BoardDto boardDetail = boardBiz.boardDetail(dto);
		// 댓글
		List<BoardDto> replyList = boardBiz.replyList(dto);
		model.addAttribute("boardDetail", boardDetail);
		model.addAttribute("replyList", replyList);
		model.addAttribute("curPage", curPage);
		return "BOARD/boardDetail";
	}

	// 글수정 페이지
	@RequestMapping(value = "/BOARD_boardUpdateForm.do")
	public String boardUpdateForm(Model model, int boardseq) {
		BoardDto dto = new BoardDto();
		dto.setBoardseq(boardseq);
		BoardDto boardDetail = boardBiz.boardDetail(dto);
		model.addAttribute("boardDetail", boardDetail);
		return "BOARD/boardUpdate";
	}

	// 글수정
	@RequestMapping(value = "/BOARD_boardUpdate.do", method = RequestMethod.POST)
	public String boardUpdate(@ModelAttribute("BoardDto") BoardDto dto) {
		int res = boardBiz.boardUpdate(dto);
		
		if (res > 0) {
			return "redirect:/BOARD_boardList.do";
		} else {
			return "redirect:/BOARD_boardWriteForm.do";
		}
	}

	// 글삭제
	@RequestMapping(value = "/BOARD_boardDelete.do")
	public String boardDelete(int groupno) {
		boardBiz.boardDelete(groupno);
		return "redirect:/BOARD_boardList.do";
	}

	// 댓글작성
	@RequestMapping(value = "/BOARD_replyInsert.do")
	public String replyInsert(@ModelAttribute("BoardDto") BoardDto dto, int curPage, Model model) {
		// 댓글작성자 : 로그인 완성되면 로그인 세션 아이디로 바꿔야됨
		dto.setJoinemail(login);
		boardBiz.replyInsert(dto);

		return "redirect:/BOARD_boardDetail.do?boardseq="+ dto.getBoardseq() +"&groupno=" + dto.getGroupno() +"&curPage=" + curPage;
	}

	// 대댓글작성
	@RequestMapping(value = "/BOARD_rereInsert.do")
	public String rereInsert(@ModelAttribute("BoardDto") BoardDto dto, int parentboardseq, int curPage, Model model) {
		// 댓글작성자 : 로그인 완성되면 로그인 세션 아이디로 바꿔야됨
		dto.setJoinemail(login);
		boardBiz.rereInsert(dto);

		return "redirect:/BOARD_boardDetail.do?boardseq="+ parentboardseq +"&groupno=" + dto.getGroupno() +"&curPage=" + curPage;
	}

	// 댓글삭제
	@RequestMapping(value = "/BOARD_replyDelete.do")
	public String replyDelete(@ModelAttribute("BoardDto") BoardDto dto, int parentboardseq, int curPage, Model model) {
		boardBiz.replyDelete(dto.getBoardseq());

		return "redirect:/BOARD_boardDetail.do?boardseq="+ parentboardseq +"&groupno=" + dto.getGroupno() + "&curPage=" + curPage;
	} 

	// 에러
	@RequestMapping(value = "/error.do", method = RequestMethod.GET)
	public void errpage() throws Exception {
		logger.info("예외 발생");
		throw new Exception();
	}
}
