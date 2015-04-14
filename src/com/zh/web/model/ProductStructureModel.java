package com.zh.web.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.core.base.model.BaseModel;
import com.zh.web.model.bean.BOMPrimary;

public class ProductStructureModel extends BaseModel {

	private BOMPrimary ProductStructure = new BOMPrimary();
	
	private List<BOMPrimary> ProductStructureList = new ArrayList<BOMPrimary>();

	public BOMPrimary getProductStructure() {
		return ProductStructure;
	}

	public void setProductStructure(BOMPrimary productStructure) {
		ProductStructure = productStructure;
	}

	public List<BOMPrimary> getProductStructureList() {
		return ProductStructureList;
	}

	public void setProductStructureList(List<BOMPrimary> productStructureList) {
		ProductStructureList = productStructureList;
	}

	
}
