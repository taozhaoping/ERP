package com.zh.base.model;

import com.zh.base.model.bean.Param;
import com.zh.core.base.model.BaseModel;

public class ParamModel extends BaseModel {

	private Param sysParam =  new Param();

	public Param getSysParam() {
		return sysParam;
	}

	public void setSysParam(Param sysParam) {
		this.sysParam = sysParam;
	}

}
