package com.zh.base.model.bean;

import com.zh.core.model.IDataObject;

/**
 * 
* @Title: Dictionary.java 
* @Package com.zh.base.model.bean 
* @Description: 数据库字典
* @date 2015年3月25日 下午3:30:04 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class Dictionary extends IDataObject {

	private Integer key;
	
	private String descr;
	
	private Integer basiTypeID;

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Integer getBasiTypeID() {
		return basiTypeID;
	}

	public void setBasiTypeID(Integer basiTypeID) {
		this.basiTypeID = basiTypeID;
	}
	
	
}
