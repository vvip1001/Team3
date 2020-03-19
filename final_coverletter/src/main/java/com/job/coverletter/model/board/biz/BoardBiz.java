package com.job.coverletter.model.board.biz;

import java.util.List;

import com.job.coverletter.model.board.dto.BoardDto;

public interface BoardBiz {
	// 글목록
	public List<BoardDto> boardList();

	// 글작성
	public int boardInsert(BoardDto dto);

	// 글상세
	public BoardDto boardDetail(BoardDto dto);

	// 글수정
	public int boardUpdate(BoardDto dto);

	// 글삭제
	public int boardDelete(int boardseq);

	// 댓글상세
	public List<BoardDto> replyList(BoardDto dto);

	// 댓글작성
	public int replyInsert(BoardDto dto);

	// 대댓글작성
	public int rereplyInsert(BoardDto dto);

	// 댓글삭제
	public int replyDelete(int boardseq);
}
