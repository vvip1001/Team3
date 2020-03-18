package com.job.coverletter.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.job.coverletter.model.board.biz.BoardBiz;
import com.job.coverletter.model.board.dto.BoardDto;

@Controller
public class BoardController {
	// 게시판
	private Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardBiz boardBiz;

	// 글목록
	@RequestMapping(value = "/BOARD/boardList.do")
	public String boardList(Model model) {
		model.addAttribute("boardList", boardBiz.boardList());
		return "BOARD/boardList";
	}

	// 글작성 페이지
	@RequestMapping(value = "/BOARD/boardWriteForm.do", method = RequestMethod.GET)
	public String boardWriteForm() {
		return "BOARD/boardWrite";
	}

	// 글작성
	@RequestMapping(value = "/BOARD/boardWrite.do", method = RequestMethod.POST)
	public String boardWrite(@ModelAttribute("BoardDto") BoardDto dto) {
		dto.setJoinemail("mintparc@gmail.com");
		int res = boardBiz.boardInsert(dto);
		if (res > 0) {
			return "redirect:/BOARD/boardList.do";
		} else {
			return "redirect:/BOARD/boardWriteForm.do";
		}
	}

	// 글상세 + 댓글상세
	@RequestMapping(value = "/BOARD/boardDetail.do", method = RequestMethod.GET)
	public String boardDetail(Model model, @ModelAttribute("BoardDto") BoardDto dto) {
		// 글
		BoardDto boardDetail = boardBiz.boardDetail(dto);
		// 댓글
		List<BoardDto> replyList = boardBiz.replyList(dto);
		model.addAttribute("boardDetail", boardDetail);
		model.addAttribute("replyList", replyList);
		return "BOARD/boardDetail";
	}

	// 글수정

	// 글삭제
	@RequestMapping(value = "/BOARD/boardDelete.do")
	public String boardDelete(int boardseq) {
		boardBiz.boardDelete(boardseq);
		return "redirect:/BOARD/boardList.do";
	}

	// 댓글작성
	@RequestMapping(value = "/BOARD/replyInsert.do")
	public String replyInsert(@ModelAttribute("BoardDto") BoardDto dto, Model model) {
		boardBiz.replyInsert(dto);
		// 글
		BoardDto boardDetail = boardBiz.boardDetail(dto);
		// 댓글
		List<BoardDto> replyList = boardBiz.replyList(dto);
		model.addAttribute("boardDetail", boardDetail);
		model.addAttribute("replyList", replyList);
		return "/BOARD/boardDetail";
	}

	// 대댓글작성

	// 댓글삭제
	@RequestMapping(value = "/BOARD/replyDelete.do")
	public String replyDelete(@ModelAttribute("BoardDto") BoardDto dto, int replyseq, Model model) {
		boardBiz.boardDelete(replyseq);
		// 글
		BoardDto boardDetail = boardBiz.boardDetail(dto);
		// 댓글
		List<BoardDto> replyList = boardBiz.replyList(dto);
		model.addAttribute("boardDetail", boardDetail);
		model.addAttribute("replyList", replyList);
		return "/BOARD/boardDetail";
	}

	// 에러
	@RequestMapping(value = "/error.do", method = RequestMethod.GET)
	public void errpage() throws Exception {
		logger.info("예외 발생");
		throw new Exception();
	}
}
