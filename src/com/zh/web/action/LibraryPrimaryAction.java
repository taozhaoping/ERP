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
import com.zh.web.model.LibraryPrimaryModel;
import com.zh.web.model.bean.Customer;
import com.zh.web.model.bean.LibraryDetail;
import com.zh.web.model.bean.LibraryPrimary;
import com.zh.web.service.CustomerService;
import com.zh.web.service.LibraryDetailService;
import com.zh.web.service.LibraryPrimaryService;
import com.zh.web.util.UtilService;

public class LibraryPrimaryAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 731437174900014739L;

	private static Logger LOGGER = LoggerFactory
			.getLogger(LibraryPrimaryAction.class);

	@Autowired
	private LibraryPrimaryService libraryPrimaryService;

	@Autowired
	private LibraryDetailService libraryDetailService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private WarehouseService warehouseService;

	private LibraryPrimaryModel libraryPrimaryModel = new LibraryPrimaryModel();

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return libraryPrimaryModel;
	}

	@Override
	public String execute() throws Exception {
		LibraryPrimary libraryPrimary = this.libraryPrimaryModel
				.getLibraryPrimary();
		Integer count = libraryPrimaryService.count(libraryPrimary);
		Pager page = this.libraryPrimaryModel.getPageInfo();
		page.setTotalRow(count);
		List<LibraryPrimary> libraryPrimaryList = libraryPrimaryService
				.queryList(libraryPrimary, page);
		this.libraryPrimaryModel.setLibraryPrimaryList(libraryPrimaryList);
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
		String formID = this.libraryPrimaryModel.getFormId();
		if (null == formID || "".equals(formID))
		{
			throw new ParameterException("入库单据不允许为空!");
		}
		libraryPrimaryService.increaseStock(formID);

		
		return Action.EDITOR_SUCCESS;
	}

	public String editor() throws Exception {
		LOGGER.debug("editor()");
		Integer id = this.libraryPrimaryModel.getId();

		// 供应商信息
		Customer customer = new Customer();
		customer.setType(UtilService.CUSTOMER_TYPE_SUPPLIER);
		customer.setEnabled(UtilService.ENABLED_EFFECTIVE);
		List<Customer> customerList = customerService.queryList(customer);
		this.libraryPrimaryModel.setCustomerList(customerList);

		// 获取仓库信息
		Warehouse warehouse = new Warehouse();
		warehouse.setEnabled(UtilService.ENABLED_EFFECTIVE);
		List<Warehouse> warehouseList = warehouseService.queryList(warehouse);
		this.libraryPrimaryModel.setWarehouseList(warehouseList);

		if (null != id) {
			// 查询信息
			LOGGER.debug("editor LibraryPrimary id " + id);
			LibraryPrimary libraryPrimary = this.libraryPrimaryModel
					.getLibraryPrimary();
			libraryPrimary.setId(Integer.valueOf(id));
			LibraryPrimary reult = libraryPrimaryService.query(libraryPrimary);
			this.libraryPrimaryModel.setLibraryPrimary(reult);

			// 查询入库明细
			LibraryDetail libraryDetail = this.libraryPrimaryModel
					.getLibraryDetail();
			libraryDetail.setLibraryPrimaryID(id);
			Pager page = this.libraryPrimaryModel.getPageInfo();
			Integer count = libraryDetailService.count(libraryDetail);
			page.setTotalRow(count);
			List<LibraryDetail> list = libraryDetailService.queryList(
					libraryDetail, page);
			this.libraryPrimaryModel.setLibraryDetailList(list);
			
			//判断是否已经入库，入库状态下，只进入查看页面
			Integer status = reult.getStatus();
			String view = this.libraryPrimaryModel.getView();
			if (status == 1 || "view".equals(view))
			{
				return Action.VIEW;
			}
		} else {
			Integer userID = this.queryUser().getId();
			this.libraryPrimaryModel.getLibraryPrimary().setUserID(userID);
			this.libraryPrimaryModel.getLibraryPrimary().setLibrarydate(
					DateUtil.getCreated());
		}
		return Action.EDITOR;
	}

	public String saveLibraryDetail() {
		LOGGER.debug("save LibraryDetail ()");
		LibraryDetail libraryDetail = this.libraryPrimaryModel
				.getLibraryDetail();
		Integer id = this.libraryPrimaryModel.getId();
			if (null == id || "".equals(id)) {
				// 新增
				libraryDetailService.insert(libraryDetail);
			} else {
				// 修改
				libraryDetail.setId(id);
				libraryDetailService.delete(libraryDetail);
			}
		return Action.EDITOR_SAVE;

	}

	public String save() throws Exception {
		LOGGER.debug("save()");
		LibraryPrimary libraryPrimary = this.libraryPrimaryModel
				.getLibraryPrimary();
		Integer id = this.libraryPrimaryModel.getId();
		if (null != id && !"".equals(id)) {
			libraryPrimary.setId(id);
			libraryPrimaryService.update(libraryPrimary);
			LOGGER.debug("update libraryPrimary id" + id);
		} else {
			// 新增
			libraryPrimaryService.insert(libraryPrimary,
					UtilService.STORAGE_TYPE);
			LOGGER.debug("add libraryPrimary");
		}
		this.libraryPrimaryModel.setFormId(libraryPrimary.getId().toString());
		return Action.EDITOR_SAVE;
	}
}
