package com.zh.base.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.base.model.EnterpriseModel;
import com.zh.base.model.bean.Enterprise;
import com.zh.base.service.EnterpriseService;
import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;
import com.zh.core.model.Pager;

public class EnterpriseAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(EnterpriseAction.class); 
	
	private EnterpriseModel enterpriseModel = new EnterpriseModel();
	
	@Autowired
	private EnterpriseService enterpriseService;

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return enterpriseModel;
	}
	
	/**
	 * 企业管理入口
	 */
	public String execute()	{
		LOGGER.debug("execute()");
		Enterprise enterprise = this.enterpriseModel.getEnterprise();
		Pager pager = this.enterpriseModel.getPageInfo();
		Integer count = enterpriseService.count(enterprise);
		pager.setTotalRow(count);
		List<Enterprise> List = enterpriseService.queryList(enterprise,pager);
		this.enterpriseModel.setEnterpriseList(List);
		return Action.SUCCESS;
	}
	
	public String editor(){
		LOGGER.debug("editor()");
		Integer id = this.enterpriseModel.getId();
		if(null != id && !"".equals(id))
		{
			Enterprise enterprise = this.enterpriseModel.getEnterprise();
			enterprise.setId(id);
			Enterprise enterpriseReult = enterpriseService.query(enterprise);
			this.enterpriseModel.setEnterprise(enterpriseReult);
		}
		return Action.EDITOR;
	}
	
	public String save(){
		LOGGER.debug("save()");
		Enterprise enterprise = this.enterpriseModel.getEnterprise();
		
		//判断当前是设置成启动状态还是停用状态
		String view = this.enterpriseModel.getView();
		if(null != view && "enabled".equals(view))
		{
			String enabled = this.enterpriseModel.getEnabled();
			Integer id = this.enterpriseModel.getId();
			if("0".equals(enabled))
			{
				enterprise.setEnabled("1");
			}else
			{
				enterprise.setEnabled("0");
			}
			enterprise.setId(id);
		}
		
		//判断是新增还是修改
		Integer id = enterprise.getId();
		if(null == id || 0 == id)
		{
			enterpriseService.insert(enterprise);
		}else
		{
			enterpriseService.update(enterprise);
		}
		return Action.EDITOR_SUCCESS;
	}

}
