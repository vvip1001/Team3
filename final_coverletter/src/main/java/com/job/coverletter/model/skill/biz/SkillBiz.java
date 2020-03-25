package com.job.coverletter.model.skill.biz;

import net.sf.json.JSONArray;

public interface SkillBiz {
	
	// IT역량차트
	public JSONArray selectItSkill();
	
	// 스킬차트
	public JSONArray selectMySkill();
	

}
