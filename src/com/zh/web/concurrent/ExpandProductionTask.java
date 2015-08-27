package com.zh.web.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zh.web.dao.ProcessingSinglePrimaryDao;

/**
 * 
* @Description: 任务单转生产任务单
* @Title: ExpandProductionTask.java 
* @Package com.zh.web.concurrent 
* @date 2015年8月27日 上午10:38:04 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
@Service
public class ExpandProductionTask implements Runnable {

	/**
	 * 销售单号 
	 */
	private Integer ProcessingSingleId;
	
	/**
	 * 日志
	 */
	private static Logger LOGGER = LoggerFactory.getLogger(ExpandProductionTask.class);
	
	@Autowired
	private ProcessingSinglePrimaryDao processingSinglePrimaryDao;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		LOGGER.debug("ExpandProductionTask run start; id:{}",ProcessingSingleId);
		try{
			processingSinglePrimaryDao.select("task_Production_task", ProcessingSingleId);
			LOGGER.debug("ExpandProductionTask run end; id:{}",ProcessingSingleId);
		}catch(Exception e){
			e.printStackTrace();
			LOGGER.error("ExpandProductionTask error; id:{}",ProcessingSingleId);
		}
	}

	public Integer getProcessingSingleId() {
		return ProcessingSingleId;
	}

	public void setProcessingSingleId(Integer processingSingleId) {
		ProcessingSingleId = processingSingleId;
	}

	public ProcessingSinglePrimaryDao getProcessingSinglePrimaryDao() {
		return processingSinglePrimaryDao;
	}

	public void setProcessingSinglePrimaryDao(
			ProcessingSinglePrimaryDao processingSinglePrimaryDao) {
		this.processingSinglePrimaryDao = processingSinglePrimaryDao;
	}

}
