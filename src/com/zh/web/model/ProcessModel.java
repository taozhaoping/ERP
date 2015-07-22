package com.zh.web.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.core.base.model.BaseModel;
import com.zh.web.model.bean.ProcessBean;

public class ProcessModel extends BaseModel {

	private ProcessBean processBean = new ProcessBean();
	
	private List<ProcessBean> processBeanList = new ArrayList<ProcessBean>();

	public ProcessBean getProcessBean() {
		return processBean;
	}

	public void setProcessBean(ProcessBean processBean) {
		this.processBean = processBean;
	}

	public List<ProcessBean> getProcessBeanList() {
		return processBeanList;
	}

	public void setProcessBeanList(List<ProcessBean> processBeanList) {
		this.processBeanList = processBeanList;
	}


	
}
