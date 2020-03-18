package com.job.coverletter.model.board.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.coverletter.model.board.dao.BoardDao;
import com.job.coverletter.model.board.dto.BoardDto;

@Service
public class BoardBizImpl implements BoardBiz {
	
	@Autowired
	private BoardDao boardDao;

	//글목록
	@Override
	public List<BoardDto> boardList() {
		// TODO Auto-generated method stub
		return boardDao.boardList();
	}

	//글작성
	@Override
	public int boardInsert(BoardDto dto) {
		// TODO Auto-generated method stub
		return boardDao.boardInsert(dto);
	}

	//글상세
	@Override
	public BoardDto boardDetail(int boardseq) {
		// TODO Auto-generated method stub
		return boardDao.boardDetail(boardseq);
	}

	//글수정
	@Override
	public int boardUpdate(BoardDto dto) {
		// TODO Auto-generated method stub
		return boardDao.boardUpdate(dto);
	}

	//글삭제
	@Override
	public int boardDelete(int boardseq) {
		// TODO Auto-generated method stub
		return boardDao.boardDelete(boardseq);
	}

	//댓글상세
	@Override
	public List<BoardDto> replyList(int groupno) {
		// TODO Auto-generated method stub
		return boardDao.replyList(groupno);
	}

	//댓글작성
	@Override
	public int replyInsert(BoardDto dto) {
		// TODO Auto-generated method stub
		return boardDao.replyInsert(dto);
	}

	//대댓글작성
	@Override
	public int rereplyInsert(int boardseq) {
		// TODO Auto-generated method stub
		return boardDao.rereplyInsert(boardseq);
	}

	//댓글삭제
	@Override
	public int replyDelete(int boardseq) {
		// TODO Auto-generated method stub
		return boardDao.replyDelete(boardseq);
	}

	
}
