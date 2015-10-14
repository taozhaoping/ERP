package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.model.Pager;
import com.zh.web.dao.PurchasingAssistantDao;
import com.zh.web.model.bean.PurchasingAssistant;
import com.zh.web.service.PurchasingAssistantService;

@Component("purchasingAssistantService")
public class PurchasingAssistantServiceImpl implements
		PurchasingAssistantService {

	@Autowired
	private PurchasingAssistantDao purchasingAssistantDao;
	
	@Override
	public List<PurchasingAssistant> queryList(
			PurchasingAssistant purchasingAssistant) {
		// TODO Auto-generated method stub
		return purchasingAssistantDao.queryList(purchasingAssistant);
	}

	@Override
	public List<PurchasingAssistant> queryList(
			PurchasingAssistant purchasingAssistant, Pager page) {
		return purchasingAssistantDao.queryPageList(purchasingAssistant, page);
	}
	
	@Override
	public Integer count(PurchasingAssistant purchasingAssistant) {
		// TODO Auto-generated method stub
		return purchasingAssistantDao.count(purchasingAssistant);
	}

	public PurchasingAssistantDao getPurchasingAssistantDao() {
		return purchasingAssistantDao;
	}

	public void setPurchasingAssistantDao(
			PurchasingAssistantDao purchasingAssistantDao) {
		this.purchasingAssistantDao = purchasingAssistantDao;
	}

}
