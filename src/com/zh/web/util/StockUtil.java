package com.zh.web.util;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.zh.core.base.model.StockObject;
import com.zh.core.exception.ProjectException;
import com.zh.web.model.bean.LibraryDetail;
import com.zh.web.model.bean.LibraryPrimary;
import com.zh.web.model.bean.Stock;
import com.zh.web.model.bean.StorageDetail;
import com.zh.web.model.bean.StoragePrimary;
import com.zh.web.service.LibraryDetailService;
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
			stockUtil = (StockUtil) ctx.getBean("stockUtil");
		}

		return stockUtil;
	}

	public synchronized void operationStock(StockObject sockObject, String type) {

		if (type == INCREASE) {
			this.increaseStock((StoragePrimary) sockObject);
		} else if (type == REDUCE) {
			this.reduceStock((LibraryPrimary) sockObject);
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
	public synchronized void increaseStock(StoragePrimary storagePrimary) {

		StorageDetail storageDetail = new StorageDetail();
		storageDetail.setStoragePrimaryID(storagePrimary.getId());
		Integer warehouseID = storagePrimary.getWarehouseID();
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
	public synchronized void reduceStock(LibraryPrimary libraryPrimary) {

		LibraryDetail libraryDetail = new LibraryDetail();
		libraryDetail.setLibraryPrimaryID(libraryPrimary.getId());
		Integer warehouseID = libraryPrimary.getWarehouseID();
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
