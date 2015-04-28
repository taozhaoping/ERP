package com.zh.web.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.base.model.bean.Dictionary;
import com.zh.base.model.bean.Warehouse;
import com.zh.base.service.BasiTypeService;
import com.zh.base.util.DateUtil;
import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;
import com.zh.core.model.Pager;
import com.zh.web.model.CuttingSchemeModel;
import com.zh.web.model.bean.Customer;
import com.zh.web.model.bean.CuttingScheme;
import com.zh.web.model.bean.StorageDetail;
import com.zh.web.model.bean.StoragePrimary;
import com.zh.web.service.CuttingSchemeService;
import com.zh.web.util.UtilService;

public class CuttingSchemeAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 731437174900014739L;

	private static Logger LOGGER = LoggerFactory
			.getLogger(CuttingSchemeAction.class);

	@Autowired
	private CuttingSchemeService cuttingSchemeService;
	

	private CuttingSchemeModel cuttingSchemeModel = new CuttingSchemeModel();

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return cuttingSchemeModel;
	}

	@Override
	public String execute() throws Exception {
		CuttingScheme cuttingScheme = this.cuttingSchemeModel
				.getCuttingScheme();
		Integer count = cuttingSchemeService.count(cuttingScheme);
		Pager page = this.cuttingSchemeModel.getPageInfo();
		page.setTotalRow(count);
		List<CuttingScheme> cuttingSchemeList = cuttingSchemeService
				.queryList(cuttingScheme, page);
		this.cuttingSchemeModel.setCuttingSchemeList(cuttingSchemeList);
		return Action.SUCCESS;
	}

	public String editor() throws Exception {
		LOGGER.debug("editor()");
		Integer id = this.cuttingSchemeModel.getId();
		
		if (null != id) {
			// 查询信息
			LOGGER.debug("editor StoragePrimary id " + id);
			CuttingScheme cuttingScheme = this.cuttingSchemeModel
					.getCuttingScheme();
			cuttingScheme.setId(Integer.valueOf(id));
			CuttingScheme reult = cuttingSchemeService.query(cuttingScheme);
			this.cuttingSchemeModel.setCuttingScheme(reult);

			// 判断是否已经入库，入库状态下，只进入查看页面
			String view = this.cuttingSchemeModel.getView();
			if ("view".equals(view)) {
				return Action.VIEW;
			}
		}
		return Action.EDITOR;
	}

	public String save() throws Exception {
		LOGGER.debug("save()");
		CuttingScheme cuttingScheme = this.cuttingSchemeModel
				.getCuttingScheme();
		Integer id = this.cuttingSchemeModel.getId();
		if (null != id && !"".equals(id)) {
			cuttingScheme.setId(id);
			cuttingSchemeService.update(cuttingScheme);
			LOGGER.debug("update storagePrimary id" + id);
		} else {
			// 新增
			cuttingSchemeService.insert(cuttingScheme);
			LOGGER.debug("add storagePrimary");
		}
		this.cuttingSchemeModel.setFormId(cuttingScheme.getId().toString());
		return Action.EDITOR_SAVE;
	}
}
