package com.job.coverletter.model.board.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.coverletter.common.error.ErrorHandler;
import com.job.coverletter.model.board.dao.BoardDao;

@Service
public class BoardBizImpl implements BoardBiz {
	
	@Autowired
	private BoardDao boardDao;

	
}
