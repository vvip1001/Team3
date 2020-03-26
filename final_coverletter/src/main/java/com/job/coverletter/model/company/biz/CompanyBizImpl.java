package com.job.coverletter.model.company.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.coverletter.model.board.dto.BoardDto;
import com.job.coverletter.model.company.dao.CompanyDao;
import com.job.coverletter.model.company.dto.CompanyDto;

@Service
public class CompanyBizImpl implements CompanyBiz {

	@Autowired
	private CompanyDao companydao;

	@Override
	public CompanyDto selectOne(int companyseq) {
		return companydao.selectOne(companyseq);
	}

}
