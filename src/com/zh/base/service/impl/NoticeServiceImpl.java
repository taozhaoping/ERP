package com.zh.base.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.base.dao.NoticeDao;
import com.zh.base.model.bean.Notice;
import com.zh.base.service.NoticeService;
import com.zh.core.model.Pager;
import com.zh.core.util.DateUtil;

@Component("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public Notice query(Notice notice) {
		// TODO Auto-generated method stub
		return noticeDao.query(notice);
	}

	@Override
	public void update(Notice notice) {
		// TODO Auto-generated method stub
		Date date = DateUtil.getNow();
		notice.setUpdatedate(date);
		noticeDao.update(notice);
	}

	@Override
	public List<Notice> queryList(Notice notice) {
		// TODO Auto-generated method stub
		notice.setOrderByClause("id DESC");
		return noticeDao.queryList(notice);
	}

	@Override
	public List<Notice> queryList(Notice notice, Pager page) {
		// TODO Auto-generated method stub
		notice.setOrderByClause("CREATEDATE DESC");
		return noticeDao.queryPageList(notice, page);
	}

	@Override
	public Integer count(Notice notice) {
		// TODO Auto-generated method stub
		return noticeDao.count(notice);
	}

	@Override
	public void delete(Notice notice) {
		// TODO Auto-generated method stub
		noticeDao.delete(notice);
	}

	@Override
	public void insert(Notice notice) {
		// TODO Auto-generated method stub
		//激活
		notice.setEnabled("0");
		Date date = DateUtil.getNow();
		notice.setCreatedate(date);
		notice.setUpdatedate(date);
		noticeDao.insert(notice);
	}

	public NoticeDao getNoticeDao() {
		return noticeDao;
	}

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

}
