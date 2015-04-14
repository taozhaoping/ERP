package com.zh.web.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.base.model.bean.Dictionary;
import com.zh.core.base.model.BaseModel;
import com.zh.web.model.bean.BOMPrimary;
import com.zh.web.model.bean.Products;

public class ProductsModel extends BaseModel {

	private Products products = new Products();
	
	private List<Products> productsList = new ArrayList<Products>();
	
	private List<Dictionary> productTypeList = new ArrayList<Dictionary>();
	
	private List<Dictionary> paintList = new ArrayList<Dictionary>();
	
	private List<Dictionary> sourceTypeList = new ArrayList<Dictionary>();
	
	private BOMPrimary ProductStructure = new BOMPrimary();
	
	private List<BOMPrimary> ProductStructureList = new ArrayList<BOMPrimary>();


	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public List<Products> getProductsList() {
		return productsList;
	}

	public void setProductsList(List<Products> productsList) {
		this.productsList = productsList;
	}

	public List<Dictionary> getProductTypeList() {
		return productTypeList;
	}

	public void setProductTypeList(List<Dictionary> productTypeList) {
		this.productTypeList = productTypeList;
	}

	public List<Dictionary> getPaintList() {
		return paintList;
	}

	public void setPaintList(List<Dictionary> paintList) {
		this.paintList = paintList;
	}

	public List<Dictionary> getSourceTypeList() {
		return sourceTypeList;
	}

	public void setSourceTypeList(List<Dictionary> sourceTypeList) {
		this.sourceTypeList = sourceTypeList;
	}

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
