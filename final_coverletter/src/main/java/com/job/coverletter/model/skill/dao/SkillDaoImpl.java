package com.job.coverletter.model.skill.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.job.coverletter.model.skill.dto.SkillDto;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Repository
public class SkillDaoImpl implements SkillDao {

	@Autowired
	@Qualifier("sqlSessionTemPlate")
	private SqlSessionTemplate sqlSession;

	// 로그인
	private String login = "cv@email.com";

	// it역량 차트
	@Override
	public JSONArray selectItSkill() {
		SkillDto dto = new SkillDto();
		dto.setJoinemail(login);

		List<Map<String, String>> list = null;
		JSONArray arr = new JSONArray();
		JSONObject obj = new JSONObject();

		try {
			list = sqlSession.selectList(NAMESPACE + "selectItSkill", dto);
			
			for (Map<String, String> map : list) {
				System.out.println(map);
				obj.put("skill", map.get("ITSKILL"));
				obj.put("score", map.get("ITSCORE"));
				if (obj != null) {
					arr.add(obj);
				}
			}

		} catch (Exception e) {
			System.out.println("[error] : selectItSkill");
			e.printStackTrace();
		}

		return arr;
	}

	// skill 차트
	@Override
	public JSONArray selectMySkill() {
		SkillDto dto = new SkillDto();
		dto.setJoinemail(login);
		List<SkillDto> list = new ArrayList<SkillDto>();

		return null;
	}
}
