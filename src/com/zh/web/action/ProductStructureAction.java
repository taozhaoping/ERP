package com.zh.web.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.base.model.bean.Dictionary;
import com.zh.base.service.BasiTypeService;
import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;
import com.zh.core.model.Pager;
import com.zh.web.model.ProductStructureModel;
import com.zh.web.model.bean.ProductStructure;
import com.zh.web.service.ProductStructureService;

public class ProductStructureAction extends BaseAction {

	private static Logger LOGGER = LoggerFactory.getLogger(ProductStructureAction.class); 

	
	private ProductStructureModel productStructureModel = new ProductStructureModel();
	
	@Autowired
	private ProductStructureService productStructureService;
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return productStructureModel;
	}

	@Override
	public String execute() throws Exception {
		ProductStructure productStructure = this.productStructureModel.getProductStructure();
		Integer count = productStructureService.count(productStructure);
		Pager page = this.productStructureModel.getPageInfo();
		page.setTotalRow(count);
		List<ProductStructure> list = productStructureService.queryList(productStructure, page);
		this.productStructureModel.setProductStructureList(list);
		return Action.SUCCESS;

	}

	public String editor() throws Exception {
		LOGGER.debug("editor()");
		Integer id = this.productStructureModel.getId();
		
		if (null != id)
		{
			//查询信息
			LOGGER.debug("editor ProductStructure id " + id );
			ProductStructure productStructure = this.productStructureModel.getProductStructure();
			productStructure.setId(Integer.valueOf(id));
			ProductStructure reult = productStructureService.query(productStructure);
			this.productStructureModel.setProductStructure(reult);
			
		}
		
		return Action.EDITOR;
	}

	public String save() throws Exception {
		LOGGER.debug("save()");
		ProductStructure productStructure = this.productStructureModel.getProductStructure();
		Integer id = this.productStructureModel.getId();
		if (null != id && !"".equals(id))
		{
			productStructure.setId(id);
			productStructureService.update(productStructure);
			LOGGER.debug("update productStructure id" + id);
		}else
		{
			//新增
			productStructureService.insert(productStructure);
			LOGGER.debug("add productStructure");
		}
		return Action.EDITOR_SUCCESS;
	}

}
