package com.zh.web.util;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.zh.core.base.model.StockObject;
import com.zh.core.exception.ProjectException;
import com.zh.web.model.bean.InventoryCountDetail;
import com.zh.web.model.bean.LibraryDetail;
import com.zh.web.model.bean.LibraryPrimary;
import com.zh.web.model.bean.MaterialRequisitionDetail;
import com.zh.web.model.bean.ProductionTask;
import com.zh.web.model.bean.Stock;
import com.zh.web.model.bean.StorageDetail;
import com.zh.web.model.bean.StoragePrimary;
import com.zh.web.service.InventoryCountDetailService;
import com.zh.web.service.LibraryDetailService;
import com.zh.web.service.MaterialRequisitionDetailService;
import com.zh.web.service.StockService;
import com.zh.web.service.StorageDetailService;

/**
 * 
 * @Title: StockUtil.java
 * @Package com.zh.web.util
 * @Description: 入库相关操作
 * @date 2015年4月14日 上午10:53:14
 * @author taozhaoping 26078
 * @author mail taozhaoping@gmail.com
 * @version V1.0
 */
public class StockUtil implements ApplicationContextAware {

	private static ApplicationContext ctx;

	private static StockUtil stockUtil;

	private static StorageDetailService storageDetailService;

	private static LibraryDetailService libraryDetailService;
	
	private static InventoryCountDetailService inventoryCountDetailService;
	
	private static MaterialRequisitionDetailService materialRequisitionDetailService;

	private static StockService stockService;

	/**
	 * 单据生效入库
	 */
	public static final String INCREASE = "INCREASE";

	/**
	 * 作废单据,减少对应库存数量
	 */
	public static final String REDUCE = "REDUCE";
	
	/**
	 * 单据生效入库
	 */
	public static final String TASK_INCREASE = "TASK_INCREASE";

	/**
	 * 领料单
	 */
	public static final String TASK_REDUCE = "TASK_REDUCE";
	
	public static final String INVENTORY_COUNT = "InventoryCount";

	/**
	 * 实现ApplicationContextAware接口的回调方法，设置上下文环境
	 * 
	 * @param applicationContext
	 * @throws BeansException
	 */
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		ctx = applicationContext;
	}

	/**
	 * 
	 * @Title: getInstance
	 * @Description: 获取实例
	 * @param @param stx
	 * @param @return 参数
	 * @return StockUtil 返回类型
	 * @throws
	 * @author taozhaoping 26078
	 * @author mail taozhaoping@gmail.com
	 */
	public synchronized static StockUtil getInstance() {
		if (stockUtil == null) {
			storageDetailService = (StorageDetailService) ctx
					.getBean("storageDetailService");
			libraryDetailService = (LibraryDetailService) ctx
					.getBean("libraryDetailService");
			stockService = (StockService) ctx.getBean("stockService");
			inventoryCountDetailService = (InventoryCountDetailService) ctx.getBean("inventoryCountDetailService");
			stockUtil = (StockUtil) ctx.getBean("stockUtil");
			materialRequisitionDetailService = (MaterialRequisitionDetailService) ctx.getBean("materialRequisitionDetailService");
			
		}

		return stockUtil;
	}
	

	public synchronized void operationStock(Integer id,Integer warehouseID, String type) {

		//出库入库
		if (type == INCREASE) {
			this.increaseStock(id,warehouseID);
		} else if (type == REDUCE) {
			this.reduceStock(id,warehouseID);
		} else if( type == INVENTORY_COUNT)
		{
			this.inventoryCount(id);
		} else if( type == TASK_REDUCE)
		{
			this.materialStock(id);
		}
		
		//生产任务出库和领料
		
	}
	
	/***
	 * 
	* @Title: inventoryCount 
	* @Description: 库存盘点入库
	* @param  @param id   库存
	* @author taozhaoping 26078
	* @author mail taozhaoping@gmail.com
	 */
	private synchronized void inventoryCount(Integer id) {
		if(id == null)
		{
			throw new ProjectException("数据库不存在该库存盘点编号");
		}
		InventoryCountDetail inventoryCountDetail = new InventoryCountDetail();
		inventoryCountDetail.setInventoryID(id);
		List<InventoryCountDetail> list = inventoryCountDetailService.queryInventoryList(inventoryCountDetail);
		for (InventoryCountDetail inventory : list) {
			Stock stock = new Stock();
			stock.setId(inventory.getStockID());
			Stock reult = stockService.query(stock);
			Float stockNumber = reult.getStockNumber();
			stockNumber = stockNumber + inventory.getChangeQuantiy();
			stock.setStockNumber(stockNumber);
			stockService.update(stock);
		}
	}

	/**
	 * 
	 * @Title: increaseStock
	 * @Description: 增加库存
	 * @param storageDetail
	 *            参数
	 * @param type
	 *            减少库存还是增加库存
	 * @return void 返回类型
	 * @throws
	 * @author taozhaoping 26078
	 * @author mail taozhaoping@gmail.com
	 */
	private synchronized void increaseStock(Integer id,Integer warehouseID) {

		StorageDetail storageDetail = new StorageDetail();
		storageDetail.setStoragePrimaryID(id);
		List<StorageDetail> storageDetailReult = storageDetailService
				.queryList(storageDetail);
		for (StorageDetail storageDetailInfo : storageDetailReult) {
			Stock stock = new Stock();
			stock.setProductsID(storageDetailInfo.getProductsID());
			stock.setWarehouseID(warehouseID);
			Integer StorageNumber = storageDetailInfo.getStorageNumber();
			Stock reult = stockService.query(stock);
			if (reult == null) {
				throw new ProjectException("数据库不存在该产品编号");
			}
			Float stockNumber = reult.getStockNumber();
			stockNumber += StorageNumber;
			stock = new Stock();
			stock.setId(reult.getId());
			stock.setStockNumber(stockNumber);
			stockService.update(stock);
		}

	}

	/***
	* @Title: 领料单出库 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param  @param productionTask   参数 
	* @return void    返回类型 
	* @throws 
	* @author taozhaoping 26078
	* @author mail taozhaoping@gmail.com
	 */
	private synchronized void materialStock(Integer id) {
		MaterialRequisitionDetail requisitionDetail = new MaterialRequisitionDetail();
		requisitionDetail.setProductiontaskId(id);
		List<MaterialRequisitionDetail> list = materialRequisitionDetailService.queryList(requisitionDetail);
		for (MaterialRequisitionDetail materialRequisitionDetail : list) {
			Stock stock = new Stock();
			stock.setProductsID(materialRequisitionDetail.getProductsId());
			Float materialNumber = materialRequisitionDetail.getMaterialNumber();
			List<Stock> reult = stockService.queryList(stock);
			for (Stock st : reult) {
				Float stockNumber = st.getStockNumber();
				stock = new Stock();
				stock.setId(st.getId());
				if(stockNumber > materialNumber)
				{
					stockNumber = stockNumber - materialNumber;
					stock.setStockNumber(stockNumber);
					stockService.update(stock);
					break;
				}else
				{
					materialNumber = materialNumber - stockNumber;
					stock.setStockNumber(0f);
					stockService.update(stock);
				}
			}
			if (reult == null) {
				throw new ProjectException("数据库不存在该产品编号");
			}
		}
	}
	
	/**
	 * 
	 * @Title: increaseStock
	 * @Description: 减少库存
	 * @param storageDetail
	 *            参数
	 * @param type
	 *            减少库存还是增加库存
	 * @return void 返回类型
	 * @throws
	 * @author taozhaoping 26078
	 * @author mail taozhaoping@gmail.com
	 */
	private synchronized void reduceStock(Integer id,Integer warehouseID) {

		LibraryDetail libraryDetail = new LibraryDetail();
		libraryDetail.setLibraryPrimaryID(id);
		libraryDetail.setWarehouseID(warehouseID);
		List<LibraryDetail> libraryDetailReult = libraryDetailService
				.queryList(libraryDetail);
		for (LibraryDetail libraryDetailInfo : libraryDetailReult) {
			Stock stock = new Stock();
			stock.setProductsID(libraryDetailInfo.getProductsID());
			stock.setWarehouseID(warehouseID);
			Integer StorageNumber = libraryDetailInfo.getStorageNumber();
			Stock reult = stockService.query(stock);
			if (reult == null) {
				throw new ProjectException("数据库不存在该产品编号");
			}
			Float stockNumber = reult.getStockNumber();

			stockNumber -= StorageNumber;
			stock = new Stock();
			stock.setId(reult.getId());
			stock.setStockNumber(stockNumber);
			stockService.update(stock);
		}

	}
}
