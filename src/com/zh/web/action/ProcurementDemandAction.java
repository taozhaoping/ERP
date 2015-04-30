package com.zh.web.action;

import java.util.List;

import org.apache.avalon.framework.parameters.ParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.base.model.bean.Warehouse;
import com.zh.base.service.WarehouseService;
import com.zh.base.util.DateUtil;
import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;
import com.zh.core.model.Pager;
import com.zh.web.model.ProcurementDemandModel;
import com.zh.web.model.bean.Customer;
import com.zh.web.model.bean.ProcurementDemandDetail;
import com.zh.web.model.bean.ProcurementDemandPrimary;
import com.zh.web.service.CustomerService;
import com.zh.web.service.ProcurementDemandDetailService;
import com.zh.web.service.ProcurementDemandPrimaryService;
import com.zh.web.util.UtilService;

public class ProcurementDemandAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 731437174900014739L;

	private static Logger LOGGER = LoggerFactory
			.getLogger(ProcurementDemandAction.class);

	@Autowired
	private ProcurementDemandPrimaryService procurementDemandPrimaryService;

	@Autowired
	private ProcurementDemandDetailService procurementDemandDetailService;

	private ProcurementDemandModel procurementDemandModel = new ProcurementDemandModel();

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return procurementDemandModel;
	}

	@Override
	public String execute() throws Exception {
		ProcurementDemandPrimary procurementDemandPrimary = this.procurementDemandModel
				.getProcurementDemandPrimary();
		Integer count = procurementDemandPrimaryService.count(procurementDemandPrimary);
		Pager page = this.procurementDemandModel.getPageInfo();
		page.setTotalRow(count);
		List<ProcurementDemandPrimary> procurementDemandPrimaryList = procurementDemandPrimaryService
				.queryList(procurementDemandPrimary, page);
		this.procurementDemandModel.setProcurementDemandPrimaryList(procurementDemandPrimaryList);
		return Action.SUCCESS;
	}

	public String editor() throws Exception {
		LOGGER.debug("editor()");
		Integer id = this.procurementDemandModel.getId();

		if (null != id) {
			// 查询信息
			LOGGER.debug("editor ProcurementDemandPrimary id " + id);
			ProcurementDemandPrimary procurementDemandPrimary = this.procurementDemandModel
					.getProcurementDemandPrimary();
			procurementDemandPrimary.setId(Integer.valueOf(id));
			ProcurementDemandPrimary reult = procurementDemandPrimaryService.query(procurementDemandPrimary);
			this.procurementDemandModel.setProcurementDemandPrimary(reult);

			// 查询入库明细
			ProcurementDemandDetail procurementDemandDetail = this.procurementDemandModel
					.getProcurementDemandDetail();
			procurementDemandDetail.setProcurementID(id);
			Pager page = this.procurementDemandModel.getPageInfo();
			Integer count = procurementDemandDetailService.count(procurementDemandDetail);
			page.setTotalRow(count);
			List<ProcurementDemandDetail> list = procurementDemandDetailService.queryList(
					procurementDemandDetail, page);
			this.procurementDemandModel.setProcurementDemandDetailList(list);

			// 判断是否已经入库，入库状态下，只进入查看页面
			Integer status = reult.getStatus();
			String view = this.procurementDemandModel.getView();
			if (status == 1 || "view".equals(view)) {
				return Action.VIEW;
			}
		} else {
			Integer userID = this.queryUser().getId();
			this.procurementDemandModel.getProcurementDemandPrimary().setUserID(userID);
			this.procurementDemandModel.getProcurementDemandPrimary().setCreateDate(
					DateUtil.getCreated());
		}
		return Action.EDITOR;
	}

	public String saveProcurementDemandDetail() {
		LOGGER.debug("save ProcurementDemandDetail ()");
		ProcurementDemandDetail procurementDemandDetail = this.procurementDemandModel
				.getProcurementDemandDetail();
		Integer id = this.procurementDemandModel.getId();
		if (null == id || "".equals(id)) {
			// 新增
			procurementDemandDetailService.insert(procurementDemandDetail);
		} else {
			// 修改
			procurementDemandDetail.setId(id);
			procurementDemandDetailService.delete(procurementDemandDetail);
		}
		String formId = this.procurementDemandModel.getFormId();
		this.procurementDemandModel.setFormId(formId);
		return Action.EDITOR_SAVE;

	}

	public String save() throws Exception {
		LOGGER.debug("save()");
		ProcurementDemandPrimary procurementDemandPrimary = this.procurementDemandModel
				.getProcurementDemandPrimary();
		Integer id = this.procurementDemandModel.getId();
		if (null != id && !"".equals(id)) {
			procurementDemandPrimary.setId(id);
			procurementDemandPrimaryService.update(procurementDemandPrimary);
			LOGGER.debug("update procurementDemandPrimary id" + id);
		} else {
			// 新增
			procurementDemandPrimaryService.insert(procurementDemandPrimary,
					UtilService.STORAGE_TYPE);
			LOGGER.debug("add procurementDemandPrimary");
		}
		this.procurementDemandModel.setFormId(procurementDemandPrimary.getId().toString());
		return Action.EDITOR_SAVE;
	}
}
