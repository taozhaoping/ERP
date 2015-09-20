package com.zh.web.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;
import com.zh.core.model.Pager;
import com.zh.web.model.ProcessModel;
import com.zh.web.model.bean.ProcessBean;
import com.zh.web.service.ProcessService;

/**
* @Description: 工序管理
* @Title: ProcessAction.java 
* @Package com.zh.web.action 
* @date 2015年7月22日 下午7:21:41 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class ProcessAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ProcessModel processModel = new ProcessModel();
	
	@Autowired
	private ProcessService processService;
	
	private static Logger LOGGER = LoggerFactory
			.getLogger(ProcessAction.class);
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return processModel;
	}

	@Override
	public String execute() throws Exception {
		ProcessBean processBean = this.processModel.getProcessBean();
		Integer count = processService.count(processBean);
		Pager page = this.processModel.getPageInfo();
		page.setTotalRow(count);
		List<ProcessBean> processBeanList = processService
				.queryList(processBean, page);
		this.processModel.setProcessBeanList(processBeanList);
		return Action.SUCCESS;
	}

	public String editor() throws Exception {
		LOGGER.debug("editor()");
		Long id = this.processModel.getId();

		if (null != id) {
			// 查询信息
			LOGGER.debug("editor StoragePrimary id " + id);
			ProcessBean processBean = this.processModel.getProcessBean();
			processBean.setId(Long.valueOf(id));
			ProcessBean reult = processService.query(processBean);
			this.processModel.setProcessBean(reult);


			String view = this.processModel.getView();
			if ("view".equals(view)) {
				return Action.VIEW;
			}
		}
		return Action.EDITOR;
	}


	public String save() throws Exception {
		LOGGER.debug("save()");
		ProcessBean processBean = this.processModel.getProcessBean();
		Long id = this.processModel.getId();
		if (null != id && !"".equals(id)) {
			processBean.setId(id);
			processService.update(processBean);
			LOGGER.debug("update storagePrimary id" + id);
		} else {
			// 新增
			processService.insert(processBean);
			LOGGER.debug("add storagePrimary");
		}
		this.processModel.setFormId(processBean.getId().toString());
		return Action.EDITOR_SUCCESS;
	}

}
