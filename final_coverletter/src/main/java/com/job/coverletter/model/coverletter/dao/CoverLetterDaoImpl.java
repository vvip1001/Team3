package com.job.coverletter.model.coverletter.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.job.coverletter.all.util.MultiRowTarget;
import com.job.coverletter.model.coverletter.dto.CoverLetterDto;

@Repository
public class CoverLetterDaoImpl implements CoverLetterDao {

	@Autowired
	@Qualifier("sqlSessionTemPlate")
	private SqlSessionTemplate sqlSession;

	@Override
	public int boardCVListCount(CoverLetterDto dto) {
		int res = 0;
		try {
			res = sqlSession.selectOne(NAMESPACE + "boardCVListCount", dto); 
		} catch (Exception e) {
			System.out.println("[error] : boardListCount");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<CoverLetterDto> boardCVList(CoverLetterDto dto) {
		List<CoverLetterDto> list = new ArrayList<CoverLetterDto>();
		try {
			list = sqlSession.selectList(NAMESPACE + "boardCVList", dto);
		} catch (Exception e) {
			System.out.println("[error] : boardCVList");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int boardPFListCount(CoverLetterDto dto) {
		int res = 0;
		try {
			res = sqlSession.selectOne(NAMESPACE + "boardPFListCount", dto); 
		} catch (Exception e) {
			System.out.println("[error] : boardPFListCount");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<CoverLetterDto> boardPFList(CoverLetterDto dto) {
		List<CoverLetterDto> list = new ArrayList<CoverLetterDto>();
		try {
			list = sqlSession.selectList(NAMESPACE + "boardPFList", dto);
		} catch (Exception e) {
			System.out.println("[error] : boardPFList");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int CVdelete(String[] seq) {
		
		int res = 0;
		Map<String , String[]> map = new HashMap<String , String[]>();
		map.put("seqs", seq);
		
		try {
			res = sqlSession.delete(NAMESPACE + "CVmuldel",map);
		} catch (Exception e) {
			System.out.println("[error] : CVmuldel");
			e.printStackTrace();
		}
		
		return res;
	}
	
	@Override
	public int PFdelete(String[] seq) {
		
		int res = 0;
		Map<String , String[]> map = new HashMap<String , String[]>();
		map.put("seqs", seq);
		
		try {
			res = sqlSession.delete(NAMESPACE + "PFmuldel",map);
		} catch (Exception e) {
			System.out.println("[error] : PFmuldel");
			e.printStackTrace();
		}
		
		return res;
	}

	// 자기소개서 INSERT
	@Override
	public int CVinsert(CoverLetterDto dto) {
		int res = 0;

			res = sqlSession.insert(NAMESPACE + "CVinsert", dto);
			System.out.println(res);
		return res;
	}

}
