package com.job.coverletter.model.total.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.job.coverletter.model.skill.dto.SkillDto;
import com.job.coverletter.model.total.dto.TotalDto;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Repository
public class TotalDaoImpl implements TotalDao {

	@Autowired
	@Qualifier("sqlSessionTemPlate")
	private SqlSessionTemplate sqlSession;

	// 로그인
	private String login = "cv@email.com";

	@Override
	public int insert(TotalDto dto) {
		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "insert", dto);
		} catch (Exception e) {
			System.out.println("[error] : insert");
			e.printStackTrace();
		}
		return res;
	}

	/*-------------------------스킬차트-----------------------------*/
	@Override
	public JSONArray selectItSkill() {
		TotalDto dto = new TotalDto();
		dto.setJoinemail(login);

		List<Map<String, String>> list = null;
		JSONArray arr = new JSONArray();
		JSONObject obj = new JSONObject();

		try {
			list = sqlSession.selectList(NAMESPACE + "selectItSkill", dto);

			for (Map<String, String> map : list) {
				obj.put("skill", map.get("ITSKILL1"));
				obj.put("skill", map.get("ITSKILL2"));
				obj.put("skill", map.get("ITSKILL3"));
				obj.put("skill", map.get("ITSKILL4"));
				obj.put("skill", map.get("ITSKILL5"));
				obj.put("score", map.get("ITSCORE1"));
				obj.put("score", map.get("ITSCORE2"));
				obj.put("score", map.get("ITSCORE3"));
				obj.put("score", map.get("ITSCORE4"));
				obj.put("score", map.get("ITSCORE5"));
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

	@Override
	public JSONArray selectMySkill() {
		TotalDto dto = new TotalDto();
		dto.setJoinemail(login);

		List<TotalDto> list = null;
		JSONArray arr = new JSONArray();
		JSONObject obj = new JSONObject();

		try {
			list = sqlSession.selectList(NAMESPACE + "selectMySkill", dto);
			for(TotalDto data : list) {
				String[] language = data.getLanguagescore().split(",", -1);
				String[] contest = data.getContest().split(",", -1);
				String[] certificate = data.getCertificate().split(",", -1);
				String grade = Integer.toString((int) Math.round((100 * Double.parseDouble(data.getGrade())) / 4.5));
				String[] career = data.getCareer().split(",", -1);
				int careerRes = 0; 
				switch (career[0]) {
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
				
				obj.put("어학", language[0]);
				obj.put("공모전", contest.length);
				obj.put("자격증", certificate.length);
				obj.put("학점", grade);
				obj.put("학력", careerRes);

				if (obj != null) {
					arr.add(obj);
					System.out.println(arr);
				}
			}
			
		} catch (Exception e) {
			System.out.println("[error] : selectMySkill");
			e.printStackTrace();
		}

		return arr;

	}

}
