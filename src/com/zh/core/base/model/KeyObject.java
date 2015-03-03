package com.zh.core.base.model;

import com.zh.core.model.IDataObject;

public class KeyObject extends IDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4827339282617825104L;

	private Integer id;
	
	private String text;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
