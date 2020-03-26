package com.job.coverletter.model.company.dao;

import java.util.List;
import com.job.coverletter.all.pagination.MariaPagination;
import com.job.coverletter.model.board.dto.BoardDto;
import com.job.coverletter.model.company.dto.CompanyDto;

public interface CompanyDao {
	String NAMESPACE = "com.job.coverletter.Company.";
	
	// 전체 선택
	public List<CompanyDto> selectList(MariaPagination pagination);
	
	// 하나선택
	public CompanyDto selectOne(int companyseq);
	
	// 총 게시글 수
	public int	companyListCount();
	

}
