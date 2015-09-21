package com.zh.web.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.base.model.bean.Warehouse;
import com.zh.base.service.WarehouseService;
import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;
import com.zh.core.model.Pager;
import com.zh.core.util.DateUtil;
import com.zh.web.model.LibraryPrimaryModel;
import com.zh.web.model.bean.LibraryDetail;
import com.zh.web.model.bean.LibraryPrimary;
import com.zh.web.model.bean.SalesOrderPrimary;
import com.zh.web.service.LibraryDetailService;
import com.zh.web.service.LibraryPrimaryService;
import com.zh.web.service.SalesOrderPrimaryService;
import com.zh.web.util.UtilService;



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
	private LibraryPrimaryService libraryPrimaryService;

	@Autowired
	private LibraryDetailService libraryDetailService;
	
	@Autowired
	private SalesOrderPrimaryService salesOrderPrimaryService;

	@Autowired
	private WarehouseService warehouseService;

	private LibraryPrimaryModel libraryPrimaryModel = new LibraryPrimaryModel();

	@Override
	public Object getModel() {
		return libraryPrimaryModel;
	}

	@Override
	public String execute() throws Exception {
		LibraryPrimary libraryPrimary = this.libraryPrimaryModel.getLibraryPrimary();
		libraryPrimary.setIsStorage(1);
		Integer count = libraryPrimaryService.count(libraryPrimary);
		Pager page = this.libraryPrimaryModel.getPageInfo();
		page.setTotalRow(count);
		List<LibraryPrimary> libraryPrimaryList = libraryPrimaryService.queryList(libraryPrimary, page);
		this.libraryPrimaryModel.setLibraryPrimaryList(libraryPrimaryList);
		return Action.SUCCESS;
	}

	public String editor() throws Exception {
		LOGGER.debug("editor()");
		Long id = this.libraryPrimaryModel.getId();

		// 获取仓库信息
		Warehouse warehouse = new Warehouse();
		warehouse.setEnabled(UtilService.ENABLED_EFFECTIVE);
		warehouse.setType(UtilService.WAREHOUSE_TYPE_ONE);
		List<Warehouse> warehouseList = warehouseService.queryList(warehouse);
		this.libraryPrimaryModel.setWarehouseList(warehouseList);
		
		// 客户信息
		
		SalesOrderPrimary salesOrderPrimary = new SalesOrderPrimary();
		//销售订单
		List<SalesOrderPrimary> salesOrderPrimaryList = salesOrderPrimaryService.queryList(salesOrderPrimary );
		this.libraryPrimaryModel.setSalesOrderPrimaryList(salesOrderPrimaryList);
		
		
		if (null != id) {
			// 查询信息
			LOGGER.debug("editor LibraryPrimary id " + id);
			LibraryPrimary libraryPrimary = this.libraryPrimaryModel
					.getLibraryPrimary();
			libraryPrimary.setId(Long.valueOf(id));
			LibraryPrimary reult = libraryPrimaryService.query(libraryPrimary);
			this.libraryPrimaryModel.setLibraryPrimary(reult);

			// 查询入库明细
			LibraryDetail libraryDetail = this.libraryPrimaryModel.getLibraryDetail();
			libraryDetail.setLibraryPrimaryID(id);
			Pager page = this.libraryPrimaryModel.getPageInfo();
			Integer count = libraryDetailService.count(libraryDetail);
			page.setTotalRow(count);
			
			libraryDetail.setWarehouseID(reult.getWarehouseID());
			List<LibraryDetail> list = libraryDetailService.queryList(libraryDetail, page);
			this.libraryPrimaryModel.setLibraryDetailList(list);

			// 判断是否已经入库，入库状态下，只进入查看页面
			Integer status = reult.getStatus();
			String view = this.libraryPrimaryModel.getView();
			if (status == 1 || "view".equals(view)) {
				return Action.VIEW;
			}
		} else {
			Long userID = this.queryUser().getId();
			this.libraryPrimaryModel.getLibraryPrimary().setUserID(userID);
			this.libraryPrimaryModel.getLibraryPrimary().setLibrarydate(
					DateUtil.getCreated());
		}
		return Action.EDITOR;
	}
	
	public String save() throws Exception {
		LOGGER.debug("save()");
		LibraryPrimary libraryPrimary = this.libraryPrimaryModel
				.getLibraryPrimary();
		Long id = this.libraryPrimaryModel.getId();
		if (null != id && !"".equals(id)) {
			libraryPrimary.setId(id);
			libraryPrimaryService.update(libraryPrimary);
			LOGGER.debug("update libraryPrimary id" + id);
		} else {
			// 新增
			libraryPrimaryService.insert(libraryPrimary,
					UtilService.LIBRARY_TYPE);
			LOGGER.debug("add libraryPrimary");
		}
		this.libraryPrimaryModel.setFormId(libraryPrimary.getId().toString());
		return Action.EDITOR_SAVE;
	}

}
