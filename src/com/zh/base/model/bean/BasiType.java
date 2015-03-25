package com.zh.base.model.bean;

import com.zh.core.model.IDataObject;

/**
 * 
* @Title: BasiType.java 
* @Package com.zh.base.model.bean 
* @Description: 基础类别资料
* @date 2015年3月25日 下午3:18:55 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class BasiType extends IDataObject {

	private Integer id;
	
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
