package com.zh.web.service.impl;

import java.util.List;

import org.apache.avalon.framework.parameters.ParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.exception.ProjectException;
import com.zh.core.model.Pager;
import com.zh.web.dao.ProductionTaskDao;
import com.zh.web.model.bean.LibraryPrimary;
import com.zh.web.model.bean.ProcessingSingleDetail;
import com.zh.web.model.bean.ProcessingSinglePrimary;
import com.zh.web.model.bean.ProductionTask;
import com.zh.web.service.ProcessingSingleDetailService;
import com.zh.web.service.ProcessingSinglePrimaryService;
import com.zh.web.service.ProductionTaskService;
import com.zh.web.util.StockUtil;

@Component("productionTaskService")
public class ProductionTaskServiceImpl implements ProductionTaskService {

	@Autowired
	private ProductionTaskDao productionTaskDao;
	
	@Autowired
	private ProcessingSinglePrimaryService processingSingleModelPrimaryService;

	@Autowired
	private ProcessingSingleDetailService processingSingleModelDetailService;
	
	@Override
	public ProductionTask query(ProductionTask productionTask) {
		// TODO Auto-generated method stub
		return productionTaskDao.query(productionTask);
	}

	@Override
	public void update(ProductionTask productionTask) {
		// TODO Auto-generated method stub
		productionTaskDao.update(productionTask);
	}

	@Override
	public List<ProductionTask> queryList(ProductionTask productionTask) {
		// TODO Auto-generated method stub
		return productionTaskDao.queryList(productionTask);
	}

	@Override
	public List<ProductionTask> queryList(ProductionTask productionTask,
			Pager page) {
		// TODO Auto-generated method stub
		return productionTaskDao.queryPageList(productionTask, page);
	}

	@Override
	public Integer count(ProductionTask productionTask) {
		// TODO Auto-generated method stub
		return productionTaskDao.count(productionTask);
	}

	@Override
	public void delete(ProductionTask productionTask) {
		// TODO Auto-generated method stub
		productionTaskDao.delete(productionTask);
	}

	@Override
	public Integer insert(ProductionTask productionTask) 
	{
		return productionTaskDao.insert(productionTask);
	}

	public ProductionTaskDao getProductionTaskDao() {
		return productionTaskDao;
	}

	public void setProductionTaskDao(ProductionTaskDao productionTaskDao) {
		this.productionTaskDao = productionTaskDao;
	}

	@Override
	public void increaseStock(Integer id) {
		ProductionTask productionTask = new ProductionTask();
		productionTask.setId(id);
		ProductionTask reult = this.query(productionTask);
		if (null == reult)
		{
			throw new ProjectException("数据库不存在该单据");
		}
		
		if (0 == reult.getStatus())
		{
			//设置入库状态
			productionTask.setStatus(1);
			this.update(productionTask);
			
			//单据入库
			StockUtil stockUtil = StockUtil.getInstance();
			stockUtil.operationStock(reult.getId(),reult.getWarehouseID(),StockUtil.TASK_REDUCE);
		}else
		{
			throw new ProjectException("领料单据号：" + reult.getId() + "，已经入库!不允许重复入库");
		}
	}

}
