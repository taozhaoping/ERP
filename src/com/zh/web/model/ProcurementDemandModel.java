package com.zh.web.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.core.base.model.BaseModel;
import com.zh.web.model.bean.ProcurementDemandDetail;
import com.zh.web.model.bean.ProcurementDemandPrimary;

public class ProcurementDemandModel extends BaseModel {

	private ProcurementDemandPrimary procurementDemandPrimary = new ProcurementDemandPrimary();

	private List<ProcurementDemandPrimary> procurementDemandPrimaryList = new ArrayList<ProcurementDemandPrimary>();

	private ProcurementDemandDetail procurementDemandDetail = new ProcurementDemandDetail();

	private List<ProcurementDemandDetail> procurementDemandDetailList = new ArrayList<ProcurementDemandDetail>();

	public ProcurementDemandPrimary getProcurementDemandPrimary() {
		return procurementDemandPrimary;
	}

	public void setProcurementDemandPrimary(
			ProcurementDemandPrimary procurementDemandPrimary) {
		this.procurementDemandPrimary = procurementDemandPrimary;
	}

	public List<ProcurementDemandPrimary> getProcurementDemandPrimaryList() {
		return procurementDemandPrimaryList;
	}

	public void setProcurementDemandPrimaryList(
			List<ProcurementDemandPrimary> procurementDemandPrimaryList) {
		this.procurementDemandPrimaryList = procurementDemandPrimaryList;
	}

	public ProcurementDemandDetail getProcurementDemandDetail() {
		return procurementDemandDetail;
	}

	public void setProcurementDemandDetail(
			ProcurementDemandDetail procurementDemandDetail) {
		this.procurementDemandDetail = procurementDemandDetail;
	}

	public List<ProcurementDemandDetail> getProcurementDemandDetailList() {
		return procurementDemandDetailList;
	}

	public void setProcurementDemandDetailList(
			List<ProcurementDemandDetail> procurementDemandDetailList) {
		this.procurementDemandDetailList = procurementDemandDetailList;
	}

}
