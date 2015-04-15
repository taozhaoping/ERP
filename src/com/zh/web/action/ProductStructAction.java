package com.zh.web.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;
import com.zh.core.model.Pager;
import com.zh.web.model.ProductStructModel;
import com.zh.web.model.bean.BomPrimary;
import com.zh.web.service.ProductStructService;

public class ProductStructAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3637616705310900755L;


	private static Logger LOGGER = LoggerFactory.getLogger(ProductStructAction.class); 

	
	private ProductStructModel productStructModel = new ProductStructModel();
	
	@Autowired
	private ProductStructService productStructureService;
	
	@Override
	public Object getModel() {
		return productStructModel;
	}

	@Override
	public String execute() throws Exception {
		LOGGER.debug("execute()");
		BomPrimary bomPrimary = this.productStructModel.getBomPrimary();
		Integer count = productStructureService.countPrimary(bomPrimary);
		Pager page = this.productStructModel.getPageInfo();
		page.setTotalRow(count);
		List<BomPrimary> bomPrimaryList = productStructureService.queryPrimaryList(bomPrimary, page);
		this.productStructModel.setBomPrimaryList(bomPrimaryList);
		return Action.SUCCESS;

	}

	public String editor() throws Exception {
		LOGGER.debug("editor()");
		//Integer id = this.productStructModel.getId();
		
		/*if (null != id)
		{
			//查询信息
			LOGGER.debug("editor ProductStructure id " + id );
			BOMPrimary productStructure = this.productStructModel.getProductStructure();
			productStructure.setId(Integer.valueOf(id));
			BOMPrimary reult = productStructureService.query(productStructure);
			this.productStructModel.setProductStructure(reult);
			
		}*/
		
		return Action.EDITOR;
	}

	public String save() throws Exception {
		LOGGER.debug("save()");
		BomPrimary bomPrimary = this.productStructModel.getBomPrimary();
		Integer id = bomPrimary.getId();
		if (null != id && !"".equals(id)){
			bomPrimary.setId(id);
			productStructureService.updatePrimary (bomPrimary);
			LOGGER.debug("update productStructure id" + id);
		}else{
			//新增
			productStructureService.insertPrimary(bomPrimary);
			LOGGER.debug("add productStructure");
		}
		return Action.EDITOR_SUCCESS;
	}

}
