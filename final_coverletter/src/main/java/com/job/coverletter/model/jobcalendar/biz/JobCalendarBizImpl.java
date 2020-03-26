package com.job.coverletter.model.jobcalendar.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.job.coverletter.model.jobcalendar.dao.JobCalendarDao;

@Service
public class JobCalendarBizImpl implements JobCalendarBiz {
	@Autowired
	private JobCalendarDao jobcalendardo;

}
