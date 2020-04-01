package com.job.coverletter.model.jobcalendar.dao;

import java.util.List;

import com.job.coverletter.model.jobcalendar.dto.JobCalendarDto;

public interface JobCalendarDao {
	String NAMESPACE = "com.job.coverletter.JobCalender.";

	public int boardJobListCount(JobCalendarDto dto);

	public List<JobCalendarDto> boardJobList(JobCalendarDto dto);

}
