package com.zh.web.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.core.base.model.BaseModel;
import com.zh.web.model.bean.Customer;
import com.zh.web.model.bean.PurchasingAssistant;

/**
* @Description: 采购助理
* @Title: PurchasingAssistantModel.java 
* @Package com.zh.web.model 
* @date 2015年10月13日 下午3:32:23 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class PurchasingAssistantModel extends BaseModel {

	private PurchasingAssistant purchasingAssistant = new PurchasingAssistant();
	
	private List<PurchasingAssistant> purchasingAssistantList = new ArrayList<PurchasingAssistant>();

	private List<Customer> customerList = new ArrayList<Customer>();
	
	public PurchasingAssistant getPurchasingAssistant() {
		return purchasingAssistant;
	}

	public void setPurchasingAssistant(PurchasingAssistant purchasingAssistant) {
		this.purchasingAssistant = purchasingAssistant;
	}

	public List<PurchasingAssistant> getPurchasingAssistantList() {
		return purchasingAssistantList;
	}

	public void setPurchasingAssistantList(
			List<PurchasingAssistant> purchasingAssistantList) {
		this.purchasingAssistantList = purchasingAssistantList;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	
}
