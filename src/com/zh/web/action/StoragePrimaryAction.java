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
import com.zh.web.model.StoragePrimaryModel;
import com.zh.web.model.bean.Customer;
import com.zh.web.model.bean.StorageDetail;
import com.zh.web.model.bean.StoragePrimary;
import com.zh.web.service.CustomerService;
import com.zh.web.service.StorageDetailService;
import com.zh.web.service.StoragePrimaryService;
import com.zh.web.util.UtilService;

public class StoragePrimaryAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 731437174900014739L;

	private static Logger LOGGER = LoggerFactory
			.getLogger(StoragePrimaryAction.class);

	@Autowired
	private StoragePrimaryService storagePrimaryService;

	@Autowired
	private StorageDetailService storageDetailService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private WarehouseService warehouseService;

	private StoragePrimaryModel storagePrimaryModel = new StoragePrimaryModel();

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return storagePrimaryModel;
	}

	@Override
	public String execute() throws Exception {
		StoragePrimary storagePrimary = this.storagePrimaryModel
				.getStoragePrimary();
		Integer count = storagePrimaryService.count(storagePrimary);
		Pager page = this.storagePrimaryModel.getPageInfo();
		page.setTotalRow(count);
		List<StoragePrimary> storagePrimaryList = storagePrimaryService
				.queryList(storagePrimary, page);
		this.storagePrimaryModel.setStoragePrimaryList(storagePrimaryList);
		return Action.SUCCESS;
	}
	
	/**
	 * 
	* @Title: increaseStock 
	* @Description: 单据入库(更新库存数量) 
	* @param  @return   参数 
	* @return String    返回类型 
	* @throws 
	* @author taozhaoping 26078
	* @author mail taozhaoping@gmail.com
	 * @throws ParameterException 
	 */
	public String increaseStock() throws ParameterException
	{
		String formID = this.storagePrimaryModel.getFormId();
		if (null == formID || "".equals(formID))
		{
			throw new ParameterException("入库单据不允许为空!");
		}
		storagePrimaryService.increaseStock(formID);

		
		return Action.EDITOR_SUCCESS;
	}

	public String editor() throws Exception {
		LOGGER.debug("editor()");
		Integer id = this.storagePrimaryModel.getId();

		// 供应商信息
		Customer customer = new Customer();
		customer.setType(UtilService.CUSTOMER_TYPE_SUPPLIER);
		customer.setEnabled(UtilService.ENABLED_EFFECTIVE);
		List<Customer> customerList = customerService.queryList(customer);
		this.storagePrimaryModel.setCustomerList(customerList);

		// 获取仓库信息
		Warehouse warehouse = new Warehouse();
		warehouse.setEnabled(UtilService.ENABLED_EFFECTIVE);
		List<Warehouse> warehouseList = warehouseService.queryList(warehouse);
		this.storagePrimaryModel.setWarehouseList(warehouseList);

		if (null != id) {
			// 查询信息
			LOGGER.debug("editor StoragePrimary id " + id);
			StoragePrimary storagePrimary = this.storagePrimaryModel
					.getStoragePrimary();
			storagePrimary.setId(Integer.valueOf(id));
			StoragePrimary reult = storagePrimaryService.query(storagePrimary);
			this.storagePrimaryModel.setStoragePrimary(reult);

			// 查询入库明细
			StorageDetail storageDetail = this.storagePrimaryModel
					.getStorageDetail();
			storageDetail.setStoragePrimaryID(id);
			Pager page = this.storagePrimaryModel.getPageInfo();
			Integer count = storageDetailService.count(storageDetail);
			page.setTotalRow(count);
			List<StorageDetail> list = storageDetailService.queryList(
					storageDetail, page);
			this.storagePrimaryModel.setStorageDetailList(list);
			
			//判断是否已经入库，入库状态下，只进入查看页面
			Integer status = reult.getStatus();
			String view = this.storagePrimaryModel.getView();
			if (status == 1 || "view".equals(view))
			{
				return Action.VIEW;
			}
		} else {
			Integer userID = this.queryUser().getId();
			this.storagePrimaryModel.getStoragePrimary().setUserID(userID);
			this.storagePrimaryModel.getStoragePrimary().setStoragedate(
					DateUtil.getCreated());
		}
		return Action.EDITOR;
	}

	public String saveStorageDetail() {
		LOGGER.debug("save StorageDetail ()");
		StorageDetail storageDetail = this.storagePrimaryModel
				.getStorageDetail();
		Integer id = this.storagePrimaryModel.getId();
			if (null == id || "".equals(id)) {
				// 新增
				storageDetailService.insert(storageDetail);
			} else {
				// 修改
				storageDetail.setId(id);
				storageDetailService.delete(storageDetail);
			}
		return Action.EDITOR_SAVE;

	}

	public String save() throws Exception {
		LOGGER.debug("save()");
		StoragePrimary storagePrimary = this.storagePrimaryModel
				.getStoragePrimary();
		Integer id = this.storagePrimaryModel.getId();
		if (null != id && !"".equals(id)) {
			storagePrimary.setId(id);
			storagePrimaryService.update(storagePrimary);
			LOGGER.debug("update storagePrimary id" + id);
		} else {
			// 新增
			storagePrimaryService.insert(storagePrimary,
					UtilService.STORAGE_TYPE);
			LOGGER.debug("add storagePrimary");
		}
		this.storagePrimaryModel.setFormId(storagePrimary.getId().toString());
		return Action.EDITOR_SAVE;
	}
}
