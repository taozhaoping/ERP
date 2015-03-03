/**
 * Copyright 2005-2009 Flouny.Caesar.com
 * All rights reserved.
 * 
 * @project
 * @author Flouny.Caesar
 * @version 1.0
 * @data 2009-12-25
 */
package com.zh.core.model;

import org.apache.ibatis.session.RowBounds;

public class Pager {

	/**
	 * 当前页
	 */
	private int curPage = 1; 
	
	/**
	 * 每页多少行
	 */
	private int pageSize = 10;
	
	/**
	 * 共多少行
	 */
	private int totalRow;
	
	/**
	 * 当前页起始行
	 */
	private int start;
	
	/**
	 * 结束行
	 */
	private int end;
	
	/**
	 * 共多少页
	 */
	private int totalPage;

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		if (curPage < 1) {
			curPage = 1;
		} else {
			start = pageSize * (curPage - 1);
		}
		end = start + pageSize > totalRow ? totalRow : start + pageSize;
		this.curPage = curPage;
	}

	public int getStart() {
		// start=curPage*pageSize;
		return start;
	}

	public int getEnd() {

		return end;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		if (totalRow == 0)
		{
			totalPage = 1;
		}else
		{
			totalPage = (totalRow + pageSize - 1) / pageSize ;
		}
		this.totalRow = totalRow;
		if (totalPage < curPage) {
			curPage = totalPage;
			start = pageSize * (curPage - 1);
			end = totalRow;
		}
		end = start + pageSize > totalRow ? totalRow : start + pageSize;
	}

	public int getTotalPage() {

		return this.totalPage;
	}
	
	public RowBounds getRowBounds()
	{
		return  new RowBounds(start,pageSize);
	}
}
