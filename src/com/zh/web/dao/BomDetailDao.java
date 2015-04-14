package com.zh.web.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.BomDetail;

/**
 * bom明细表
 * 
 * @author 21829(cai_yingying@dahuatech.com)
 *
 * 2015年4月14日 下午3:36:58
 *
 */
@Component("bomDetailDao")
public class BomDetailDao extends BaseDao<BomDetail> {

	@Override
	@PostConstruct
	public void init() {
		this.setNamespace("M_BomDetail");
	}
}
