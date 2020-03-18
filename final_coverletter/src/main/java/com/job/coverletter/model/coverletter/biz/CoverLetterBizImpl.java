package com.job.coverletter.model.coverletter.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.job.coverletter.model.coverletter.dao.CoverLetterDao;

@Service
public class CoverLetterBizImpl implements CoverLetterBiz {

	@Autowired
	private CoverLetterDao coverletterdao;
}
