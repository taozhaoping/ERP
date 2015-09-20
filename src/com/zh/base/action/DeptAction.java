package com.zh.base.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.base.model.DeptModel;
import com.zh.base.model.bean.Dept;
import com.zh.base.model.bean.Dictionary;
import com.zh.base.model.bean.Enterprise;
import com.zh.base.service.BasiTypeService;
import com.zh.base.service.DeptService;
import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;
import com.zh.core.model.Pager;

public class DeptAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger LOGGER = LoggerFactory.getLogger(DeptAction.class); 
	
	private DeptModel deptModel = new DeptModel();
	
	@Autowired
	private DeptService deptService;
	
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return deptModel;
	}
	
	@Override
	public String execute() throws Exception {
		Dept dept = this.deptModel.getDept();
		Integer count = deptService.count(dept);
		Pager page = this.deptModel.getPageInfo();
		page.setTotalRow(count);
		List<Dept> list = deptService.queryList(dept, page);
		this.deptModel.setDeptList(list);
		return Action.SUCCESS;

	}
	
	public DeptModel getDeptModel() {
		return deptModel;
	}
	
	public void setDeptModel(DeptModel deptModel) {
		this.deptModel = deptModel;
	}

	public DeptService getDeptService() {
		return deptService;
	}
	
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	public String editor() throws Exception {
		LOGGER.debug("editor()");
		Long id = this.deptModel.getId();
		//部门类型
		List<Dictionary> list = queryDictionaryList(BasiTypeService.DEPT_TYPE);
		this.deptModel.setDictionaryList(list);
		
		//获取企业列表
		List<Enterprise> enterpriseList = this.queryEnterpriseList();
		this.deptModel.setEnterpriseList(enterpriseList);
		
		if (null != id)
		{
			//查询信息
			LOGGER.debug("editor Dept id " + id );
			Dept dept = this.deptModel.getDept();
			dept.setId(Long.valueOf(id));
			Dept reult = deptService.query(dept);
			this.deptModel.setDept(reult);
		}
		
		return Action.EDITOR;
	}

	public String save() throws Exception {
		LOGGER.debug("save()");
		Dept dept = this.deptModel.getDept();
		Long id = this.deptModel.getId();
		if (null != id && !"".equals(id))
		{
			String view = this.deptModel.getView();
			if (null != view && "enabled".equals(view))
			{
				String enabled = this.deptModel.getEnabled();
				dept = new Dept();
				
				if ("0".equals(enabled))
				{
					dept.setEnabled(1);
				}else
				{
					dept.setEnabled(0);
				}
				LOGGER.debug("update dept enabled " + dept.getEnabled());
			}
			dept.setId(id);
			deptService.update(dept);
			LOGGER.debug("update dept id" + id);
		}else
		{
			//新增
			deptService.insert(dept);
			LOGGER.debug("add dept");
		}
		return Action.EDITOR_SUCCESS;
	}

}
