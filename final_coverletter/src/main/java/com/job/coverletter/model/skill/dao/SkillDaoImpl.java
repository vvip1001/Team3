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

		// 공모전, 자격증 개수
		Map<String, String> skillContestmap = null;
		JSONArray arr = new JSONArray();
		JSONObject obj = new JSONObject();

		try {
			// 어학점수
			int skillLG = sqlSession.selectOne(NAMESPACE + "selectSkillLG", dto);
			obj.put("어학점수", Integer.toString(skillLG));
			// 공모전, 자격증 개수
			skillContestmap = sqlSession.selectOne(NAMESPACE + "selectSkillContest", dto);
			obj.put("공모전", skillContestmap.get("COUNT(CONTEST)*10"));
			obj.put("자격증", skillContestmap.get("COUNT(CERTIFICATE)*10"));
			// 학점
			String grade = sqlSession.selectOne(NAMESPACE + "selectSkillGrade", dto);
			// 학점계산 (100 * 내학점)/우리학교만점
			int idx = grade.indexOf("/");
	        String myGrade = grade.substring(0, idx);
	        String PerfectGrade = grade.substring(idx + 1);
	        int gradeRes = (int)Math.round((100 * Double.parseDouble(myGrade))/Double.parseDouble(PerfectGrade));
			obj.put("학점", gradeRes);
			// 학력
			String career = sqlSession.selectOne(NAMESPACE + "selectCareer", dto);
			int careerRes = 0;
			switch (career) {
			case "대졸":
				careerRes = 100;
				break;
			case "초대졸":
				careerRes = 80;
				break;
			case "고졸":
				careerRes = 60;
				break;
			default:
				careerRes = 40;
				break;
			}
			obj.put("학력", careerRes);
			
			if (obj != null) {
				arr.add(obj);
				System.out.println(arr);
			}

		} catch (Exception e) {
			System.out.println("[error] : selectMySkill");
			e.printStackTrace();
		}

		return arr;
	}
}
