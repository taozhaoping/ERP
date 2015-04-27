package com.zh.web.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.base.model.bean.Warehouse;
import com.zh.base.util.DateUtil;
import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;
import com.zh.core.model.Pager;
import com.zh.web.model.SalesOrderModel;
import com.zh.web.model.bean.Customer;
import com.zh.web.model.bean.SalesOrderPrimary;
import com.zh.web.model.bean.StorageDetail;
import com.zh.web.model.bean.StoragePrimary;
import com.zh.web.service.SalesOrderPrimaryService;
import com.zh.web.util.UtilService;

public class SalesOrderAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 731437174900014739L;

	private static Logger LOGGER = LoggerFactory
			.getLogger(SalesOrderAction.class);

	@Autowired
	private SalesOrderPrimaryService salesOrderPrimaryService;


	private SalesOrderModel salesOrderModel = new SalesOrderModel();

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return salesOrderModel;
	}

	@Override
	public String execute() throws Exception {
		SalesOrderPrimary salesOrderPrimary = this.salesOrderModel
				.getSalesOrderPrimary();
		Integer count = salesOrderPrimaryService.count(salesOrderPrimary);
		Pager page = this.salesOrderModel.getPageInfo();
		page.setTotalRow(count);
		List<SalesOrderPrimary> salesOrderPrimaryList = salesOrderPrimaryService
				.queryList(salesOrderPrimary, page);
		this.salesOrderModel.setSalesOrderPrimaryList(salesOrderPrimaryList);
		return Action.SUCCESS;
	}

	public String editor() throws Exception {
		LOGGER.debug("editor()");
		Integer id = this.salesOrderModel.getId();

		if (null != id) {
			// 查询信息
			LOGGER.debug("editor StoragePrimary id " + id);
			SalesOrderPrimary salesOrderPrimary = this.salesOrderModel
					.getSalesOrderPrimary();
			salesOrderPrimary.setId(Integer.valueOf(id));
			SalesOrderPrimary reult = salesOrderPrimaryService.query(salesOrderPrimary);
			this.salesOrderModel.setSalesOrderPrimary(reult);

			// 查询入库明细
//			StorageDetail storageDetail = this.storagePrimaryModel
//					.getStorageDetail();
//			storageDetail.setStoragePrimaryID(id);
//			Pager page = this.storagePrimaryModel.getPageInfo();
//			Integer count = storageDetailService.count(storageDetail);
//			page.setTotalRow(count);
//			List<StorageDetail> list = storageDetailService.queryList(
//					storageDetail, page);
//			this.storagePrimaryModel.setStorageDetailList(list);

			// 判断是否已经入库，入库状态下，只进入查看页面
			Integer status = reult.getStatus();
			String view = this.salesOrderModel.getView();
			if (status == 1 || "view".equals(view)) {
				return Action.VIEW;
			}
		} else {
			Integer userID = this.queryUser().getId();
			this.salesOrderModel.getSalesOrderPrimary().setUserID(userID);
		}
		return Action.EDITOR;
	}

	public String saveStorageDetail() {
		LOGGER.debug("save StorageDetail ()");
		
		return Action.EDITOR_SAVE;

	}

	public String save() throws Exception {
		LOGGER.debug("save()");
		SalesOrderPrimary salesOrderPrimary = this.salesOrderModel
				.getSalesOrderPrimary();
		Integer id = this.salesOrderModel.getId();
		if (null != id && !"".equals(id)) {
			salesOrderPrimary.setId(id);
			salesOrderPrimaryService.update(salesOrderPrimary);
			LOGGER.debug("update storagePrimary id" + id);
		} else {
			// 新增
			salesOrderPrimaryService.insert(salesOrderPrimary,
					UtilService.STORAGE_TYPE);
			LOGGER.debug("add storagePrimary");
		}
		this.salesOrderModel.setFormId(salesOrderPrimary.getId().toString());
		return Action.EDITOR_SAVE;
	}
}
