package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.model.Pager;
import com.zh.web.dao.BomDetailDao;
import com.zh.web.dao.BomPrimaryDao;
import com.zh.web.dao.BomSubDao;
import com.zh.web.model.bean.BomDetail;
import com.zh.web.model.bean.BomPrimary;
import com.zh.web.model.bean.BomSub;
import com.zh.web.service.ProductStructService;

@Component("productStructureService")
public class ProductStructServiceImpl implements ProductStructService {

	@Autowired
	private BomPrimaryDao bomPrimaryDao;

	@Autowired
	private BomDetailDao bomDetailDao;
	
	@Autowired
	private BomSubDao bomSubDao; 
	
	@Override
	public BomPrimary queryPrimary(BomPrimary bomPrimary) {
		return bomPrimaryDao.query(bomPrimary);
	}
	
	@Override
	public BomPrimary queryReleasePrimary(BomPrimary bomPrimary) {
		return bomPrimaryDao.queryRelease(bomPrimary);
	}

	@Override
	public void updatePrimary(BomPrimary bomPrimary) {
		bomPrimaryDao.update(bomPrimary);
	}

	@Override
	public List<BomPrimary> queryPrimaryList(BomPrimary bomPrimary) {
		return bomPrimaryDao.queryList(bomPrimary);
	}

	@Override
	public List<BomPrimary> queryPrimaryList(BomPrimary bomPrimary,
			Pager page) {
		return bomPrimaryDao.queryList(bomPrimary);
	}

	@Override
	public Integer countPrimary(BomPrimary bomPrimary) {
		return bomPrimaryDao.count(bomPrimary);
	}

	@Override
	public void deletePrimary(BomPrimary bomPrimary) {
		bomPrimaryDao.delete(bomPrimary);
	}

	@Override
	public Integer insertPrimary(BomPrimary bomPrimary) {
		return bomPrimaryDao.insert(bomPrimary);
	}
	
	@Override
	public BomDetail queryDetail(BomDetail bomDetail) {
		return bomDetailDao.query(bomDetail);
	}
	
	@Override
	public void updateDetail(BomDetail bomDetail) {
		bomDetailDao.update(bomDetail);
	}
	
	@Override
	public List<BomDetail> queryDetailList(BomDetail bomDetail) {
		return bomDetailDao.queryList(bomDetail);
	}

	@Override
	public List<BomDetail> queryParentList(Integer productsId) {
		return bomDetailDao.queryParentList(productsId);
	}
	
	@Override
	public List<BomDetail> queryDetailList(BomDetail bomDetail,
			Pager page) {
		return bomDetailDao.queryList(bomDetail);
	}
	
	@Override
	public Integer countDetail(BomDetail bomDetail) {
		return bomDetailDao.count(bomDetail);
	}
	
	@Override
	public void deleteDetail(BomDetail bomDetail) {
		bomDetailDao.delete(bomDetail);
	}
	
	@Override
	public Integer insertDetail(BomDetail bomDetail) {
		return bomDetailDao.insert(bomDetail);
	}
	
	@Override
	public BomSub querySub(BomSub bomSub) {
		return bomSubDao.query(bomSub);
	}
	
	@Override
	public void updateSub(BomSub bomSub) {
		bomSubDao.update(bomSub);
	}
	
	@Override
	public List<BomSub> querySubList(BomSub bomSub) {
		return bomSubDao.queryList(bomSub);
	}
	
	@Override
	public List<BomSub> querySubList(BomSub bomSub,
			Pager page) {
		return bomSubDao.queryList(bomSub);
	}
	
	@Override
	public Integer countSub(BomSub bomSub) {
		return bomSubDao.count(bomSub);
	}
	
	@Override
	public void deleteSub(BomSub bomSub) {
		bomSubDao.delete(bomSub);
	}
	
	@Override
	public Integer insertSub(BomSub bomSub) {
		return bomSubDao.insert(bomSub);
	}

}
