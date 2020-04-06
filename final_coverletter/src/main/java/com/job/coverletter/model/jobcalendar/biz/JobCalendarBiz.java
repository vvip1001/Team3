package com.job.coverletter.model.jobcalendar.biz;


import java.util.List;

import com.job.coverletter.model.jobcalendar.dto.JobCalendarDto;

public interface JobCalendarBiz {
	
	public int boardJobListCount(JobCalendarDto dto);
	public List<JobCalendarDto> boardJobList(JobCalendarDto dto);
	
	// 즐겨찾기 등록
	public int boardJobInsert(JobCalendarDto dto);
	
	// 즐겨찾기 등록 여부
	public boolean isJobBookmark(int companyseq, String joinemail);
	
	// 즐겨찾기 삭제
	public int bookmarkDelete(int companyseq);
}
