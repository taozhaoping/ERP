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
import com.zh.web.model.bean.ProductionTask;
import com.zh.web.model.bean.ProductionTaskDetail;
import com.zh.web.service.ProductionTaskDetailService;
import com.zh.web.service.ProductionTaskService;

/**
* @Description: 验收单
* @Title: AcceptanceAction.java 
* @Package com.zh.web.action 
* @date 2015年7月16日 下午6:49:23 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class AcceptanceAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 731437174900014739L;

	private static Logger LOGGER = LoggerFactory
			.getLogger(AcceptanceAction.class);

	@Autowired
	private ProductionTaskService productionTaskService;

	@Autowired
	private ProductionTaskDetailService productionTaskDetailService;

	private ProductionTaskModel productionTaskModel = new ProductionTaskModel();

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return productionTaskModel;
	}

	@Override
	public String execute() throws Exception {
		ProductionTask productionTask = this.productionTaskModel
				.getProductionTask();
		Integer count = productionTaskService.count(productionTask);
		Pager page = this.productionTaskModel.getPageInfo();
		page.setTotalRow(count);
		List<ProductionTask> productionTaskList = productionTaskService
				.queryList(productionTask, page);
		this.productionTaskModel.setProductionTaskList(productionTaskList);
		return Action.SUCCESS;
	}

	public String editor() throws Exception {
		LOGGER.debug("editor()");
		Integer id = this.productionTaskModel.getId();

		if (null == id) {
			throw new ParameterException("任务单号不允许为空!");
		}
		
		// 查询信息
		LOGGER.debug("editor ProductionTask id " + id);
		ProductionTask productionTask = this.productionTaskModel
				.getProductionTask();
		productionTask.setId(Integer.valueOf(id));
		ProductionTask reult = productionTaskService.query(productionTask);
		this.productionTaskModel.setProductionTask(reult);

		// 查询需求清单明细
		ProductionTaskDetail productionTaskDetail = this.productionTaskModel
				.getProductionTaskDetail();
		productionTaskDetail.setProductionTaskID(id);
		Pager page = this.productionTaskModel.getPageInfo();
		Integer count = productionTaskDetailService.count(productionTaskDetail);
		page.setTotalRow(count);
		List<ProductionTaskDetail> list = productionTaskDetailService
				.queryList(productionTaskDetail, page);
		this.productionTaskModel.setProductionTaskDetailList(list);
		return Action.VIEW;
	}

	
	public String approvalDemand() throws Exception {
		return Action.EDITOR_SUCCESS;
	}

	public String saveProcurementDemandDetail() {
		return Action.EDITOR_SAVE;
	}

	public String save() throws Exception {
		return Action.EDITOR_SAVE;
	}
}
