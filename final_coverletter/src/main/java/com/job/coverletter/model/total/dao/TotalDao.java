package com.job.coverletter.model.total.dao;

import com.job.coverletter.model.total.dto.TotalDto;

public interface TotalDao {
	String NAMESPACE = "com.job.coverletter.Total.";
	public int insert(TotalDto dto);
}
