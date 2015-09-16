package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.model.Pager;
import com.zh.web.dao.ProductionStorageDetailDao;
import com.zh.web.model.bean.ProductionStorageDetail;
import com.zh.web.service.ProductionStorageDetailService;

@Component("productionStorageDetailService")
public class ProductionStorageDetailServiceImpl implements ProductionStorageDetailService {

	@Autowired
	private ProductionStorageDetailDao productionStorageDetailDao;
	@Override
	public ProductionStorageDetail query(ProductionStorageDetail productionStorageDetail) {
		return productionStorageDetailDao.query(productionStorageDetail);
	}

	@Override
	public void update(ProductionStorageDetail productionStorageDetail) {
		productionStorageDetailDao.update(productionStorageDetail);
	}

	@Override
	public List<ProductionStorageDetail> queryList(
			ProductionStorageDetail productionStorageDetail) {
		return productionStorageDetailDao.queryList(productionStorageDetail);
	}

	@Override
	public List<ProductionStorageDetail> queryList(
			ProductionStorageDetail productionStorageDetail, Pager page) {
		return productionStorageDetailDao.queryPageList(productionStorageDetail, page);
	}

	@Override
	public Integer count(ProductionStorageDetail productionStorageDetail) {
		return productionStorageDetailDao.count(productionStorageDetail);
	}

	@Override
	public void delete(ProductionStorageDetail productionStorageDetail) {
		productionStorageDetailDao.delete(productionStorageDetail);
	}

	@Override
	public Integer insert(ProductionStorageDetail productionStorageDetail) {
		return productionStorageDetailDao.insert(productionStorageDetail);
	}

}
