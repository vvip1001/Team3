package com.job.coverletter.model.company.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.job.coverletter.model.company.dto.CompanyDto;

@Repository
public class CompanyDaoImpl implements CompanyDao {
	
	@Resource
	private SqlSessionTemplate sqlSessionTemPlateMariaDB;

	
	
	@Override
	public List<CompanyDto> selectList() {
		return sqlSessionTemPlateMariaDB.selectList(NAMESPACE + "selectList");
	}
	
	// 하나 선택
	@Override
	public CompanyDto selectOne(int companyseq) {
		return sqlSessionTemPlateMariaDB.selectOne(NAMESPACE + "selectOne", companyseq);
	}




	

}
