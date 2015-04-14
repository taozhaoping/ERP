package com.zh.web.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.BomSub;

/**
 * 替代料
 * 
 * @author 21829(cai_yingying@dahuatech.com)
 *
 * 2015年4月14日 下午3:37:05
 *
 */
@Component("bomSubDao")
public class BomSubDao extends BaseDao<BomSub> {

	@Override
	@PostConstruct
	public void init() {
		this.setNamespace("M_BomSub");
	}
}
