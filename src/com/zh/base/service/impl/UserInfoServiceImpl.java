package com.zh.base.service.impl;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.UserQuery;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.base.dao.UserInfoDAO;
import com.zh.base.dao.UserNameDao;
import com.zh.base.model.bean.User;
import com.zh.base.service.UserInfoService;
import com.zh.core.base.model.KeyObject;
import com.zh.core.model.Pager;
import com.zh.core.util.JSONUtil;

@Component("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	
	//日志
	private static Logger LOGGER = LoggerFactory.getLogger(UserInfoServiceImpl.class);
	
	@Autowired
	private UserInfoDAO userInfoDAO;
	
	@Autowired
	private UserNameDao userNameDao;
	
	//@Autowired
	//private IdentityService identityService;

	@Override
	public User query(User user) {
		LOGGER.debug("query(User user)");
		return userInfoDAO.query(user);
	}

	@Override
	public void update(User user) {
		LOGGER.debug("update(User user)");
		userInfoDAO.update(user);
		//同步更新用户
		User updateUser = userInfoDAO.query(user);
		String userId = updateUser.getLoginName();
		//查询activiti user
		//UserQuery userQuery = identityService.createUserQuery();
		//List<org.activiti.engine.identity.User> activitiUsers = userQuery.userId(userId).list();
		
		//查询到一个用户
		/*if (activitiUsers.size() == 1) {
			LOGGER.debug("sync update activiti user update");
			org.activiti.engine.identity.User activitiUser = activitiUsers.get(0);
			cloneAndSaveActivitiUser(user, activitiUser);
		    identityService.saveUser(activitiUser);
		    
		} else if (activitiUsers.size() > 1) {//查询到多个用户
		    String errorMsg = "发现重复用户：id=" + userId;
		    LOGGER.error(errorMsg);
		    throw new RuntimeException(errorMsg);
		    
		} else {//没有查询到用户
			LOGGER.debug("sync update activiti user add");
			org.activiti.engine.identity.User activitiUser = identityService.newUser(userId);
			cloneAndSaveActivitiUser(user, activitiUser);
		}
		*/
	}

	@Override
	public List<User> queryList(User user) {
		LOGGER.debug("queryList(User user)");
		return userInfoDAO.queryList(user);
	}

	@Override
	public List<User> queryList(User user, Pager page) {
		LOGGER.debug("queryList(User user, Pager page)");
		return userInfoDAO.queryPageList(user, page);
	}

	@Override
	public Integer count(User user) {
		LOGGER.debug("count(User user)");
		return userInfoDAO.count(user);
	}

	@Override
	public void delete(User user) {
		LOGGER.debug("delete(User user)");
		userInfoDAO.delete(user);
		//同步删除用户
		Integer userId = user.getId();
		//identityService.deleteUser(userId.toString());
		LOGGER.debug("sync delete activiti user");
	}

	@Override
	public void insert(User user) {
		LOGGER.debug("insert(User user)");
		user.setEnabled("0");
		userInfoDAO.insert(user);
		//同步用户到工作流用户
		//org.activiti.engine.identity.User activitiUser = identityService.newUser(user.getLoginName().toString());
		//cloneAndSaveActivitiUser(user, activitiUser);
        //LOGGER.debug("sync add activiti user");
	}
	
	
    /**
     * 使用系统用户对象属性设置到Activiti User对象中
     * @param user          系统用户对象
     * @param activitiUser  Activiti User
     */
    private void cloneAndSaveActivitiUser(User user, org.activiti.engine.identity.User activitiUser) {
    	String userName = user.getName();
    	String email = user.getEmail();
    	if(null != userName && !userName.isEmpty() && null != email && !email.isEmpty()){
    		activitiUser.setFirstName(userName);
    		activitiUser.setLastName(StringUtils.EMPTY);
    		activitiUser.setPassword(StringUtils.EMPTY);
    		activitiUser.setEmail(email);
    		//保存activiti 用户
    		//identityService.saveUser(activitiUser);
    	}
    }

	@Override
	public String queryListJson() {
		// TODO Auto-generated method stub
		List<KeyObject> list = userNameDao.queryUserName();
		String str = JSONUtil.list2json(list);
		return str;
	}

	public UserInfoDAO getUserInfoDAO() {
		return userInfoDAO;
	}

	public void setUserInfoDAO(UserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}

	public UserNameDao getUserNameDao() {
		return userNameDao;
	}

	public void setUserNameDao(UserNameDao userNameDao) {
		this.userNameDao = userNameDao;
	}

}
