package com.zh.base.dao;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import com.zh.base.model.bean.User;
import com.zh.core.base.dao.BaseDao;

@Component("userInfoDAO")
public class UserInfoDAO extends BaseDao<User> {
	
	@Override
	@PostConstruct
	public void init() {
		// TODO Auto-generated method stub
		this.setNamespace("AM_User");
	}

}
