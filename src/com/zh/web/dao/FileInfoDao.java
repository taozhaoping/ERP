package com.zh.web.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.FileInfo;

@Component("fileInfoDao")
public class FileInfoDao extends BaseDao<FileInfo> {

	@Override
	@PostConstruct
	public void init() {
		this.setNamespace("M_FileInfo");
	}

}
