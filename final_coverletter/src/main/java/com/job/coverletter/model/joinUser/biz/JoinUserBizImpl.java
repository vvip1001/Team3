package com.job.coverletter.model.joinUser.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.job.coverletter.model.joinUser.dao.JoinUserDao;

@Service
public class JoinUserBizImpl implements JoinUserBiz {
	@Autowired
	private JoinUserDao joinuserdao;

}
