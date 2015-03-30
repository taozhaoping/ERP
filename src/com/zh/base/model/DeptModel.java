package com.zh.base.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.base.model.bean.Dept;
import com.zh.core.base.model.BaseModel;

public class DeptModel extends BaseModel {

	private Dept dept = new Dept();
	
	private List<Dept> deptList = new ArrayList<Dept>();

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public List<Dept> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Dept> deptList) {
		this.deptList = deptList;
	}

	
}
