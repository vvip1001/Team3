package com.job.coverletter.model.total.dao;

import com.job.coverletter.model.total.dto.TotalDto;

import net.sf.json.JSONArray;

public interface TotalDao {
	String NAMESPACE = "com.job.coverletter.Total.";

	public int insert(TotalDto dto);

	// IT역량차트
	public JSONArray selectItSkill();

	// 스킬차트
	public JSONArray selectMySkill();

}
