package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.base.util.DateUtil;
import com.zh.core.model.Pager;
import com.zh.web.dao.FileInfoDao;
import com.zh.web.model.bean.FileInfo;
import com.zh.web.service.FileInfoService;

@Component("fileInfoService")
public class FileInfoServiceImpl implements FileInfoService {

	@Autowired
	private FileInfoDao fileInfoDao;
	
	@Override
	public FileInfo query(FileInfo fileInfo) {
		// TODO Auto-generated method stub
		return fileInfoDao.query(fileInfo);
	}

	@Override
	public void update(FileInfo fileInfo) {
		String update = DateUtil.getCreated();
		fileInfo.setUpdatedate(update);
		fileInfoDao.update(fileInfo);
	}

	@Override
	public List<FileInfo> queryList(FileInfo fileInfo) {
		// TODO Auto-generated method stub
		return fileInfoDao.queryList(fileInfo);
	}

	@Override
	public List<FileInfo> queryList(FileInfo fileInfo, Pager page) {
		// TODO Auto-generated method stub
		return fileInfoDao.queryPageList(fileInfo, page);
	}

	@Override
	public Integer count(FileInfo fileInfo) {
		// TODO Auto-generated method stub
		return fileInfoDao.count(fileInfo);
	}

	@Override
	public void delete(FileInfo fileInfo) {
		// TODO Auto-generated method stub
		fileInfoDao.delete(fileInfo);
	}

	@Override
	public void insert(FileInfo fileInfo) {
		// TODO Auto-generated method stub
		String createdate = DateUtil.getCreated();
		fileInfo.setCreatedate(createdate);
		fileInfoDao.insert(fileInfo);
	}

	public FileInfoDao getFileInfoDao() {
		return fileInfoDao;
	}

	public void setFileInfoDao(FileInfoDao fileInfoDao) {
		this.fileInfoDao = fileInfoDao;
	}

}
