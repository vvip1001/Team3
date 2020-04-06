package com.job.coverletter.model.jobcalendar.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.coverletter.model.jobcalendar.dao.JobCalendarDao;
import com.job.coverletter.model.jobcalendar.dto.JobCalendarDto;

@Service
public class JobCalendarBizImpl implements JobCalendarBiz {

	@Autowired
	private JobCalendarDao jobcalendardao;

	@Override
	public int boardJobListCount(JobCalendarDto dto) {
		return jobcalendardao.boardJobListCount(dto);
	}

	@Override
	public List<JobCalendarDto> boardJobList(JobCalendarDto dto) {
		return jobcalendardao.boardJobList(dto);
	}

	@Override
	public int boardJobInsert(JobCalendarDto dto) {
		return jobcalendardao.boardJobInsert(dto);
	}

	@Override
	public boolean isJobBookmark(int companyseq, String joinemail) {
		return jobcalendardao.isJobBookmark(companyseq, joinemail);
	}

	@Override
	public int bookmarkDelete(int companyseq) {
		return jobcalendardao.bookmarkDelete(companyseq);
	}

}