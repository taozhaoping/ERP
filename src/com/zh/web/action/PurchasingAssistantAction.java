package com.zh.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;
import com.zh.core.model.Pager;
import com.zh.web.model.PurchasingAssistantModel;
import com.zh.web.model.bean.Customer;
import com.zh.web.model.bean.PurchasingAssistant;
import com.zh.web.service.CustomerService;
import com.zh.web.service.PurchasingAssistantService;
import com.zh.web.util.UtilService;

/**
 * @Description: 采购助理
 * @Title: PurchasingAssistantAction.java
 * @Package com.zh.web.action
 * @date 2015年10月13日 下午3:32:41
 * @author taozhaoping 26078
 * @author mail taozhaoping@gmail.com
 * @version V1.0
 */
public class PurchasingAssistantAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8553290387012302691L;

	private PurchasingAssistantModel purchasingAssistantModel = new PurchasingAssistantModel();

	@Autowired
	private PurchasingAssistantService purchasingAssistantService;

	@Autowired
	private CustomerService customerService;

	@Override
	public Object getModel() {
		return purchasingAssistantModel;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		PurchasingAssistant purchasingAssistant = this.purchasingAssistantModel
				.getPurchasingAssistant();

		// 获取供应商集合
		Customer customer = new Customer();
		customer.setType(UtilService.CUSTOMER_TYPE_SUPPLIER);
		customer.setEnabled(UtilService.ENABLED_EFFECTIVE);
		List<Customer> customerList = customerService.queryList(customer);
		this.purchasingAssistantModel.setCustomerList(customerList);
		
		Long customerID = purchasingAssistant.getCustomerID();
		if (customerID != null && !"".equals(customerID)) {
			// 查询数据
			Integer count = purchasingAssistantService.count(purchasingAssistant);
			Pager page = this.purchasingAssistantModel.getPageInfo();
			page.setTotalRow(count);
			List<PurchasingAssistant> list = purchasingAssistantService.queryList(purchasingAssistant, page);
			this.purchasingAssistantModel.setPurchasingAssistantList(list);
		}
		return Action.SUCCESS;
	}

	@Override
	public String editor() throws Exception {
		// TODO Auto-generated method stub
		return Action.SUCCESS;
	}

	@Override
	public String save() throws Exception {
		// TODO Auto-generated method stub
		return Action.SUCCESS;
	}

	public PurchasingAssistantModel getPurchasingAssistantModel() {
		return purchasingAssistantModel;
	}

	public void setPurchasingAssistantModel(
			PurchasingAssistantModel purchasingAssistantModel) {
		this.purchasingAssistantModel = purchasingAssistantModel;
	}

	public PurchasingAssistantService getPurchasingAssistantService() {
		return purchasingAssistantService;
	}

	public void setPurchasingAssistantService(
			PurchasingAssistantService purchasingAssistantService) {
		this.purchasingAssistantService = purchasingAssistantService;
	}

}
