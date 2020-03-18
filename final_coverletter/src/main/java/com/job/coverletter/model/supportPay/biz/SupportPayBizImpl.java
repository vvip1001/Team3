package com.job.coverletter.model.supportPay.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.job.coverletter.model.supportPay.dao.SupportPayDao;

@Service
public class SupportPayBizImpl implements SupportPayBiz {
	@Autowired
	private SupportPayDao supprotpaydao;
}
