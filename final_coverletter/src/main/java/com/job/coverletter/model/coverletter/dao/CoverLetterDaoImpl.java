package com.job.coverletter.model.coverletter.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.job.coverletter.model.coverletter.dto.CoverLetterDto;

@Repository
public class CoverLetterDaoImpl implements CoverLetterDao {

	@Autowired
	@Qualifier("sqlSessionTemPlate")
	private SqlSessionTemplate sqlSession;

	// 이력서 다운로드 게시판 총 게시글 수
	@Override
	public int CVListCount(CoverLetterDto dto) {
		int res = 0;
		try {
			res = sqlSession.selectOne(NAMESPACE + "CVListCount", dto); 
		} catch (Exception e) {
			System.out.println("[error] : CVListCount");
			e.printStackTrace();
		}
		return res;
	}

	// 이력서 다운로드 게시판 글목록
	@Override
	public List<CoverLetterDto> CVList(CoverLetterDto dto) {
		List<CoverLetterDto> list = new ArrayList<CoverLetterDto>();
		try {
			list = sqlSession.selectList(NAMESPACE + "CVList", dto);
		} catch (Exception e) {
			System.out.println("[error] : CVList");
			e.printStackTrace();
		}
		return list;
	}

	// 다중삭제
	@Override
	public int CVMultiDelete(String[] coverletterseq) {
		int res = 0;
		
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("coverletterseq", coverletterseq);
		try {
			res = sqlSession.delete(NAMESPACE + "CVMultiDelete", map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
}
