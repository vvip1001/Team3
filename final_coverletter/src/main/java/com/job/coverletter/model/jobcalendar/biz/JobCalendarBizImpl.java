package com.job.coverletter.model.jobcalendar.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.coverletter.model.jobcalendar.dao.JobCalendarDao;
import com.job.coverletter.model.jobcalendar.dto.JobCalendarDto;

@Service
public class JobCalendarBizImpl implements JobCalendarBiz {
   
   @Autowired
   private JobCalendarDao jobcalendardo;

   @Override
   public int boardJobListCount(JobCalendarDto dto) {
      return jobcalendardo.boardJobListCount(dto);
   }

   @Override
   public List<JobCalendarDto> boardJobList(JobCalendarDto dto) {
      return jobcalendardo.boardJobList(dto);
   }


   

}