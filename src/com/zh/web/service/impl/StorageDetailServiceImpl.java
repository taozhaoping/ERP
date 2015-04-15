package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.zh.core.model.Pager;
import com.zh.web.dao.StorageDetailDao;
import com.zh.web.model.bean.StorageDetail;
import com.zh.web.service.StorageDetailService;
import com.zh.web.util.StockUtil;

@Component("storageDetailService")
@Scope("singleton")
public class StorageDetailServiceImpl implements StorageDetailService {

	@Autowired
	private StorageDetailDao storageDetailDao;

	@Override
	public StorageDetail query(StorageDetail storageDetail) {
		// TODO Auto-generated method stub
		return storageDetailDao.query(storageDetail);
	}

	@Override
	public void update(StorageDetail storageDetail) {
		// TODO Auto-generated method stub
		storageDetailDao.update(storageDetail);
	}

	@Override
	public List<StorageDetail> queryList(StorageDetail storageDetail) {
		// TODO Auto-generated method stub
		return storageDetailDao.queryList(storageDetail);
	}

	@Override
	public List<StorageDetail> queryList(StorageDetail storageDetail, Pager page) {
		// TODO Auto-generated method stub
		return storageDetailDao.queryPageList(storageDetail, page);
	}

	@Override
	public Integer count(StorageDetail storageDetail) {
		// TODO Auto-generated method stub
		return storageDetailDao.count(storageDetail);
	}

	@Override
	public void delete(StorageDetail storageDetail) {

		// 修改对应库存
		/*StockUtil stockUtil = StockUtil.getInstance();
		stockUtil.reduceStock(storageDetail);*/
		storageDetailDao.delete(storageDetail);
	}

	@Override
	public Integer insert(StorageDetail storageDetail) {
		// 修改对应库存
		/*StockUtil stockUtil = StockUtil.getInstance();
		stockUtil.increaseStock(storageDetail);*/
		return storageDetailDao.insert(storageDetail);
	}

}
