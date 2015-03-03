package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.model.Pager;
import com.zh.web.dao.MailListDao;
import com.zh.web.model.bean.MailList;
import com.zh.web.service.MailListService;

@Component("mailListService")
public class MailListServiceImpl implements MailListService {

	@Autowired
	private MailListDao mailListDao;
	
	@Override
	public MailList query(MailList mailList) {
		// TODO Auto-generated method stub
		return mailListDao.query(mailList);
	}

	@Override
	public void update(MailList mailList) {
		// TODO Auto-generated method stub
		mailListDao.update(mailList);
	}

	@Override
	public List<MailList> queryList(MailList mailList) {
		// TODO Auto-generated method stub
		return mailListDao.queryList(mailList);
	}

	@Override
	public List<MailList> queryList(MailList mailList, Pager page) {
		// TODO Auto-generated method stub
		return mailListDao.queryPageList(mailList, page);
	}

	@Override
	public Integer count(MailList mailList) {
		// TODO Auto-generated method stub
		return mailListDao.count(mailList);
	}

	@Override
	public void delete(MailList mailList) {
		// TODO Auto-generated method stub
		mailListDao.delete(mailList);
	}

	@Override
	public Integer insert(MailList mailList) {
		// TODO Auto-generated method stub
		return mailListDao.insert(mailList);
	}

	public MailListDao getMailListDao() {
		return mailListDao;
	}

	public void setMailListDao(MailListDao mailListDao) {
		this.mailListDao = mailListDao;
	}

}
