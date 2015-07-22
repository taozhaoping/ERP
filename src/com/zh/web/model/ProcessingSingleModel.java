package com.zh.web.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.core.base.model.BaseModel;
import com.zh.web.model.bean.ProcessingSingleDetail;
import com.zh.web.model.bean.ProcessingSinglePrimary;

public class ProcessingSingleModel extends BaseModel {

	private ProcessingSinglePrimary processingSinglePrimary = new ProcessingSinglePrimary();

	private List<ProcessingSinglePrimary> processingSinglePrimaryList = new ArrayList<ProcessingSinglePrimary>();

	private ProcessingSingleDetail processingSingleDetail = new ProcessingSingleDetail();

	private List<ProcessingSingleDetail> processingSingleDetailList = new ArrayList<ProcessingSingleDetail>();
	

	public ProcessingSinglePrimary getProcessingSinglePrimary() {
		return processingSinglePrimary;
	}

	public void setProcessingSinglePrimary(ProcessingSinglePrimary ProcessingSinglePrimary) {
		this.processingSinglePrimary = ProcessingSinglePrimary;
	}

	public List<ProcessingSinglePrimary> getProcessingSinglePrimaryList() {
		return processingSinglePrimaryList;
	}

	public void setProcessingSinglePrimaryList(List<ProcessingSinglePrimary> ProcessingSinglePrimaryList) {
		this.processingSinglePrimaryList = ProcessingSinglePrimaryList;
	}

	public ProcessingSingleDetail getProcessingSingleDetail() {
		return processingSingleDetail;
	}

	public void setProcessingSingleDetail(ProcessingSingleDetail ProcessingSingleDetail) {
		this.processingSingleDetail = ProcessingSingleDetail;
	}


	public List<ProcessingSingleDetail> getProcessingSingleDetailList() {
		return processingSingleDetailList;
	}

	public void setProcessingSingleDetailList(List<ProcessingSingleDetail> ProcessingSingleDetailList) {
		this.processingSingleDetailList = ProcessingSingleDetailList;
	}
	
}
