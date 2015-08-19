package com.zh.web.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;
import com.zh.core.model.Pager;
import com.zh.web.model.ProcessingSingleModel;
import com.zh.web.model.bean.ProcessingSingleDetail;
import com.zh.web.model.bean.ProcessingSinglePrimary;
import com.zh.web.model.bean.PurchaseOrderPrimary;
import com.zh.web.model.bean.SalesOrderPrimary;
import com.zh.web.service.ProcessingSingleDetailService;
import com.zh.web.service.ProcessingSinglePrimaryService;
import com.zh.web.service.PurchaseOrderPrimaryService;
import com.zh.web.service.SalesOrderPrimaryService;
import com.zh.web.util.UtilService;


/**
 * 加工单
 * @author 21829(cai_yingying@dahuatech.com)
 *
 * 2015年7月22日 下午7:31:51
 *
 */
public class ProcessingSingleAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2398683237741425561L;

	private static Logger LOGGER = LoggerFactory.getLogger(ProcessingSingleAction.class);

	@Autowired
	private ProcessingSinglePrimaryService processingSingleModelPrimaryService;

	@Autowired
	private ProcessingSingleDetailService processingSingleModelDetailService;

	@Autowired
	private SalesOrderPrimaryService salesOrderPrimaryService;
	
	private ProcessingSingleModel processingSingleModel = new ProcessingSingleModel();

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return processingSingleModel;
	}

	@Override
	public String execute() throws Exception {
		ProcessingSinglePrimary processingSingleModelPrimary = this.processingSingleModel.getProcessingSinglePrimary();
		
//		processingSingleModelPrimary.setIsProcessingSingle(1);
		Integer count = processingSingleModelPrimaryService.count(processingSingleModelPrimary);
		Pager page = this.processingSingleModel.getPageInfo();
		page.setTotalRow(count);
		List<ProcessingSinglePrimary> processingSingleModelPrimaryList = processingSingleModelPrimaryService
				.queryList(processingSingleModelPrimary, page);
		this.processingSingleModel.setProcessingSinglePrimaryList(processingSingleModelPrimaryList);
		
		return Action.SUCCESS;
	}


	public String editor() throws Exception {
		LOGGER.debug("editor()");
		Integer id = this.processingSingleModel.getId();

		//销售订单
		SalesOrderPrimary salesOrderPrimary = new SalesOrderPrimary();
		
		//TODO
		//查询没有关联的，采购状态的销售订单
		List<SalesOrderPrimary> salesOrderPrimaryList = salesOrderPrimaryService.queryList(salesOrderPrimary);
		this.processingSingleModel.setSalesOrderPrimaryList(salesOrderPrimaryList);

		if (null != id) {
			// 查询信息
			LOGGER.debug("editor ProcessingSinglePrimary id " + id);
			ProcessingSinglePrimary processingSingleModelPrimary = this.processingSingleModel
					.getProcessingSinglePrimary();
			processingSingleModelPrimary.setId(Integer.valueOf(id));
			ProcessingSinglePrimary reult = processingSingleModelPrimaryService.query(processingSingleModelPrimary);
			this.processingSingleModel.setProcessingSinglePrimary(reult);

			// 查询入库明细
			ProcessingSingleDetail processingSingleModelDetail = this.processingSingleModel
					.getProcessingSingleDetail();
//			processingSingleModelDetail.setProcessingSinglePrimaryID(id);
			Pager page = this.processingSingleModel.getPageInfo();
			Integer count = processingSingleModelDetailService.count(processingSingleModelDetail);
			page.setTotalRow(count);
			List<ProcessingSingleDetail> list = processingSingleModelDetailService.queryList(
					processingSingleModelDetail, page);
			this.processingSingleModel.setProcessingSingleDetailList(list);

			// 判断是否已经入库，入库状态下，只进入查看页面
			Integer status = reult.getStatus();
			String view = this.processingSingleModel.getView();
			if (status == 1 || "view".equals(view)) {
				return Action.VIEW;
			}
		} else {
			Integer userID = this.queryUser().getId();
//			this.processingSingleModel.getProcessingSinglePrimary().setUserID(userID);
//			this.processingSingleModel.getProcessingSinglePrimary().setProcessingSingledate(DateUtil.getCreated());
		}
		return Action.EDITOR;
	}

	public String saveProcessingSingleDetail() {
		LOGGER.debug("save ProcessingSingleDetail ()");
		ProcessingSingleDetail processingSingleModelDetail = this.processingSingleModel
				.getProcessingSingleDetail();
		Integer id = this.processingSingleModel.getId();
		if (null == id || "".equals(id)) {
			// 新增
			processingSingleModelDetailService.insert(processingSingleModelDetail);
		} else {
			// 修改
			processingSingleModelDetail.setId(id);
			processingSingleModelDetailService.delete(processingSingleModelDetail);
		}
		String formId = this.processingSingleModel.getFormId();
		this.processingSingleModel.setFormId(formId);
		return Action.EDITOR_SAVE;

	}

	public String save() throws Exception {
		LOGGER.debug("save()");
		ProcessingSinglePrimary processingSingleModelPrimary = this.processingSingleModel.getProcessingSinglePrimary();
		Integer id = this.processingSingleModel.getId();
		if (null != id && !"".equals(id)) {
			processingSingleModelPrimary.setId(id);
			processingSingleModelPrimaryService.update(processingSingleModelPrimary);
			LOGGER.debug("update processingSingleModelPrimary id" + id);
		} else {
			// 新增
			processingSingleModelPrimaryService.insert(processingSingleModelPrimary, UtilService.ORDER_STORAGE_TYPE);
			LOGGER.debug("add processingSingleModelPrimary");
		}
		this.processingSingleModel.setFormId(processingSingleModelPrimary.getId().toString());
		return Action.EDITOR_SAVE;
	}

}
