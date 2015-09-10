package com.zh.web.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.core.base.model.BaseModel;
import com.zh.web.model.bean.AcceptanceList;
import com.zh.web.model.bean.MaterialRequisitionDetail;
import com.zh.web.model.bean.ProductionTask;
import com.zh.web.model.bean.ProductionTaskDetail;

public class ProductionTaskModel extends BaseModel {

	private ProductionTask productionTask = new ProductionTask();
	
	private List<ProductionTask> ProductionTaskList = new ArrayList<ProductionTask>();

	private ProductionTaskDetail productionTaskDetail = new ProductionTaskDetail();
	
	/**
	 * 领料单明细
	 */
	private MaterialRequisitionDetail materialRequisitionDetail = new MaterialRequisitionDetail();
	
	private List<ProductionTaskDetail> productionTaskDetailList = new ArrayList<ProductionTaskDetail>();

	/**
	 * 领料单明细
	 */
	private List<MaterialRequisitionDetail> materialRequisitionDetailList = new ArrayList<MaterialRequisitionDetail>();
	
	private AcceptanceList acceptance = new AcceptanceList();
	
	private List<AcceptanceList> acceptanceList = new ArrayList<AcceptanceList>();
	
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

	public ProductionTaskDetail getProductionTaskDetail() {
		return productionTaskDetail;
	}

	public void setProductionTaskDetail(ProductionTaskDetail productionTaskDetail) {
		this.productionTaskDetail = productionTaskDetail;
	}

	public List<ProductionTaskDetail> getProductionTaskDetailList() {
		return productionTaskDetailList;
	}

	public void setProductionTaskDetailList(
			List<ProductionTaskDetail> productionTaskDetailList) {
		this.productionTaskDetailList = productionTaskDetailList;
	}

	public AcceptanceList getAcceptance() {
		return acceptance;
	}

	public void setAcceptance(AcceptanceList acceptance) {
		this.acceptance = acceptance;
	}

	public List<AcceptanceList> getAcceptanceList() {
		return acceptanceList;
	}

	public void setAcceptanceList(List<AcceptanceList> acceptanceList) {
		this.acceptanceList = acceptanceList;
	}

	public List<MaterialRequisitionDetail> getMaterialRequisitionDetailList() {
		return materialRequisitionDetailList;
	}

	public void setMaterialRequisitionDetailList(
			List<MaterialRequisitionDetail> materialRequisitionDetailList) {
		this.materialRequisitionDetailList = materialRequisitionDetailList;
	}

	public MaterialRequisitionDetail getMaterialRequisitionDetail() {
		return materialRequisitionDetail;
	}

	public void setMaterialRequisitionDetail(
			MaterialRequisitionDetail materialRequisitionDetail) {
		this.materialRequisitionDetail = materialRequisitionDetail;
	}
	
}
