package com.job.coverletter.model.coverletter.dao;

import java.util.List;

import com.job.coverletter.all.util.MultiRowTarget;
import com.job.coverletter.model.coverletter.dto.CoverLetterDto;

public interface CoverLetterDao {
	String NAMESPACE = "com.job.coverletter.CoverLetter.";
	// 총 게시글 수
	public int boardCVListCount(CoverLetterDto dto);

	// 글목록 (페이징)
	public List<CoverLetterDto> boardCVList(CoverLetterDto dto);

	public int boardPFListCount(CoverLetterDto dto);

	// 글목록 (페이징)
	public List<CoverLetterDto> boardPFList(CoverLetterDto dto);

	public int CVdelete(String[] seq);	

	public int PFdelete(String[] seq);
	
	
 	public CoverLetterDto getGroupno(String joinemail);
	//pf잣성
	public int PFwrite(CoverLetterDto dto);
	// 자기소개서 INSERT
	public int CVinsert(CoverLetterDto dto);
}
