package com.zh.web.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.core.base.model.BaseModel;
import com.zh.web.model.bean.CuttingScheme;

public class CuttingSchemeModel extends BaseModel {

	private CuttingScheme cuttingScheme = new CuttingScheme();
	
	private List<CuttingScheme> cuttingSchemeList = new ArrayList<CuttingScheme>();

	public CuttingScheme getCuttingScheme() {
		return cuttingScheme;
	}

	public void setCuttingScheme(CuttingScheme cuttingScheme) {
		this.cuttingScheme = cuttingScheme;
	}

	public List<CuttingScheme> getCuttingSchemeList() {
		return cuttingSchemeList;
	}

	public void setCuttingSchemeList(List<CuttingScheme> cuttingSchemeList) {
		this.cuttingSchemeList = cuttingSchemeList;
	}
			
	
}
