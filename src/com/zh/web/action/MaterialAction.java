package com.zh.web.action;

import java.util.List;

import org.apache.avalon.framework.parameters.ParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;
import com.zh.core.model.Pager;
import com.zh.web.model.ProductionTaskModel;
import com.zh.web.model.bean.MaterialRequisitionDetail;
import com.zh.web.model.bean.ProductionTask;
import com.zh.web.model.bean.PurchaseOrderPrimary;
import com.zh.web.service.MaterialRequisitionDetailService;
import com.zh.web.service.ProductionTaskService;
import com.zh.web.service.StoragePrimaryService;


/**
 * 领料单
 * @author 21829(cai_yingying@dahuatech.com)
 *
 * 2015年9月10日 下午7:20:04
 *
 */
public class MaterialAction extends BaseAction {

	private static final long serialVersionUID = 7240041287616871064L;

	private static Logger LOGGER = LoggerFactory.getLogger(MaterialAction.class);

	@Autowired
	private ProductionTaskService productionTaskService;

	@Autowired
	private MaterialRequisitionDetailService materialRequisitionDetailService;

	private ProductionTaskModel productionTaskModel = new ProductionTaskModel();

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return productionTaskModel;
	}
	

	@Override
	public String execute() throws Exception {
		ProductionTask productionTask = this.productionTaskModel.getProductionTask();
		Integer count = productionTaskService.count(productionTask);
		Pager page = this.productionTaskModel.getPageInfo();
		page.setTotalRow(count);
		List<ProductionTask> productionTaskList = productionTaskService.queryList(productionTask, page);
		this.productionTaskModel.setProductionTaskList(productionTaskList);
		return Action.SUCCESS;
	}

	public String editor() throws Exception {
		LOGGER.debug("editor()");
		Long id = this.productionTaskModel.getId();

		if (null == id) {
			throw new ParameterException("任务单号不允许为空!");
		}
		
		// 查询信息
		LOGGER.debug("editor ProductionTask id " + id);
		ProductionTask productionTask = this.productionTaskModel.getProductionTask();
		productionTask.setId(Long.valueOf(id));
		ProductionTask reult = productionTaskService.query(productionTask);
		this.productionTaskModel.setProductionTask(reult);

		// 查询领料单明细
		MaterialRequisitionDetail materialRequisitionDetail = this.productionTaskModel.getMaterialRequisitionDetail();
		materialRequisitionDetail.setProductiontaskId(id);
		Pager page = this.productionTaskModel.getPageInfo();
		Integer count = materialRequisitionDetailService.count(materialRequisitionDetail);
		page.setTotalRow(count);
		List<MaterialRequisitionDetail> list = materialRequisitionDetailService.queryList(materialRequisitionDetail, page);
		this.productionTaskModel.setMaterialRequisitionDetailList(list);
		return Action.VIEW;
	}

	/**
	 * 领料单审核
	 */
	public String approvalDemand() throws Exception {
		LOGGER.debug("examine SalesOrder ()");
		Long id = this.productionTaskModel.getId();
		if (null == id || "".equals(id)) {
			throw new ParameterException("领料单号不允许为空!");
		}
		productionTaskService.increaseStock(id);
		
		return Action.EDITOR_SUCCESS;
	}


	public String saveProcurementDemandDetail() {
		return Action.EDITOR_SAVE;
	}

	public String save() throws Exception {
		return Action.EDITOR_SAVE;
	}
}
