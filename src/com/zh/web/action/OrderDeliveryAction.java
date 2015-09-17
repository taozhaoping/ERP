package com.zh.web.action;

import java.util.List;

import org.apache.avalon.framework.parameters.ParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;
import com.zh.core.model.Pager;
import com.zh.web.model.ProcessingSingleModel;
import com.zh.web.model.bean.ProcessingSinglePrimary;
import com.zh.web.model.bean.ProductionStorageDetail;
import com.zh.web.service.ProcessingSinglePrimaryService;
import com.zh.web.service.ProductionStorageDetailService;



/**
 * 订单出库
 * @author 21829(cai_yingying@dahuatech.com)
 *
 * 2015年9月17日 下午7:12:09
 *
 */
public class OrderDeliveryAction extends BaseAction {

	private static final long serialVersionUID = 7240041287616871064L;

	private static Logger LOGGER = LoggerFactory.getLogger(OrderDeliveryAction.class);

	@Autowired
	private ProcessingSinglePrimaryService processingSinglePrimaryService;

	@Autowired
	private ProductionStorageDetailService productionStorageDetailService;

	private ProcessingSingleModel processingSingleModel = new ProcessingSingleModel();

	@Override
	public Object getModel() {
		return processingSingleModel;
	}

	@Override
	public String execute() throws Exception {
		ProcessingSinglePrimary processingSinglePrimary = this.processingSingleModel.getProcessingSinglePrimary();
		Integer count = processingSinglePrimaryService.count(processingSinglePrimary);
		Pager page = this.processingSingleModel.getPageInfo();
		page.setTotalRow(count);
		List<ProcessingSinglePrimary> ProcessingSinglePrimaryList = processingSinglePrimaryService.queryList(processingSinglePrimary, page);
		this.processingSingleModel.setProcessingSinglePrimaryList(ProcessingSinglePrimaryList);
		return Action.SUCCESS;
	}

	public String editor() throws Exception {
		LOGGER.debug("editor()");
		Integer id = this.processingSingleModel.getId();

		if (null == id) {
			throw new ParameterException("任务单号不允许为空!");
		}
		
		// 查询信息
		LOGGER.debug("editor ProductionTask id " + id);
		ProcessingSinglePrimary processingSinglePrimary = this.processingSingleModel.getProcessingSinglePrimary();
		processingSinglePrimary.setId(Integer.valueOf(id));
		ProcessingSinglePrimary reult = processingSinglePrimaryService.query(processingSinglePrimary);
		this.processingSingleModel.setProcessingSinglePrimary(reult);

		// 查询生产入库明细
		ProductionStorageDetail productionStorageDetail = this.processingSingleModel.getProductionStorageDetail();
		productionStorageDetail.setProcessingSingleId(id);
		Pager page = this.processingSingleModel.getPageInfo();
		Integer count = productionStorageDetailService.count(productionStorageDetail);
		page.setTotalRow(count);
		List<ProductionStorageDetail> list = productionStorageDetailService.queryList(productionStorageDetail, page);
		this.processingSingleModel.setProductionStorageDetailList(list);
		return Action.VIEW;
	}

	/**
	 * 采购需求单审核
	 */
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
