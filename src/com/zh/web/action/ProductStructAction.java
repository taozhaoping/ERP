package com.zh.web.action;

import java.util.List;
import java.util.Map;

import org.apache.avalon.framework.parameters.ParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.base.util.ConstantService;
import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;
import com.zh.core.model.Pager;
import com.zh.core.util.JSONUtil;
import com.zh.web.model.ProductStructModel;
import com.zh.web.model.bean.BomDetail;
import com.zh.web.model.bean.BomPrimary;
import com.zh.web.model.bean.BomSub;
import com.zh.web.model.bean.ProcessBean;
import com.zh.web.model.bean.ProductProcess;
import com.zh.web.model.bean.Products;
import com.zh.web.service.ProcessService;
import com.zh.web.service.ProductProcessService;
import com.zh.web.service.ProductStructService;
import com.zh.web.service.ProductsService;

/**
* @Description: 产品结构
* @Title: ProductStructAction.java 
* @Package com.zh.web.action 
* @date 2015年7月7日 下午7:07:22 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class ProductStructAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3637616705310900755L;


	private static Logger LOGGER = LoggerFactory.getLogger(ProductStructAction.class); 

	
	private ProductStructModel productStructModel = new ProductStructModel();
	
	@Autowired
	private ProductStructService productStructService;
	
	@Autowired
	private ProductsService productsService;
	
	@Autowired
	private ProcessService processService;
	
	@Autowired
	private ProductProcessService productProcessService;
	
	@Override
	public Object getModel() {
		return productStructModel;
	}

	@Override
	public String execute() throws Exception {
		LOGGER.debug("execute()");
		BomPrimary bomPrimary = this.productStructModel.getBomPrimary();
		Integer count = productStructService.countPrimary(bomPrimary);
		Pager page = this.productStructModel.getPageInfo();
		page.setTotalRow(count);
		List<BomPrimary> bomPrimaryList = productStructService.queryPrimaryList(bomPrimary, page);
		for(BomPrimary bp : bomPrimaryList){
			Long productId = bp.getProductsId();
			Products products = new Products();
			products.setId(productId);
			products = productsService.query(products);
			bp.setProductsName(products.getName());
		}
		this.productStructModel.setBomPrimaryList(bomPrimaryList);
		return Action.SUCCESS;

	}

	/**
	 * 编辑获取
	 */
	public String editor() throws Exception {
		LOGGER.debug("editor()");
		Long id = this.productStructModel.getId();
		
		if (null != id){
			//查询信息
			LOGGER.debug("editor ProductStruct id " + id );
			BomPrimary bomPrimary = this.productStructModel.getBomPrimary();
			bomPrimary.setId(Long.valueOf(id));
			//查询结果
			BomPrimary result = productStructService.queryPrimary(bomPrimary);
			LOGGER.debug("query bomPrimary:{}", result);
			this.productStructModel.setBomPrimary(result);
		
			//产品结构
			BomDetail bomDetail = this.productStructModel.getBomDetail();
			bomDetail.setPrimaryId(id);
			LOGGER.debug("bomDetail: {}", bomDetail);
			List<BomDetail> bomDetailList = productStructService.queryDetailList(bomDetail);
			for(BomDetail bd : bomDetailList){
				Long productId = bd.getSubProductsId();
				Products products = new Products();
				products.setId(productId);
				products = productsService.query(products);
				bd.setSubProductsName(products.getName());
			}
			this.productStructModel.setBomDetailList(bomDetailList);
	
			//替代料列表
			BomSub bomSub = this.productStructModel.getBomSub();
			bomSub.setPrimaryId(id);
			LOGGER.debug("bomSub: {}", bomSub);
			List<BomSub> bomSubList = productStructService.querySubList(bomSub);
			for(BomSub bs : bomSubList){
				Long productId = bs.getSubProductsId();
				Products products = new Products();
				products.setId(productId);
				products = productsService.query(products);
				bs.setSubProductsName(products.getName());
			}
			this.productStructModel.setBomSubList(bomSubList);

			//查询工序列表
			List<ProcessBean> processList = processService.queryList(new ProcessBean());
			this.productStructModel.setProcessList(processList);
			String processListJson = JSONUtil.list2json(processList);
			this.productStructModel.setProcessListJson(processListJson);
			
			//产品工序列表
			ProductProcess productProcess = this.productStructModel.getProductProcess();
			productProcess.setBomPrimaryID(id);
			LOGGER.debug("ProductProcess: {}", bomSub);
			List<ProductProcess> productProcessList = productProcessService.queryList(productProcess);
			this.productStructModel.setProductProcessList(productProcessList);
			
			//判断是否生效
			if(result != null && "1".equalsIgnoreCase(result.getEffStatus())){
				return Action.VIEW;
			}
			
		}
		
		return Action.EDITOR;
	}
	
	/**
	* @Title: saveProductProcess 
	* @Description: 工序维护 
	* @param  @return   参数 
	* @return String    返回类型 
	* @throws 
	* @author taozhaoping 26078
	* @author mail taozhaoping@gmail.com
	 */
	public String saveProductProcess()
	{
		LOGGER.debug("saveProductProcess()");
		ProductProcess productProcess = this.productStructModel.getProductProcess();
		String id = this.productStructModel.getFormId();
		if (null == id || "".equals(id)) {
			// 新增
			productProcessService.insert(productProcess);
		} else {
			// 修改
			productProcess.setId(Long.valueOf(id));
			productProcessService.delete(productProcess);
		}
		return Action.EDITOR_SAVE;
	}
	
	/**
	 * 查看
	 */
	public String view() throws Exception {
		LOGGER.debug("view()");
		Long id = this.productStructModel.getId();
		if (null != id){
			//查询信息
			LOGGER.debug("view ProductStruct id " + id );
			BomPrimary bomPrimary = this.productStructModel.getBomPrimary();
			bomPrimary.setId(Long.valueOf(id));
			//查询结果
			BomPrimary result = productStructService.queryPrimary(bomPrimary);
			LOGGER.debug("query bomPrimary:{}", result);
			this.productStructModel.setBomPrimary(result);
			
			//产品结构
			BomDetail bomDetail = this.productStructModel.getBomDetail();
			bomDetail.setPrimaryId(id);
			LOGGER.debug("bomDetail: {}", bomDetail);
			List<BomDetail> bomDetailList = productStructService.queryDetailList(bomDetail);
			for(BomDetail bd : bomDetailList){
				Long productId = bd.getSubProductsId();
				Products products = new Products();
				products.setId(productId);
				products = productsService.query(products);
				bd.setSubProductsName(products.getName());
			}
			this.productStructModel.setBomDetailList(bomDetailList);
			
			//替代料列表
			BomSub bomSub = this.productStructModel.getBomSub();
			bomSub.setPrimaryId(id);
			LOGGER.debug("bomSub: {}", bomSub);
			List<BomSub> bomSubList = productStructService.querySubList(bomSub);
			for(BomSub bs : bomSubList){
				Long productId = bs.getSubProductsId();
				Products products = new Products();
				products.setId(productId);
				products = productsService.query(products);
				bs.setSubProductsName(products.getName());
			}
			this.productStructModel.setBomSubList(bomSubList);
			
			//产品工序列表
			ProductProcess productProcess = this.productStructModel.getProductProcess();
			productProcess.setBomPrimaryID(id);
			LOGGER.debug("ProductProcess: {}", bomSub);
			List<ProductProcess> productProcessList = productProcessService.queryList(productProcess);
			this.productStructModel.setProductProcessList(productProcessList);
		}
		return Action.VIEW;
	}

	/** 
	 * 保存结构主体
	 */
	public String save() throws Exception {
		LOGGER.debug("save()");
		BomPrimary bomPrimary = this.productStructModel.getBomPrimary();
		//头表的主键
		Long id = bomPrimary.getId();
		//主键为空，则是插入，不为空，更新
		if (null != id && !"".equals(id)){
			bomPrimary.setId(id);
			productStructService.updatePrimary(bomPrimary);
			LOGGER.debug("update bomPrimary:{}", bomPrimary);
		}else{
			//新增
			productStructService.insertPrimary(bomPrimary);
			LOGGER.debug("add bomPrimary:{}", bomPrimary);
		}
		this.productStructModel.setId(bomPrimary.getId());
		return Action.EDITOR_SUCCESS;
	}
	
	/** 
	 * 审核生效状态
	 */
	public String auditStatus() throws Exception {
		LOGGER.debug("auditStatus()");
		BomPrimary bomPrimary = this.productStructModel.getBomPrimary();
		//头表的主键
		Long id = bomPrimary.getId();
		//主键为空，则是插入，不为空，更新
		if (null != id && !"".equals(id)){
			//生效
			bomPrimary.setEffStatus("1");
			productStructService.updatePrimary(bomPrimary);
			LOGGER.debug("auditStatus bomPrimary:{}", bomPrimary);
		}else{
			throw new ParameterException("产品结构编号不允许为空!");
		}
		return Action.EDITOR_SUCCESS;
	}
	
	/***
	 * 添加产品结构的控制，防止添加上级死循环
	 *	4.1、不能添加本身
	 *	4.2、不能添加同一层级中已经存在的
	 *	4.3、不能添加直系的祖先
	 * @return json信息
	 */
	public String verifySaveDetail(){
		BomDetail bomDetail = this.productStructModel.getBomDetail();
		//产品id
		Long primaryId = bomDetail.getPrimaryId();
		//产品编号
		Long productsId = bomDetail.getProductsId();
		//组件编号
		Long subProductsId = bomDetail.getSubProductsId();
		//返回值
		Map<String, Object> dataMap = productStructModel.getDataMap();
		//添加本身
		if (productsId != null && productsId.equals(subProductsId)) {
			dataMap.put(ConstantService.STATUS, ConstantService.RESULT_FAILURE);
			dataMap.put(ConstantService.MESSAGE, "不允许添加自己");
			
		} else {
			BomDetail tempBomDetail = new BomDetail();
			tempBomDetail.setPrimaryId(primaryId);
			boolean bortherFlag = false;
			List<BomDetail> bortherList= productStructService.queryDetailList(tempBomDetail);
			for(BomDetail bd : bortherList ){
				//存在和兄弟相同
				if(bd.getSubProductsId().equals(subProductsId)){
					bortherFlag = true;
					break;
				}
			}
			
			if (bortherFlag) {
				//存在和兄弟节点相同
				dataMap.put(ConstantService.STATUS, ConstantService.RESULT_FAILURE);
				dataMap.put(ConstantService.MESSAGE, "不允许添加已经存在的组件");
				
			} else {
				boolean parentFlag = false;
				List<BomDetail> parentList = productStructService.queryParentList(productsId);
				for(BomDetail bd : parentList ){
					//存在和直系祖先相同
					if(bd.getProductsId().equals(subProductsId)){
						parentFlag = true;
						break;
					}
				}
				//存在和直系祖先相同
				if (parentFlag) {
					dataMap.put(ConstantService.STATUS, ConstantService.RESULT_FAILURE);
					dataMap.put(ConstantService.MESSAGE, "不允许添加上级的产品，会导致递归");
				} else {
					dataMap.put(ConstantService.STATUS, ConstantService.RESULT_SUCCESS);
					dataMap.put(ConstantService.MESSAGE, "success");
				}
			}
		}
		return "verifyDetail";
	}
	
	/** 
	 * 保存结构明细
	 */
	public String saveDetail() throws Exception {
		LOGGER.debug("saveDetail()");
		BomDetail bomDetail = this.productStructModel.getBomDetail();
		//明细表的主键
		Long id = bomDetail.getId();
		//主键为空，则是插入，不为空，更新
		if (null != id && !"".equals(id)){
			bomDetail.setId(id);
			productStructService.updateDetail(bomDetail);
			LOGGER.debug("update bomDetail:{}", bomDetail);
		}else{
			//新增
			productStructService.insertDetail(bomDetail);
			LOGGER.debug("add bomDetail:{}", bomDetail);
		}
		this.productStructModel.setId(bomDetail.getPrimaryId());
		return Action.EDITOR_SAVE;
	}
	
	/** 
	 * 删除结构明细记录
	 */
	public String deleteDetail() throws Exception {
		LOGGER.debug("deleteDetail()");
		BomDetail bomDetail = this.productStructModel.getBomDetail();
		//主表的id
		Long primaryId = bomDetail.getPrimaryId();
		//删除组件的编号
		Long subProductsId = bomDetail.getSubProductsId();
		
		//替代料 主料料号以及BOM头表的主键编号
		BomSub bomSub = new BomSub();
		bomSub.setPrimaryId(primaryId);
		bomSub.setMainProductsId(subProductsId);
		
		//明细表的主键
		Long id = bomDetail.getId();
		if (null != id && !"".equals(id)){
			bomDetail.setId(id);
			productStructService.deleteDetail(bomDetail, bomSub);
			LOGGER.debug("deleteDetail() bomDetail:{}, bomSub{}", bomDetail, bomSub);
		}else{
			LOGGER.debug("deleteDetail fail id is null");
		}
		this.productStructModel.setId(primaryId);
		return Action.EDITOR_SAVE;
	}
	
	/** 
	 * 保存主料替代料
	 */
	public String saveSub() throws Exception {
		LOGGER.debug("saveSub()");
		BomSub bomSub = this.productStructModel.getBomSub();
		//明细表的主键
		Integer id = bomSub.getId();
		//主键为空，则是插入，不为空，更新
		if (null != id && !"".equals(id)){
			bomSub.setId(id);
			productStructService.updateSub(bomSub);
			LOGGER.debug("update bomSub:{}", bomSub);
		}else{
			//新增
			productStructService.insertSub(bomSub);
			LOGGER.debug("add bomSub:{}", bomSub);
		}
		this.productStructModel.setId(bomSub.getPrimaryId());
		return Action.EDITOR_SAVE;
	}
	
	/**
	 * 5、添加替代料的控制，防止添加本身以及上级
	 * 5.1、不能添加本身
	 * 5.2、不能添加上级
	 * 5.3、不能添加同一层级中已经存在的
	 * @return
	 */
	public String verifySaveSub(){
		BomSub bomSub = this.productStructModel.getBomSub();
		Long mainProductsId = bomSub.getMainProductsId();
		Long subProductsId = bomSub.getSubProductsId();
		Long productsId = bomSub.getProductsId();
		Long primaryId = bomSub.getPrimaryId();
		//返回值
		Map<String, Object> dataMap = productStructModel.getDataMap();
		if(subProductsId != null){
			if(subProductsId.equals(mainProductsId)){
				dataMap.put(ConstantService.STATUS, ConstantService.RESULT_FAILURE);
				dataMap.put(ConstantService.MESSAGE, "不允许添加自己");
			} else if(subProductsId.equals(productsId)){
				dataMap.put(ConstantService.STATUS, ConstantService.RESULT_FAILURE);
				dataMap.put(ConstantService.MESSAGE, "不允许添加上级产品");
			} else {
				BomSub queryBomSub = new BomSub();
				queryBomSub.setMainProductsId(mainProductsId);
				queryBomSub.setPrimaryId(primaryId);
				boolean brotherFlag = false;
				List<BomSub> bortherList = productStructService.querySubList(queryBomSub);
				for(BomSub bs : bortherList){
					if(bs.getSubProductsId().equals(subProductsId)){
						brotherFlag = true;
						break;
					}
				}
				
				if (brotherFlag) {
					dataMap.put(ConstantService.STATUS, ConstantService.RESULT_FAILURE);
					dataMap.put(ConstantService.MESSAGE, "不允许添加已经存在的替代料");
				} else {
					dataMap.put(ConstantService.STATUS, ConstantService.RESULT_SUCCESS);
					dataMap.put(ConstantService.MESSAGE, "success");
				}
			}
		}else{
			dataMap.put(ConstantService.STATUS, ConstantService.RESULT_FAILURE);
			dataMap.put(ConstantService.MESSAGE, "替代料为空");
		}
		return "verifySub";
	}
	
	/** 
	 * 删除主料替代料
	 */
	public String deleteSub() throws Exception {
		LOGGER.debug("deleteSub()");
		BomSub bomSub = this.productStructModel.getBomSub();
		//主表的id
		Long primaryId = bomSub.getPrimaryId();
		//明细表的主键
		Integer id = bomSub.getId();
		if (null != id && !"".equals(id)){
			bomSub.setId(id);
			productStructService.deleteSub(bomSub);
			LOGGER.debug("deleteSub() bomSub:{}", bomSub);
		}else{
			LOGGER.debug("deleteSub fail id is null");
		}
		this.productStructModel.setId(primaryId);
		return Action.EDITOR_SAVE;
	}

	public ProductStructModel getProductStructModel() {
		return productStructModel;
	}

	public void setProductStructModel(ProductStructModel productStructModel) {
		this.productStructModel = productStructModel;
	}
	
}
