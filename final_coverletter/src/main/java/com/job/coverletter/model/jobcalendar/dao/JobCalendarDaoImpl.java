package com.job.coverletter.model.jobcalendar.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.job.coverletter.model.coverletter.dto.CoverLetterDto;
import com.job.coverletter.model.jobcalendar.dto.JobCalendarDto;

@Repository
public class JobCalendarDaoImpl implements JobCalendarDao {
   
   @Autowired  
   @Qualifier("sqlSessionTemPlate")
   private SqlSessionTemplate sqlSession;

   @Override
   public int boardJobListCount(JobCalendarDto dto) {
      int res = 0;
      try {
         res = sqlSession.selectOne(NAMESPACE + "boardJobListCount", dto); 
      } catch (Exception e) {
         System.out.println("[error] : boardJobListCount");
         e.printStackTrace();
      }
      return res;
   }

   @Override
   public List<JobCalendarDto> boardJobList(JobCalendarDto dto) {
      List<JobCalendarDto> list = new ArrayList<JobCalendarDto>();
      try {
         list = sqlSession.selectList(NAMESPACE + "boardJobList", dto);
      } catch (Exception e) {
         System.out.println("[error] : boardJobList");
         e.printStackTrace();
      }
      return list;
   }

	@Override
	public int boardJobInsert(JobCalendarDto dto) {
		int res = sqlSession.insert(NAMESPACE + "boardJobInsert", dto);
		return res;
	}

	@Override
	public boolean isJobBookmark(int companyseq, String joinemail) {
		JobCalendarDto dto = new JobCalendarDto();
		dto = sqlSession.selectOne(NAMESPACE + "isJobBookmark", companyseq);

		if(dto.getJoinemail().equals("")) { // 값이 없으면 사용가능
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public int bookmarkDelete(int companyseq) {
		int res = sqlSession.delete(NAMESPACE + "bookmarkDelete", companyseq);
		return res;
	}
}