package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.model.Pager;
import com.zh.web.dao.MaterialRequisitionDetailDao;
import com.zh.web.model.bean.MaterialRequisitionDetail;
import com.zh.web.service.MaterialRequisitionDetailService;

@Component("materialRequisitionDetailService")
public class MaterialRequisitionDetailServiceImpl implements MaterialRequisitionDetailService {

	@Autowired
	private MaterialRequisitionDetailDao materialRequisitionDetailDao;
	@Override
	public MaterialRequisitionDetail query(MaterialRequisitionDetail materialRequisitionDetail) {
		return materialRequisitionDetailDao.query(materialRequisitionDetail);
	}

	@Override
	public void update(MaterialRequisitionDetail materialRequisitionDetail) {
		materialRequisitionDetailDao.update(materialRequisitionDetail);
	}

	@Override
	public List<MaterialRequisitionDetail> queryList(
			MaterialRequisitionDetail materialRequisitionDetail) {
		return materialRequisitionDetailDao.queryList(materialRequisitionDetail);
	}

	@Override
	public List<MaterialRequisitionDetail> queryList(
			MaterialRequisitionDetail materialRequisitionDetail, Pager page) {
		return materialRequisitionDetailDao.queryPageList(materialRequisitionDetail, page);
	}

	@Override
	public Integer count(MaterialRequisitionDetail materialRequisitionDetail) {
		return materialRequisitionDetailDao.count(materialRequisitionDetail);
	}

	@Override
	public void delete(MaterialRequisitionDetail materialRequisitionDetail) {
		materialRequisitionDetailDao.delete(materialRequisitionDetail);
	}

	@Override
	public Integer insert(MaterialRequisitionDetail materialRequisitionDetail) {
		return materialRequisitionDetailDao.insert(materialRequisitionDetail);
	}

}
