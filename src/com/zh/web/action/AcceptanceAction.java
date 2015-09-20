package com.zh.web.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.avalon.framework.parameters.ParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;
import com.zh.core.model.Pager;
import com.zh.core.util.DateUtil;
import com.zh.web.model.ProductionTaskModel;
import com.zh.web.model.bean.AcceptanceList;
import com.zh.web.model.bean.BomPrimary;
import com.zh.web.model.bean.ProductionTask;
import com.zh.web.model.bean.ProductionTaskDetail;
import com.zh.web.service.AcceptanceListService;
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
	private AcceptanceListService acceptanceListService;

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
		Long id = this.productionTaskModel.getId();

		if (null == id) {
			throw new ParameterException("任务单号不允许为空!");
		}
		
		// 查询信息
		LOGGER.debug("editor ProductionTask id " + id);
		ProductionTask productionTask = this.productionTaskModel
				.getProductionTask();
		productionTask.setId(Long.valueOf(id));
		ProductionTask reult = productionTaskService.query(productionTask);
		this.productionTaskModel.setProductionTask(reult);

		// 查询需求清单明细
		AcceptanceList acceptanceList = this.productionTaskModel
				.getAcceptance();
		acceptanceList.setProductionTaskID(reult.getId());
		Pager page = this.productionTaskModel.getPageInfo();
		Integer count = acceptanceListService.count(acceptanceList);
		page.setTotalRow(count);
		List<AcceptanceList> list = acceptanceListService
				.queryList(acceptanceList, page);
		this.productionTaskModel.setAcceptanceList(list);
		return Action.VIEW;
	}
	
	/** 
	 * 审核生效状态
	 */
	public String auditStatus() throws Exception {
		LOGGER.debug("auditStatus()");
		ProductionTask productionTask  = this.productionTaskModel.getProductionTask();
		//头表的主键
		Long id = productionTask.getId();
		
		this.productionTaskModel.setId(id);
		//主键为空，则是插入，不为空，更新
		if (null != id && !"".equals(id)) {
			// 获取明细的验收状态
			// 查询需求清单明细
			AcceptanceList acceptanceList = this.productionTaskModel.getAcceptance();
			acceptanceList.setProductionTaskID(id);
			List<AcceptanceList> list = acceptanceListService.queryList(acceptanceList);
			// 未验收的集合
			List<AcceptanceList> noAuditList = new ArrayList<AcceptanceList>();
			for (AcceptanceList a : list) {
				String isAcceptance = a.getIsAcceptance();
				if ("0".equalsIgnoreCase(isAcceptance)) {
					noAuditList.add(a);
				}
			}
			if (noAuditList.isEmpty()) {
				productionTask.setStatus(2);
				productionTaskService.update(productionTask);
				LOGGER.debug("auditStatus productionTask:{}", productionTask);
			} else {
				throw new ParameterException("审核失败，存在未验收的产品!");
			}
			//生效
		}else{
			throw new ParameterException("验收单不允许为空!");
		}
		return Action.EDITOR_SAVE;
	}
	
	/** 
	 * 设置验收状态
	 */
	public String updateAcceptance() throws Exception {
		LOGGER.debug("updateAcceptance()");
		AcceptanceList acceptanceList = this.productionTaskModel.getAcceptance();
		//头表的主键
		Long id = acceptanceList.getId();
		
		ProductionTask productionTask  = this.productionTaskModel.getProductionTask();
		//头表的主键
		Long taskId = productionTask.getId();
		
		this.productionTaskModel.setId(taskId);
		
		// 主键为空，则是插入，不为空，更新
		if (null != id && !"".equals(id)) {
			acceptanceList.setIsAcceptance("1");
			String acceptanceDate = DateUtil.getStringDate();
			acceptanceList.setAcceptanceDate(acceptanceDate);
			// 更新状态和验收时间
			acceptanceListService.update(acceptanceList);
			LOGGER.debug("updateAcceptance acceptanceList:{}", acceptanceList);
		} else {
			throw new ParameterException("验收单明细不允许为空!");
		}
		return Action.EDITOR_SAVE;
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
