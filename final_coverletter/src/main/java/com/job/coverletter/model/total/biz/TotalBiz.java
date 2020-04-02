package com.job.coverletter.model.total.biz;

import com.job.coverletter.model.total.dto.TotalDto;

import net.sf.json.JSONArray;

public interface TotalBiz {
	public int insert(TotalDto dto);

	// IT역량차트
	public JSONArray selectItSkill();

	// 스킬차트
	public JSONArray selectMySkill();

}
