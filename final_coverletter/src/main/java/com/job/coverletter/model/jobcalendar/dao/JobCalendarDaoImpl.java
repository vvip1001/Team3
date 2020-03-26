package com.job.coverletter.model.jobcalendar.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.job.coverletter.model.jobcalendar.dto.JobCalendarDto;

@Repository
public class JobCalendarDaoImpl implements JobCalendarDao {
	
	@Autowired  @Qualifier("sqlSessionTemPlate")
	private SqlSessionTemplate sqlSession;

	@Override
	public int boardJobListCount(JobCalendarDto dto) {
		return 0;
	}

	@Override
	public List<JobCalendarDto> boardJobList(JobCalendarDto dto) {
		return null;
	}
}
