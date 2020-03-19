package com.job.coverletter.model.joinUser.biz;

import java.util.HashMap;

import com.job.coverletter.model.joinUser.dto.JoinUserDto;

public interface JoinUserBiz {
	
	int insertUser(JoinUserDto joinuser);
	
	JoinUserDto selectOne(String joinemail);
	
	int updateJoinuser(JoinUserDto joinuser);
	
	int deletejoinuser(String joinemail);
	
	JoinUserDto login(JoinUserDto dto);
	
	int checkemail (HashMap<String, Object> ech);

}
