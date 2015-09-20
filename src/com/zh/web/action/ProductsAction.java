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
import com.zh.web.model.ProductsModel;
import com.zh.web.model.bean.BomDetail;
import com.zh.web.model.bean.BomPrimary;
import com.zh.web.model.bean.BomSub;
import com.zh.web.model.bean.ProductProcess;
import com.zh.web.model.bean.Products;
import com.zh.web.service.ProductProcessService;
import com.zh.web.service.ProductStructService;
import com.zh.web.service.ProductsService;

/**
* @Description: 产品资料
* @Title: ProductsAction.java 
* @Package com.zh.web.action 
* @date 2015年7月7日 下午7:07:32 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class ProductsAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7837876428251372000L;

	private static Logger LOGGER = LoggerFactory.getLogger(ProductsAction.class); 

	private ProductsModel productsModel = new ProductsModel();
	
	@Autowired
	private ProductsService productsService;
	
	@Autowired
	private ProductStructService productStructService;
	
	@Autowired
	private ProductProcessService productProcessService;
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return productsModel;
	}

	@Override
	public String execute() throws Exception {
		Products products = this.productsModel.getProducts();
		Integer count = productsService.count(products);
		Pager page = this.productsModel.getPageInfo();
		page.setTotalRow(count);
		List<Products> list = productsService.queryList(products, page);
		this.productsModel.setProductsList(list);
		
		List<Dictionary> productTypeList = queryDictionaryList(BasiTypeService.PRODUCT_TYPE);
		Dictionary dict = new Dictionary();
		dict.setKey(0);
		dict.setDescr("请选择");
		productTypeList.add(0, dict);
		this.productsModel.setProductTypeList(productTypeList);
		
		return Action.SUCCESS;

	}

	public String editor() throws Exception {
		LOGGER.debug("editor()");
		Long id = this.productsModel.getId();
		
		//产品来源
		List<Dictionary> sourceTypeList = queryDictionaryList(BasiTypeService.SOURCE_TYPE);
		this.productsModel.setSourceTypeList(sourceTypeList);
		
		//产品来源
		List<Dictionary> productTypeList = queryDictionaryList(BasiTypeService.PRODUCT_TYPE);
		this.productsModel.setProductTypeList(productTypeList);
		
		//计量等级
		List<Dictionary> list = queryDictionaryList(BasiTypeService.MEASUREMENT_COMPANYSOURCE_TYPE);
		this.productsModel.setDictionaryList(list);
		
		//颜色
		List<Dictionary> paintList = queryDictionaryList(BasiTypeService.PAINT_COLR);
		this.productsModel.setPaintList(paintList);
		if (null != id){
			//查询信息
			LOGGER.debug("editor Products id " + id );
			Products products = this.productsModel.getProducts();
			products.setId(Long.valueOf(id));
			Products reult = productsService.query(products);
			this.productsModel.setProducts(reult);
			
			BomPrimary bomPrimary = new BomPrimary();
			bomPrimary.setProductsId(id);
			bomPrimary = productStructService.queryReleasePrimary(bomPrimary);
			if(null != bomPrimary && null != bomPrimary.getId()){
				//结构头表id
				Long primaryId = bomPrimary.getId();
				
				//产品结构明细
				BomDetail bomDetail = this.productsModel.getBomDetail();
				bomDetail.setPrimaryId(primaryId);
				LOGGER.debug("bomDetail: {}", bomDetail);
				List<BomDetail> bomDetailList = productStructService.queryDetailList(bomDetail);
				for(BomDetail bd : bomDetailList){
					Long productId = bd.getSubProductsId();
					Products ps = new Products();
					ps.setId(productId);
					ps = productsService.query(ps);
					bd.setSubProductsName(ps.getName());
				}
				this.productsModel.setBomDetailList(bomDetailList);
				
				//替代料列表
				BomSub bomSub = this.productsModel.getBomSub();
				bomSub.setPrimaryId(primaryId);
				LOGGER.debug("bomSub: {}", bomSub);
				List<BomSub> bomSubList = productStructService.querySubList(bomSub);
				for(BomSub bs : bomSubList){
					Long productId = bs.getSubProductsId();
					Products ps = new Products();
					ps.setId(productId);
					ps = productsService.query(ps);
					bs.setSubProductsName(ps.getName());
				}
				this.productsModel.setBomSubList(bomSubList);
				
				//工序列表
				ProductProcess productProcess = this.productsModel.getProductProcess();
				productProcess.setBomPrimaryID(primaryId);
				LOGGER.debug("ProductProcess: {}", bomSub);
				List<ProductProcess> productProcessList = productProcessService.queryList(productProcess);
				this.productsModel.setProductProcessList(productProcessList);
			}
		}
		
		return Action.EDITOR;
	}

	public String save() throws Exception {
		LOGGER.debug("save()");
		Products products = this.productsModel.getProducts();
		Long id = this.productsModel.getId();
		if (null != id && !"".equals(id))
		{
			products.setId(id);
			productsService.update(products);
			LOGGER.debug("update products id" + id);
		}else
		{
			//新增
			productsService.insert(products);
			LOGGER.debug("add products");
		}
		return Action.EDITOR_SUCCESS;
	}

	
}
