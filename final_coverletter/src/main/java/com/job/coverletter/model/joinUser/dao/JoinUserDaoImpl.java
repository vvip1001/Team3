package com.job.coverletter.model.joinUser.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.job.coverletter.model.joinUser.dto.JoinUserDto;

@Repository
public class JoinUserDaoImpl implements JoinUserDao {
	
	@Autowired  @Qualifier("sqlSessionTemPlate")
	private SqlSessionTemplate sqlSession;

	@Override
	public int insertUser(JoinUserDto joinuser) {

		return sqlSession.insert("com.job.coverletter.JoinUser.joinuser",joinuser);
	}

	@Override
	public JoinUserDto selectOne(String joinemail) {
		return sqlSession.selectOne("com.job.coverletter.JoinUser.loginuser",joinemail);
	}

	@Override
	public int updateJoinuser(JoinUserDto joinuser) {

		return sqlSession.update("com.job.coverletter.JoinUser.updateuser",	joinuser);
	}

	@Override
	public int deletejoinuser(String joinemail) {

		return sqlSession.delete("com.job.coverletter.JoinUser.deleteuser", joinemail);
	}
	
	

	@Override
	public int checkemail(HashMap<String, Object> ech) {

		return 0;
	}

	@Override
	public JoinUserDto login(JoinUserDto dto) {
		
		return sqlSession.selectOne("com.job.coverletter.JoinUser.login", dto);
	}
	
	
}
