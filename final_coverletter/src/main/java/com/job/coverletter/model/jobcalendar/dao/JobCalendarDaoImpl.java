package com.job.coverletter.model.jobcalendar.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class JobCalendarDaoImpl implements JobCalendarDao {
	
	@Autowired  @Qualifier("sqlSessionTemPlate")
	private SqlSessionTemplate sqlSession;
}
