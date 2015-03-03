package com.zh.base.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.base.model.ParamModel;
import com.zh.base.model.bean.Param;
import com.zh.base.service.ParamService;
import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;

public class ParamAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ParamService paramService;

	private ParamModel paramModel = new ParamModel();
	
	private static Logger LOGGER = LoggerFactory.getLogger(ParamAction.class); 
	
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return paramModel;
	}
	
	public String execute() {
		LOGGER.debug("execute()");
		Param param = paramService.query();
		paramModel.setSysParam(param);
		return Action.SUCCESS;
	}
	
	public String save(){
		LOGGER.debug("save()");
		Param param = this.paramModel.getSysParam();
		
		//系统配置表只有一条主建为1的数据
		param.setId(1);
		paramService.update(param);
		return Action.EDITOR;
	}

	public ParamService getParamService() {
		return paramService;
	}

	public void setParamService(ParamService paramService) {
		this.paramService = paramService;
	}

	public ParamModel getParamModel() {
		return paramModel;
	}

	public void setParamModel(ParamModel paramModel) {
		this.paramModel = paramModel;
	}

}
