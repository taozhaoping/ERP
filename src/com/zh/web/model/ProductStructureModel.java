package com.zh.web.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.core.base.model.BaseModel;
import com.zh.web.model.bean.ProductStructure;

public class ProductStructureModel extends BaseModel {

	private ProductStructure ProductStructure = new ProductStructure();
	
	private List<ProductStructure> ProductStructureList = new ArrayList<ProductStructure>();

	public ProductStructure getProductStructure() {
		return ProductStructure;
	}

	public void setProductStructure(ProductStructure productStructure) {
		ProductStructure = productStructure;
	}

	public List<ProductStructure> getProductStructureList() {
		return ProductStructureList;
	}

	public void setProductStructureList(List<ProductStructure> productStructureList) {
		ProductStructureList = productStructureList;
	}

	
}
