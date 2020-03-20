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
	
	// 총 게시글 수
	@Override
	public int boardListCount() {
		// TODO Auto-generated method stub
		return boardDao.boardListCount();
	}

	//페이징
	@Override
	public List<BoardDto> boardListPaging(BoardDto dto) {
		// TODO Auto-generated method stub
		return boardDao.boardListPaging(dto);
	}

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
	public BoardDto boardDetail(BoardDto dto) {
		// TODO Auto-generated method stub
		return boardDao.boardDetail(dto);
	}

	//글수정
	@Override
	public int boardUpdate(BoardDto dto) {
		// TODO Auto-generated method stub
		return boardDao.boardUpdate(dto);
	}

	//글삭제 (달린 댓글도 다 같이 삭제)
	@Override
	public int boardDelete(int groupno) {
		// TODO Auto-generated method stub
		return boardDao.boardDelete(groupno);
	}

	//댓글상세
	@Override
	public List<BoardDto> replyList(BoardDto dto) {
		// TODO Auto-generated method stub
		return boardDao.replyList(dto);
	}

	//댓글작성
	@Override
	public int replyInsert(BoardDto dto) {
		// TODO Auto-generated method stub
		return boardDao.replyInsert(dto);
	}

	//대댓글작성
	@Override
	public int rereInsert(BoardDto dto) {
		// TODO Auto-generated method stub
		return boardDao.rereInsert(dto);
	}

	//댓글삭제
	@Override
	public int replyDelete(int groupno) {
		// TODO Auto-generated method stub
		return boardDao.replyDelete(groupno);
	}

	
	
}
