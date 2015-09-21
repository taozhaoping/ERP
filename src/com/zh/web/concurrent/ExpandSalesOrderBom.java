package com.zh.web.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zh.web.dao.SalesOrderDetailDao;

/**
 * 异步 展开销售订单_明细表中的产品，并且插入到销售订单产品结构表中
 *  
 * @author 21829(cai_yingying@dahuatech.com)
 *
 * 2015年7月17日 上午10:39:30
 *
 */
@Service
public class ExpandSalesOrderBom implements Runnable {
	
	/**
	 * 销售单号 
	 */
	private Long salesOrderId;
	
	@Autowired
	private SalesOrderDetailDao salesOrderDetailDao;
	
	/**
	 * 日志
	 */
	private static Logger LOGGER = LoggerFactory.getLogger(ExpandSalesOrderBom.class);
	
	@Override
	public void run() {
		LOGGER.debug("ExpandSalesOrderBom run start; id:{}",salesOrderId);
		try{
			//展开销售订单中的BOM
			salesOrderDetailDao.select("expandSalesOrderBom", salesOrderId);
			LOGGER.debug("ExpandSalesOrderBom run end; id:{}",salesOrderId);
			
			//产品结构分解采购需求订单
			salesOrderDetailDao.select("bomPurchasingDemand", salesOrderId);
			LOGGER.debug("bomPurchasingDemand run end; id:{}",salesOrderId);
			
		}catch(Exception e){
			e.printStackTrace();
			LOGGER.error("ExpandSalesOrderBom error; id:{}",salesOrderId);
		}
	}

	public Long getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(Long salesOrderId) {
		this.salesOrderId = salesOrderId;
	}
}
