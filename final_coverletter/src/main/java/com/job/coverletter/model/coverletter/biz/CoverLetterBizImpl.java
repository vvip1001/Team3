package com.job.coverletter.model.coverletter.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.coverletter.all.util.MultiRowTarget;
import com.job.coverletter.model.coverletter.dao.CoverLetterDao;
import com.job.coverletter.model.coverletter.dto.CoverLetterDto;

@Service
public class CoverLetterBizImpl implements CoverLetterBiz {

	@Autowired
	private CoverLetterDao coverletterdao;

	@Override
	public int boardCVListCount(CoverLetterDto dto) {
		return coverletterdao.boardCVListCount(dto);
	}

	@Override
	public List<CoverLetterDto> boardCVList(CoverLetterDto dto) {
		return coverletterdao.boardCVList(dto);
	}

	@Override
	public int boardPFListCount(CoverLetterDto dto) {
		return coverletterdao.boardPFListCount(dto);
	}

	@Override
	public List<CoverLetterDto> boardPFList(CoverLetterDto dto) {
		return coverletterdao.boardPFList(dto);
	}

	@Override
	public int CVdelete(String[] seq) {
		return coverletterdao.CVdelete(seq);
	}

	@Override
	public int PFdelete(String[] seq) {
		return coverletterdao.PFdelete(seq);
	}
	
	// 포폴 가장 큰 그룹번호 가져오기
	@Override
	public CoverLetterDto getGroupno(String joinemail) {
		System.out.println("biz 그룹 실행 ");
		CoverLetterDto dto =  coverletterdao.getGroupno(joinemail);
		System.out.println("biz 그룹 실행 res" + dto);
		return dto;
	}
	
	@Override
	public int PFwrite(CoverLetterDto dto) {
		System.out.println("biz 실행 ");
		return coverletterdao.PFwrite(dto);
	}

	

	@Override
	public int CVinsert(CoverLetterDto dto) {
		// TODO Auto-generated method stub
		return coverletterdao.CVinsert(dto);
	}
}
