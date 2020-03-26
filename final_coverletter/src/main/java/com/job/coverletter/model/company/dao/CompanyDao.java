package com.job.coverletter.model.company.dao;

import java.util.List;

import com.job.coverletter.model.board.dto.BoardDto;
import com.job.coverletter.model.company.dto.CompanyDto;

public interface CompanyDao {
	String NAMESPACE = "com.job.coverletter.Company.";

	public CompanyDto selectOne(int companyseq);
}
