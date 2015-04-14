package com.zh.web.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.core.base.model.BaseModel;
import com.zh.web.model.bean.BomDetail;
import com.zh.web.model.bean.BomPrimary;
import com.zh.web.model.bean.BomSub;

public class ProductStructModel extends BaseModel {

	/**
	 * 结构主表
	 */
	private BomPrimary bomPrimary = new BomPrimary();
	
	/**
	 * 结构主表列表
	 */
	private List<BomPrimary> bomPrimaryList = new ArrayList<BomPrimary>();

	/**
	 * 结构明细
	 */
	private BomDetail bomDetail = new BomDetail();
	
	/**
	 * 替代料
	 */
	private BomSub bomSub = new BomSub();
	
	/**
	 * 结构明细列表
	 */
	private List<BomDetail> bomDetailList = new ArrayList<BomDetail>();

	public BomPrimary getBomPrimary() {
		return bomPrimary;
	}

	public void setBomPrimary(BomPrimary bomPrimary) {
		this.bomPrimary = bomPrimary;
	}

	public BomDetail getBomDetail() {
		return bomDetail;
	}

	public void setBomDetail(BomDetail bomDetail) {
		this.bomDetail = bomDetail;
	}

	public BomSub getBomSub() {
		return bomSub;
	}

	public void setBomSub(BomSub bomSub) {
		this.bomSub = bomSub;
	}

	public List<BomDetail> getBomDetailList() {
		return bomDetailList;
	}

	public void setBomDetailList(List<BomDetail> bomDetailList) {
		this.bomDetailList = bomDetailList;
	}

	public List<BomPrimary> getBomPrimaryList() {
		return bomPrimaryList;
	}

	public void setBomPrimaryList(List<BomPrimary> bomPrimaryList) {
		this.bomPrimaryList = bomPrimaryList;
	}
}
