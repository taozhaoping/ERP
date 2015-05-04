package com.zh.web.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.zh.core.base.action.BaseAction;
import com.zh.web.model.PurchaseOrderModel;
import com.zh.web.service.PurchaseOrderDetailService;
import com.zh.web.service.PurchaseOrderPrimaryService;

public class PurchaseOrderAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2055529417633768596L;
	
	private PurchaseOrderModel purchaseOrderModel = new PurchaseOrderModel();

	@Autowired
	private PurchaseOrderPrimaryService purchaseOrderPrimaryService;
	
	@Autowired
	private PurchaseOrderDetailService purchaseOrderDetailService;
	
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return purchaseOrderModel;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editor() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public PurchaseOrderModel getPurchaseOrderModel() {
		return purchaseOrderModel;
	}

	public void setPurchaseOrderModel(PurchaseOrderModel purchaseOrderModel) {
		this.purchaseOrderModel = purchaseOrderModel;
	}

	public PurchaseOrderPrimaryService getPurchaseOrderPrimaryService() {
		return purchaseOrderPrimaryService;
	}

	public void setPurchaseOrderPrimaryService(
			PurchaseOrderPrimaryService purchaseOrderPrimaryService) {
		this.purchaseOrderPrimaryService = purchaseOrderPrimaryService;
	}

	public PurchaseOrderDetailService getPurchaseOrderDetailService() {
		return purchaseOrderDetailService;
	}

	public void setPurchaseOrderDetailService(
			PurchaseOrderDetailService purchaseOrderDetailService) {
		this.purchaseOrderDetailService = purchaseOrderDetailService;
	}

}
