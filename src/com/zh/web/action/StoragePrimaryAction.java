package com.zh.web.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;
import com.zh.core.model.Pager;
import com.zh.web.model.StoragePrimaryModel;
import com.zh.web.model.bean.StoragePrimary;
import com.zh.web.service.StoragePrimaryService;

public class StoragePrimaryAction extends BaseAction {
	
	private static Logger LOGGER = LoggerFactory.getLogger(StoragePrimaryAction.class); 

	@Autowired
	private StoragePrimaryService storagePrimaryService;
	
	private StoragePrimaryModel storagePrimaryModel = new StoragePrimaryModel();
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return storagePrimaryModel;
	}

	@Override
	public String execute() throws Exception {
		StoragePrimary storagePrimary = this.storagePrimaryModel.getStoragePrimary();
		Integer count = storagePrimaryService.count(storagePrimary);
		Pager page = this.storagePrimaryModel.getPageInfo();
		page.setTotalRow(count);
		List<StoragePrimary> storagePrimaryList = storagePrimaryService.queryList(storagePrimary, page);
		this.storagePrimaryModel.setStoragePrimaryList(storagePrimaryList);
		return Action.SUCCESS;
	}

	public String editor() throws Exception {
		LOGGER.debug("editor()");
		Integer id = this.storagePrimaryModel.getId();
		
		if (null != id)
		{
			//查询信息
			LOGGER.debug("editor StoragePrimary id " + id );
			StoragePrimary storagePrimary = this.storagePrimaryModel.getStoragePrimary();
			storagePrimary.setId(Integer.valueOf(id));
			StoragePrimary reult = storagePrimaryService.query(storagePrimary);
			this.storagePrimaryModel.setStoragePrimary(reult);
			
		}
		
		return Action.EDITOR;
	}

	public String save() throws Exception {
		LOGGER.debug("save()");
		StoragePrimary storagePrimary = this.storagePrimaryModel.getStoragePrimary();
		Integer id = this.storagePrimaryModel.getId();
		if (null != id && !"".equals(id))
		{
			storagePrimary.setId(id);
			storagePrimaryService.update(storagePrimary);
			LOGGER.debug("update storagePrimary id" + id);
		}else
		{
			//新增
			storagePrimaryService.insert(storagePrimary);
			LOGGER.debug("add storagePrimary");
		}
		return Action.EDITOR_SUCCESS;
	}
}
