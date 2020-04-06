package com.job.coverletter.model.jobcalendar.dao;

import java.util.List;

import com.job.coverletter.model.jobcalendar.dto.JobCalendarDto;

public interface JobCalendarDao {
	String NAMESPACE = "com.job.coverletter.JobCalender.";

	public int boardJobListCount(JobCalendarDto dto);

	public List<JobCalendarDto> boardJobList(JobCalendarDto dto);
	
	// 즐겨찾기 추가
	public int boardJobInsert(JobCalendarDto dto);
	
	// 즐겨찾기 등록 여부
	public boolean isJobBookmark(int companyseq, String joinemail);
	
	// 즐겨찾기 삭제
	public int bookmarkDelete(int companyseq);
	
}
