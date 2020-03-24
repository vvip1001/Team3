package com.job.coverletter.model.coverletter.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.job.coverletter.model.coverletter.dao.CoverLetterDao;
import com.job.coverletter.model.coverletter.dto.CoverLetterDto;

@Service
public class CoverLetterBizImpl implements CoverLetterBiz {

	@Autowired
	private CoverLetterDao coverletterdao;

	// 이력서 다운로드 게시판 총 게시글 수
	@Override
	public int CVListCount(CoverLetterDto dto) {
		// TODO Auto-generated method stub
		return coverletterdao.CVListCount(dto);
	}

	// 이력서 다운로드 게시판 글목록
	@Override
	public List<CoverLetterDto> CVList(CoverLetterDto dto) {
		// TODO Auto-generated method stub
		return coverletterdao.CVList(dto);
	}

	// 다중삭제
	@Override
	public int CVMultiDelete(String[] coverletterseq) {
		// TODO Auto-generated method stub
		return coverletterdao.CVMultiDelete(coverletterseq);
	}
}
