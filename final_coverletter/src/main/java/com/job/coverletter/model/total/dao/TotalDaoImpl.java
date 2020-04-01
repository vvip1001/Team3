package com.job.coverletter.model.total.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.job.coverletter.model.total.dto.TotalDto;

@Repository
public class TotalDaoImpl implements TotalDao {
	
	@Autowired  @Qualifier("sqlSessionTemPlate")
	private SqlSessionTemplate sqlSession;

	@Override
	public int insert(TotalDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "insert", dto);
		} catch (Exception e) {
			System.out.println("[error] : insert");
			e.printStackTrace();
		}
		return res;
	}

}
