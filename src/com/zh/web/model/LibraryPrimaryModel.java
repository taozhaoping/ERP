package com.zh.web.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.base.model.bean.Warehouse;
import com.zh.core.base.model.BaseModel;
import com.zh.web.model.bean.Customer;
import com.zh.web.model.bean.LibraryDetail;
import com.zh.web.model.bean.LibraryPrimary;

public class LibraryPrimaryModel extends BaseModel {

	private LibraryPrimary libraryPrimary = new LibraryPrimary();

	private List<LibraryPrimary> libraryPrimaryList = new ArrayList<LibraryPrimary>();

	private LibraryDetail libraryDetail = new LibraryDetail();

	private List<LibraryDetail> LibraryDetailList = new ArrayList<LibraryDetail>();

	private List<Customer> customerList = new ArrayList<Customer>();

	private List<Warehouse> warehouseList = new ArrayList<Warehouse>();

	public LibraryPrimary getLibraryPrimary() {
		return libraryPrimary;
	}

	public void setLibraryPrimary(LibraryPrimary libraryPrimary) {
		this.libraryPrimary = libraryPrimary;
	}

	public List<LibraryPrimary> getLibraryPrimaryList() {
		return libraryPrimaryList;
	}

	public void setLibraryPrimaryList(List<LibraryPrimary> libraryPrimaryList) {
		this.libraryPrimaryList = libraryPrimaryList;
	}

	public LibraryDetail getLibraryDetail() {
		return libraryDetail;
	}

	public void setLibraryDetail(LibraryDetail libraryDetail) {
		this.libraryDetail = libraryDetail;
	}

	public List<LibraryDetail> getLibraryDetailList() {
		return LibraryDetailList;
	}

	public void setLibraryDetailList(List<LibraryDetail> libraryDetailList) {
		LibraryDetailList = libraryDetailList;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public List<Warehouse> getWarehouseList() {
		return warehouseList;
	}

	public void setWarehouseList(List<Warehouse> warehouseList) {
		this.warehouseList = warehouseList;
	}

	
}
