package com.zh.web.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.base.model.bean.Dictionary;
import com.zh.core.base.model.BaseModel;
import com.zh.web.model.bean.BomPrimary;
import com.zh.web.model.bean.Products;

public class ProductsModel extends BaseModel {

	private String productsID;
	
	private Products products = new Products();
	
	private List<Products> productsList = new ArrayList<Products>();
	
	private List<Dictionary> productTypeList = new ArrayList<Dictionary>();
	
	private List<Dictionary> paintList = new ArrayList<Dictionary>();
	
	private List<Dictionary> sourceTypeList = new ArrayList<Dictionary>();
	
	private BomPrimary ProductStructure = new BomPrimary();
	
	private List<BomPrimary> ProductStructureList = new ArrayList<BomPrimary>();


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

	public BomPrimary getProductStructure() {
		return ProductStructure;
	}

	public void setProductStructure(BomPrimary productStructure) {
		ProductStructure = productStructure;
	}

	public List<BomPrimary> getProductStructureList() {
		return ProductStructureList;
	}

	public void setProductStructureList(List<BomPrimary> productStructureList) {
		ProductStructureList = productStructureList;
	}

	public String getProductsID() {
		return productsID;
	}

	public void setProductsID(String productsID) {
		this.productsID = productsID;
	}
	
}
