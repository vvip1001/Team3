package com.job.coverletter.model.coverletter.biz;

import java.util.List;

import com.job.coverletter.all.util.MultiRowTarget;
import com.job.coverletter.model.coverletter.dto.CoverLetterDto;

public interface CoverLetterBiz {

	// 총 게시글 수
	public int boardCVListCount(CoverLetterDto dto);

	// 글목록 (페이징)
	public List<CoverLetterDto> boardCVList(CoverLetterDto dto);

	public int boardPFListCount(CoverLetterDto dto);

	// 글목록 (페이징)
	public List<CoverLetterDto> boardPFList(CoverLetterDto dto);

	public int CVdelete(String[] seq);

	public int PFdelete(String[] seq);	
	
	// 포토폴리오 그룹번호 가져오기
	public CoverLetterDto getGroupno(String joinemail);
	
	//pf작성
	public int PFwrite(CoverLetterDto dto);
	
	// 자기소개서 INSERT
	public int CVinsert(CoverLetterDto dto);
	
	//title로 자기소개서 가져오기
	List<CoverLetterDto> CVselectList(CoverLetterDto dto);
	
}
