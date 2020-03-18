package com.job.coverletter.model.jabcalendar.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.job.coverletter.model.jabcalendar.dao.JabCalendarDao;

@Service
public class JabCalendarBizImpl implements JabCalendarBiz {
	@Autowired
	private JabCalendarDao jabcalendardo;

}
