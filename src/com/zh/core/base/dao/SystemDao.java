package com.zh.core.base.dao;

import org.springframework.stereotype.Component;

import com.zh.core.base.model.SystemInfo;


@Component("systemDao")
public class SystemDao extends BaseDao<SystemInfo> {

	public void init()
	{
		this.setNamespace("systemInfo");
	}
	
	public String querySystem()
	{
		SystemInfo systemInfo = new SystemInfo();
		systemInfo.setId(1);
		systemInfo.setKeyName("SystemKey");
		SystemInfo sys = (SystemInfo)super.query(systemInfo);
		return sys.getKeyValue();
		
	}
}
