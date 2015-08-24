package com.zh.web.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.core.base.model.BaseModel;
import com.zh.web.model.bean.ProductionTask;

public class ProductionTaskModel extends BaseModel {

	private ProductionTask productionTask = new ProductionTask();
	
	private List<ProductionTask> ProductionTaskList = new ArrayList<ProductionTask>();

	public ProductionTask getProductionTask() {
		return productionTask;
	}

	public void setProductionTask(ProductionTask productionTask) {
		this.productionTask = productionTask;
	}

	public List<ProductionTask> getProductionTaskList() {
		return ProductionTaskList;
	}

	public void setProductionTaskList(List<ProductionTask> productionTaskList) {
		ProductionTaskList = productionTaskList;
	}
	
	
}
