package com.job.coverletter.model.joinUser.biz;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.job.coverletter.model.joinUser.dao.JoinUserDao;
import com.job.coverletter.model.joinUser.dto.JoinUserDto;

@Service
public class JoinUserBizImpl implements JoinUserBiz {
	@Autowired
	private JoinUserDao joinuserdao;

	@Override
	public int insertUser(JoinUserDto joinuser) {

		return joinuserdao.insertUser(joinuser);
	}

	@Override
	public JoinUserDto selectOne(String joinemail) {

		return joinuserdao.selectOne(joinemail);
	}

	@Override
	public int updateJoinuser(JoinUserDto joinuser) {

		return joinuserdao.updateJoinuser(joinuser);
	}

	@Override
	public int deletejoinuser(String joinemail) {

		return joinuserdao.deletejoinuser(joinemail);
	}

	
	@Override
	public JoinUserDto login(JoinUserDto dto) {
		
		return joinuserdao.login(dto);
	}

	@Override
	public int checkemail(JoinUserDto dto) {

		return joinuserdao.checkemail(dto);
	}

}
