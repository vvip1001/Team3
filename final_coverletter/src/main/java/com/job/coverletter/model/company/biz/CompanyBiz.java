package com.job.coverletter.model.company.biz;

import java.util.List;

import com.job.coverletter.model.company.dto.CompanyDto;

public interface CompanyBiz {
	
	
	// 전체 선택
	public List<CompanyDto> selectList();
	// 하나선택
	public CompanyDto selectOne(int companyseq);
}
