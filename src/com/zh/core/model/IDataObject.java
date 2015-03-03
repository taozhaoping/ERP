package com.zh.core.model;

import java.io.Serializable;

/**
 * 数据对象接口
 * @author Flouny.Caesar
 *
 */
public abstract class IDataObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4051045946051357056L;
	private String orderByClause;

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}
}