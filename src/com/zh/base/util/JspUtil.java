package com.zh.base.util;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.zh.base.model.bean.BasiType;
import com.zh.base.model.bean.Dictionary;
import com.zh.base.model.bean.Enterprise;
import com.zh.base.model.bean.User;
import com.zh.base.model.bean.Warehouse;
import com.zh.base.service.BasiTypeService;
import com.zh.base.service.DictionaryService;
import com.zh.base.service.EnterpriseService;
import com.zh.base.service.UserInfoService;
import com.zh.base.service.WarehouseService;
import com.zh.web.model.bean.Customer;
import com.zh.web.service.CustomerService;

public class JspUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext; // Spring应用上下文环境

	private static UserInfoService userInfoService;

	private static BasiTypeService basiTypeService;

	private static DictionaryService dictionaryService;

	private static EnterpriseService enterpriseService;
	
	private static CustomerService customerService;
	
	private static WarehouseService  warehouseService;

	/**
	 * 实现ApplicationContextAware接口的回调方法，设置上下文环境
	 * 
	 * @param applicationContext
	 * @throws BeansException
	 */
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		JspUtil.applicationContext = applicationContext;
	}

	/**
	 * @return ApplicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 获取对象
	 * 
	 * @param name
	 * @return Object 一个以所给名字注册的bean的实例
	 * @throws BeansException
	 */
	public synchronized static void getBean() throws BeansException {
		if (null == userInfoService) {
			userInfoService = (UserInfoService) applicationContext
					.getBean("userInfoService");
		}

		if (null == basiTypeService) {
			basiTypeService = (BasiTypeService) applicationContext
					.getBean("basiTypeService");
		}

		if (null == dictionaryService) {
			dictionaryService = (DictionaryService) applicationContext
					.getBean("dictionaryService");
		}

		if (null == enterpriseService) {
			enterpriseService = (EnterpriseService) applicationContext
					.getBean("enterpriseService");
		}
		
		if (null == customerService) {
			customerService = (CustomerService) applicationContext
					.getBean("customerService");
		}
		
		if (null == warehouseService) {
			warehouseService = (WarehouseService) applicationContext
					.getBean("warehouseService");
		}
	}

	public static String queryUserName(String id) {

		if (null == id || "null".equals(id)) {
			return "";
		}
		User user = new User();
		user.setId(Integer.valueOf(id));
		User reult = userInfoService.query(user);
		return reult.getName();
	}

	/**
	 * @Title: queryBasiType
	 * @Description: 查询基础类型资料
	 * @param @param id
	 * @param @return 参数
	 * @return String 返回类型
	 * @throws
	 * @author taozhaoping 26078
	 * @author mail taozhaoping@gmail.com
	 */
	public static String queryBasiType(String id) {
		if (null == id || "null".equals(id)) {
			return "";
		}

		BasiType basiType = new BasiType();
		basiType.setId(Integer.valueOf(id));
		BasiType reult = basiTypeService.query(basiType);
		if (reult == null) {
			return "";
		} else {
			return reult.getName();
		}
	}

	/**
	 * 
	 * @Title: queryDictionary
	 * @Description: 查询数据库字典
	 * @param @param id
	 * @param @return 参数
	 * @return String 返回类型
	 * @throws
	 * @author taozhaoping 26078
	 * @author mail taozhaoping@gmail.com
	 */
	public static String queryDictionary(String id) {
		if (null == id || "null".equals(id)) {
			return "";
		}

		Dictionary dictionary = new Dictionary();
		dictionary.setKey(Integer.valueOf(id));
		Dictionary reult = dictionaryService.query(dictionary);
		if (reult == null) {
			return "";
		} else {
			return reult.getDescr();
		}
	}
	
	/**
	 * 
	* @Title: queryEnterpriseList 
	* @Description: 获取有效的企业列表 
	* @param  @return   参数 
	* @return List<Enterprise>    返回类型 
	* @throws 
	* @author taozhaoping 26078
	* @author mail taozhaoping@gmail.com
	 */
	public static List<Enterprise> queryEnterpriseList() {

		Enterprise enterprise = new Enterprise();
		enterprise.setEnabled("0");
		List<Enterprise> reult = enterpriseService.queryList(enterprise);

		return reult;
	}

	/**
	 * 获取企业名称
	* @Title: queryEnterprise 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param  @param id
	* @param  @return   参数 
	* @return String    返回类型 
	* @throws 
	* @author taozhaoping 26078
	* @author mail taozhaoping@gmail.com
	 */
	public static String queryEnterprise(String id) {
		if (null == id || "null".equals(id)) {
			return "";
		}

		Enterprise enterprise = new Enterprise();
		enterprise.setId(Integer.valueOf(id));
		Enterprise reult = enterpriseService.query(enterprise);
		if (reult == null) {
			return "";
		} else {
			return reult.getName();
		}
	}
	
	/**
	* @Title: queryCustomer 
	* @Description: 获取客户名称
	* @param  @param id
	* @param  @return   参数 
	* @return String    返回类型 
	* @throws 
	* @author taozhaoping 26078
	* @author mail taozhaoping@gmail.com
	 */
	public static String queryCustomer(String id) {
		if (null == id || "null".equals(id)) {
			return "";
		}

		Customer customer = new Customer();
		customer.setId(Integer.valueOf(id));
		Customer reult = customerService.query(customer);
		if (reult == null) {
			return "";
		} else {
			return reult.getName();
		}
	}
	
	/**
	 * 
	* @Title: queryWarehouse 
	* @Description: 获取仓库名称
	* @param  @param id
	* @param  @return   参数 
	* @return String    返回类型 
	* @throws 
	* @author taozhaoping 26078
	* @author mail taozhaoping@gmail.com
	 */
	public static String queryWarehouse(String id) {
		if (null == id || "null".equals(id)) {
			return "";
		}

		Warehouse warehouse = new Warehouse();
		warehouse.setId(Integer.valueOf(id));
		Warehouse reult = warehouseService.query(warehouse);
		if (reult == null) {
			return "";
		} else {
			return reult.getName();
		}
	}
}
