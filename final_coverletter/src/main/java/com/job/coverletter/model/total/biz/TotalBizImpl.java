package com.job.coverletter.model.total.biz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.coverletter.model.total.dao.TotalDao;
import com.job.coverletter.model.total.dto.TotalDto;


@Service
public class TotalBizImpl implements TotalBiz {
	
	@Autowired
	private TotalDao totaldao;

	@Override
	public int insert(TotalDto dto) {
		return totaldao.insert(dto);
	}

}
