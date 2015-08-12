package com.zh.web.action;

import java.util.List;
import java.util.Map;

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
import com.zh.web.model.InventoryCountModel;
import com.zh.web.model.bean.InventoryCountDetail;
import com.zh.web.model.bean.InventoryCountPrimary;
import com.zh.web.service.InventoryCountDetailService;
import com.zh.web.service.InventoryCountPrimaryService;
import com.zh.web.util.UtilService;

/**
 * @Description: 库存盘点
 * @Title: InventoryCountAction.java
 * @Package com.zh.web.action
 * @date 2015年7月7日 下午7:07:11
 * @author taozhaoping 26078
 * @author mail taozhaoping@gmail.com
 * @version V1.0
 */
public class InventoryCountAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger LOGGER = LoggerFactory
			.getLogger(InventoryCountAction.class);

	@Autowired
	private InventoryCountPrimaryService inventoryCountPrimaryService;

	@Autowired
	private InventoryCountDetailService inventoryCountDetailService;

	@Autowired
	private WarehouseService warehouseService;

	private InventoryCountModel inventoryCountModel = new InventoryCountModel();

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return inventoryCountModel;
	}

	@Override
	public String execute() throws Exception {
		InventoryCountPrimary inventoryCountPrimary = this.inventoryCountModel
				.getInventoryCountPrimary();
		Integer count = inventoryCountPrimaryService
				.count(inventoryCountPrimary);
		Pager page = this.inventoryCountModel.getPageInfo();
		page.setTotalRow(count);
		List<InventoryCountPrimary> inventoryCountPrimaryList = inventoryCountPrimaryService
				.queryList(inventoryCountPrimary, page);
		this.inventoryCountModel
				.setInventoryCountPrimaryList(inventoryCountPrimaryList);
		return Action.SUCCESS;
	}

	/**
	 * 
	 * @Title: increaseStock
	 * @Description: 库存盘点更新库存
	 * @param @return 参数
	 * @return String 返回类型
	 * @throws
	 * @author taozhaoping 26078
	 * @author mail taozhaoping@gmail.com
	 * @throws ParameterException
	 */
	public String increaseStock() throws ParameterException {
		String formID = this.inventoryCountModel.getFormId();
		if (null == formID || "".equals(formID)) {
			throw new ParameterException("库存盘点单据不允许为空!");
		}

		return Action.EDITOR_SUCCESS;
	}

	public String editor() throws Exception {
		LOGGER.debug("editor()");
		Integer id = this.inventoryCountModel.getId();

		// 获取仓库信息
		Warehouse warehouse = new Warehouse();
		warehouse.setEnabled(UtilService.ENABLED_EFFECTIVE);
		List<Warehouse> warehouseList = warehouseService.queryList(warehouse);
		warehouse.setId(0);
		warehouse.setName("全部库存");
		warehouseList.set(0, warehouse);
		this.inventoryCountModel.setWarehouseList(warehouseList);

		if (null != id) {
			// 查询信息
			LOGGER.debug("editor StoragePrimary id " + id);
			InventoryCountPrimary inventoryCountPrimary = this.inventoryCountModel
					.getInventoryCountPrimary();
			inventoryCountPrimary.setId(Integer.valueOf(id));
			InventoryCountPrimary reult = inventoryCountPrimaryService
					.query(inventoryCountPrimary);
			this.inventoryCountModel.setInventoryCountPrimary(reult);

			// 查询库存明晰
			InventoryCountDetail inventoryCountDetail = this.inventoryCountModel
					.getInventoryCountDetail();
			inventoryCountDetail.setInventoryID(id);
			Pager page = this.inventoryCountModel.getPageInfo();
			Integer count = inventoryCountDetailService
					.count(inventoryCountDetail);
			page.setTotalRow(count);
			List<InventoryCountDetail> list = inventoryCountDetailService
					.queryList(inventoryCountDetail, page);
			this.inventoryCountModel.setInventoryCountDetailList(list);

			// 判断是否已经入库，入库状态下，只进入查看页面
			Integer status = reult.getStatus();
			String view = this.inventoryCountModel.getView();
			if (status == 1 || "view".equals(view)) {
				return Action.VIEW;
			}
		} else {
			Integer userID = this.queryUser().getId();
			this.inventoryCountModel.getInventoryCountPrimary().setUserID(
					userID);
			this.inventoryCountModel.getInventoryCountPrimary().setCreateDate(
					DateUtil.getCreated());
		}
		return Action.EDITOR;
	}

	public String saveDetail() {
		LOGGER.debug("save StorageDetail ()");
		InventoryCountDetail inventoryCountDetail = this.inventoryCountModel
				.getInventoryCountDetail();
		Integer id = this.inventoryCountModel.getId();
		String changeValue = this.inventoryCountModel.getChangeValue();
		Map<String, Object> map = this.inventoryCountModel.getDataMap();
		map.put("reult", "error");
		try {
			if (null != id && id != 0) {
				// 修改
				inventoryCountDetail.setId(id);
				inventoryCountDetail.setChangeQuantiy(Float
						.valueOf(changeValue));
				inventoryCountDetailService.update(inventoryCountDetail);
				map.put("reult", "success");
			}
		} catch (Exception e) {
		}
		return Action.RETURN_JSON;

	}

	public String save() throws Exception {
		LOGGER.debug("save()");
		InventoryCountPrimary inventoryCountPrimary = this.inventoryCountModel
				.getInventoryCountPrimary();
		Integer id = this.inventoryCountModel.getId();
		if (null != id && !"".equals(id)) {
			inventoryCountPrimary.setId(id);
			inventoryCountPrimaryService.update(inventoryCountPrimary);
			LOGGER.debug("update storagePrimary id" + id);
		} else {
			// 新增
			inventoryCountPrimaryService.insert(inventoryCountPrimary);
			LOGGER.debug("add storagePrimary");
		}
		this.inventoryCountModel.setFormId(inventoryCountPrimary.getId()
				.toString());
		return Action.EDITOR_SAVE;
	}

	public InventoryCountPrimaryService getInventoryCountPrimaryService() {
		return inventoryCountPrimaryService;
	}

	public void setInventoryCountPrimaryService(
			InventoryCountPrimaryService inventoryCountPrimaryService) {
		this.inventoryCountPrimaryService = inventoryCountPrimaryService;
	}

	public InventoryCountDetailService getInventoryCountDetailService() {
		return inventoryCountDetailService;
	}

	public void setInventoryCountDetailService(
			InventoryCountDetailService inventoryCountDetailService) {
		this.inventoryCountDetailService = inventoryCountDetailService;
	}

	public WarehouseService getWarehouseService() {
		return warehouseService;
	}

	public void setWarehouseService(WarehouseService warehouseService) {
		this.warehouseService = warehouseService;
	}

	public InventoryCountModel getInventoryCountModel() {
		return inventoryCountModel;
	}

	public void setInventoryCountModel(InventoryCountModel inventoryCountModel) {
		this.inventoryCountModel = inventoryCountModel;
	}

}
