package com.job.coverletter.model.company.biz;

import java.util.List;

import com.job.coverletter.model.board.dto.BoardDto;
import com.job.coverletter.model.company.dto.CompanyDto;

public interface CompanyBiz {
	
	public CompanyDto selectOne(int companyseq);

	
}
