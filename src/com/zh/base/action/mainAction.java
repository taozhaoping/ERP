package com.zh.base.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.base.model.MainModel;
import com.zh.base.model.bean.Menu;
import com.zh.base.model.bean.Notice;
import com.zh.base.model.bean.Role;
import com.zh.base.model.bean.User;
import com.zh.base.realm.UserRealm;
import com.zh.base.service.NoticeService;
import com.zh.base.service.RoleService;
import com.zh.base.service.UserInfoService;
import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;
import com.zh.core.exception.ProjectException;
import com.zh.core.model.Pager;
import com.zh.core.model.VariableUtil;
import com.zh.core.util.BCrypt;
import com.zh.core.util.JSONUtil;

public class mainAction extends BaseAction {

	private MainModel mainModel;
	
	private static Logger LOGGER = LoggerFactory.getLogger(mainAction.class); 
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private NoticeService noticeService;

	//private String language;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() {
		LOGGER.debug("execute()");
//		//设置当前语言
//		//this.setLanguage(this.getLocale().toString());
		
		//获取当前登录用户信息
		User user = (User) this.getSession().getAttribute(VariableUtil.SESSION_KEY);
		
//		// 获取员工信息
//		mainService.initEmployeeInfo(mainModel);
//
//		// 获取公司信息
//		mainService.initEnterprise(mainModel);
//
		// 获取角色信息和菜单信息
		Role role = new Role();
		role.setId(Long.valueOf(user.getRoleId()));
		Role roleReult = roleService.queryAuthoritiesToMenu(role);
		this.mainModel.setRole(roleReult);
//		
		//保存用户menu菜单中的action权限到session，用于过滤器的验证
		setAuthoritySession();
//		
//		//保存用户信息到session
//		this.getSession().setAttribute(VariableUtil.EMPLOYEE, mainModel.getEmployee());
		//String userName = user.getLoginName();
		
		//系统公告
		Notice notice = new Notice();
		Pager page = this.getMainModel().getPageInfo();
		//Integer size = noticeService.count(notice);
		page.setPageSize(5);
		//page.setTotalRow(size);
		List<Notice> noticeList = noticeService.queryList(notice, page);
		this.getMainModel().setNoticeList(noticeList);
		
		return Action.SUCCESS;
	}
	
	public String queryPersonal() {
		User user = new User();
		User currUser = this.queryUser();
		if (null == currUser)
		{
			throw new ProjectException("当前未登录!");
		}
		Long id = currUser.getId();
		user.setId(id);
		User userReult = userInfoService.query(user);
		this.mainModel.setUser(userReult);
		return "personal";
	}

	public String save() {
		LOGGER.debug("save()");
		User currUser = this.queryUser();
		if (null == currUser)
		{
			throw new ProjectException("当前未登录!");
		}
		User user = this.mainModel.getUser();

		Long id = user.getId();
		if ( id == null || id.equals(0))
		{
			throw new ProjectException("当前修改的数据错误!");
		}
		
		
		if (currUser.getId() != user.getId())
		{
			throw new ProjectException("当前登录用户和修改的用户不匹配，无法修改!");
		}

		String passWord = mainModel.getNewPassWord();

		if (null != passWord && !"".equals(passWord)) {
			String bcryptPassword = BCrypt.hashpw(passWord, BCrypt.gensalt(12));
			user.setUserPassword(bcryptPassword);
		}
		userInfoService.update(user);
		//修改密码，清理缓存，重新认证
		if(null != passWord && !passWord.isEmpty()){
			Subject subject = SecurityUtils.getSubject();
			
			RealmSecurityManager securityManager =  (RealmSecurityManager) SecurityUtils.getSecurityManager();
			UserRealm userRealm = (UserRealm) securityManager.getRealms().iterator().next();
			userRealm.clearCachedAuthenticationInfo(subject.getPrincipals());
			userRealm.clearCachedAuthorizationInfo(subject.getPrincipals());
			
			String username = currUser.getLoginName();
			char[] loginPassword = passWord.toCharArray();
			UsernamePasswordToken token = new UsernamePasswordToken(username, loginPassword);
			subject.login(token);
		}
		return "save";
	}
	
	/**
	 * 查看系统公告
	 * @return
	 */
	public String queryNotice()
	{
		Long id = this.getMainModel().getId();
		if(null == id || "".equals(id.toString()))
		{
			return Action.SUCCESS;
		}
		Notice notice = new Notice();
		notice.setId(id);
		Notice reult = noticeService.query(notice);
		if(null ==reult)
		{
			return Action.SUCCESS;
		}
		this.getMainModel().setNotice(reult);
		return "notice";
	}
	
	public String initPwd() {
		LOGGER.debug("initPwd()");
		mainModel.setUser((User) this.getSession().getAttribute(
				VariableUtil.SESSION_KEY));
		mainModel.getUser().setUserPassword(null);
		mainModel.setReultObject(JSONUtil.bean2json(mainModel.getUser()));
		return "updatePwd";
	}
	
	public String updatepwd() {
		LOGGER.debug("updatepwd()");
		String password = mainModel.getNewPassWord();
		if(null == password)
		{
			throw new ProjectException("密码不允许为空");
		}
		User userInfo = new User();
		userInfo.setId(mainModel.getId());
		userInfo.setUserPassword(BCrypt.hashpw(password, BCrypt.gensalt(12)));
		userInfoService.update(userInfo);
		return Action.RETURN_JSON;
	}


	private void setAuthoritySession() {
		LOGGER.debug("setAuthoritySession()");
		ArrayList<String> list = new ArrayList<String>();
		Role role = mainModel.getRole();
		if(null != role){
			List<Menu> menuList = role.getMenuList();
			for (Menu menu : menuList) {
				Long parentid = menu.getParentid();
				if (parentid.equals(0)) {
					List<Menu> mList = menu.getMenuList();
					for (Menu menu2 : mList) {
						list.add(menu2.getAction());
					}
				}
				list.add(menu.getAction());
			}
		}
		this.getSession().setAttribute(VariableUtil.AUTHORITY, list);
	}
	
	public String rightExecute(){
		//mainModel.setEmployee((EmployeeInfo)this.getSession().getAttribute(VariableUtil.EMPLOYEE));

		return "right";
	}
	
	/**
	 * 获取配置参数中的属性
	 */
	@SuppressWarnings("unused")
	private void getSystem(){
		
	}

	public String updateExecute() {

		return "updatePassword";
	}

	public Object getModel() {
		if (null == mainModel) {
			mainModel = new MainModel();
		}
		return mainModel;
	}

	public MainModel getMainModel() {
		return mainModel;
	}

	public void setMainModel(MainModel mainModel) {
		this.mainModel = mainModel;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	@Override
	public String editor() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
