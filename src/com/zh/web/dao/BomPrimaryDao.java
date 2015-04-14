package com.zh.web.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.BomPrimary;

/**
 * bom主表
 * 
 * @author 21829(cai_yingying@dahuatech.com)
 *
 * 2015年4月14日 下午3:37:02
 *
 */
@Component("bomPrimaryDao")
public class BomPrimaryDao extends BaseDao<BomPrimary> {

	@Override
	@PostConstruct
	public void init() {
		this.setNamespace("M_BomPrimary");
	}
}
