package com.job.coverletter.model.jobcalendar.biz;

import java.util.List;

import com.job.coverletter.model.jobcalendar.dto.JobCalendarDto;

public interface JobCalendarBiz {
	
	
	public int boardJobListCount(JobCalendarDto dto);
	
	public List<JobCalendarDto> boardJobList(JobCalendarDto dto);
}
